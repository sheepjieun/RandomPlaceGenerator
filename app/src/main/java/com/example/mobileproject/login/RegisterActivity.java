package com.example.mobileproject.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobileproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth; //파이어베이스 인증
    private FirebaseFirestore firestore; //firestore 데이터베이스
    //회원가입 입력필드
    private EditText et_id;
    private EditText et_password, et_retryPassword;
    private EditText et_phoneNumber, et_nickname;
    private EditText et_hint, et_hintAnswer;
    //뒤로가기, 아이디중복확인, 회원가입 버튼
    private Button btn_back, btn_checkId, btn_registerOK;
    Boolean checkId = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        et_id = findViewById(R.id.et_id);
        et_password = findViewById(R.id.et_password);
        et_retryPassword = findViewById(R.id.et_retryPassword);
        et_phoneNumber = findViewById(R.id.et_phoneNumber);
        et_nickname = findViewById(R.id.et_nickname);
        et_hint = findViewById(R.id.et_hint);
        et_hintAnswer = findViewById(R.id.et_hintAnswer);

        AlertDialog.Builder dlg = new AlertDialog.Builder(RegisterActivity.this);

        //뒤로가기 버튼 클릭 시 - 로그인 화면으로 이동
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        //중복 확인 버튼 클릭 시
        btn_checkId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //et_id와 firebase 사용자 계정 중복 여부 확인
                String strId = et_id.getText().toString();

                dlg.setTitle("아이디 중복확인");
                dlg.create();

                //Firestore에서 등록된 이메일들을 확인하여 중복 여부 확인
                firestore.collection("UserAccount")
                        .whereEqualTo("id", strId)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    if (task.getResult().isEmpty()) {
                                        // 중복되지 않은 이메일인 경우
                                        dlg.setMessage("사용할 수 있는 이메일입니다.");
                                        checkId = true;
                                    } else {
                                        // 중복된 이메일인 경우
                                        dlg.setMessage("중복된 이메일입니다.");
                                        checkId = false;
                                    }
                                } else {
                                    Log.d("RegisterActivitiy", "중복확인실패: ", task.getException());
                                    dlg.setMessage("중복 확인에 실패하였습니다.");
                                }
                            }
                        });
                dlg.show();
            }
        });


        //동의하고 가입하기 버튼 클릭 시
        btn_registerOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO if (중복확인 안 되었으면) 대화상자 띄우기 '아이디 중복확인은 필수입니다!' [확인]
                //TODO if (et_password == et_retryPassword 일 때만)

                if (checkId == false) {
                    dlg.setMessage("아이디 중복확인은 필수입니다!");
                } else {
                    if (et_password != et_retryPassword) {
                        dlg.setTitle("비밀번호 확인");
                        dlg.setMessage("비밀번호를 다시 한 번 확인하십시오.");
                    } else {
                        String strId = et_id.getText().toString();
                        String strPw = et_password.getText().toString();
                        String strPhoneNumber = et_phoneNumber.getText().toString();
                        String strNickname = et_nickname.getText().toString();
                        String strPasswordHint = et_hint.getText().toString();
                        String strPasswordHintAnswer = et_hintAnswer.getText().toString();

                        //Firebase Auth 진행
                        firebaseAuth.createUserWithEmailAndPassword(strId, strPw)
                                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) { //task:회원가입 처리 후 결과값을 task으로 대입
                                        //인증처리 완료 되었을 때 (회원가입 성공 시)
                                        if (task.isSuccessful()) {
                                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser(); //현재 firebase 로그인 된 유저 객체를 가져옴

                                            String userUID = firebaseUser.getUid();
                                            UserAccount account = new UserAccount();
                                            account.setIdToken(firebaseUser.getUid()); //firebase 고유의 UID 설정
                                            account.setId(firebaseUser.getEmail()); //로그인된 유저 기준으로 getEmail()
                                            account.setPassword(strPw); //사용자가 입력한 것을 이용해서 그대로 가져옴
                                            account.setPhoneNumber(strPhoneNumber);
                                            account.setNickname(strNickname);
                                            account.setPasswordHint(strPasswordHint);
                                            account.setPasswordHintAnswer(strPasswordHintAnswer);

                                            //Firestore에 데이터 추가
                                            firestore.collection("UserAccount")
                                                    .document(userUID)
                                                    .set(account)
                                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            if (task.isSuccessful()) {
                                                                Toast.makeText(RegisterActivity.this, "회원가입에 성공하셨습니다.", Toast.LENGTH_SHORT).show();
                                                            } else {
                                                                Toast.makeText(RegisterActivity.this, "회원가입에 실패하셨습니다.", Toast.LENGTH_SHORT).show();
                                                            }
                                                        }
                                                    });
                                        } else {
                                            Toast.makeText(RegisterActivity.this, "회원가입에 실패하셨습니다.", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    } //비밀번호 재확인 else 끝
                }
            }
        });
    }
}