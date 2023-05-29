package com.example.mobileproject.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.mobileproject.R;
import com.example.mobileproject.Repository.FirestoreUserRepository;
import com.example.mobileproject.Repository.UserRepository;
import com.example.mobileproject.Repository.UserRepositoryCallback;
import com.example.mobileproject.util.DialogUtil;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class InputIdActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth; //파이어베이스 인증
    private FirebaseFirestore firestore; //firestore 데이터베이스
    private final UserRepository userRepository = new FirestoreUserRepository();

    private EditText et_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_id);

        et_id = findViewById(R.id.et_id);
        ImageButton btn_back = findViewById(R.id.btn_back);
        ImageButton btn_ok = findViewById(R.id.btn_ok);

        firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        //확인 버튼 클릭 시
        btn_ok.setOnClickListener(v -> {
            String strId = et_id.getText().toString();
            if (strId.isEmpty()) {
                DialogUtil.showAlertDialog(InputIdActivity.this, "비밀번호 찾기", "아이디를 입력해주세요!", null);
            } else {
                userRepository.findUserByField("id", strId, "passwordHint", new UserRepositoryCallback() {
                    @Override
                    public void onUserFound(String foundField) {
                        Intent intent = new Intent(InputIdActivity.this, HintAnswerActivity.class);
                        intent.putExtra("id", strId);
                        intent.putExtra("pwHint", foundField);
                        startActivity(intent);
                    }
                    @Override
                    public void onUserNotFound(String errorMessage) {
                        DialogUtil.showAlertDialog(InputIdActivity.this, "비밀번호 찾기", errorMessage, null);
                        Log.d("InputIdActivity", errorMessage);
                    }
                });
            }
        });

        //뒤로가기 버튼 클릭 시 - 로그인 화면으로 이동
        btn_back.setOnClickListener(v -> {
            Intent BackIntent = new Intent(InputIdActivity.this, LoginActivity.class);
            startActivity(BackIntent);
        });
    }
}