package com.example.mobileproject.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mobileproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class FindIdActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth; //파이어베이스 인증
    private FirebaseFirestore firestore; //firestore 데이터베이스
    private EditText et_phoneNumber;

    private Button btn_back, btn_findId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id);

        //et_phoneNumber - firebase 사용자 계정 추가정보 중복 여부 확인
        String strPhoneNumber = et_phoneNumber.getText().toString();

        //아이디 찾기 버튼 클릭 시
        btn_findId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Firestore에서 등록된 핸드폰번호를 확인하여 가입 여부 확인
                firestore.collection("UserAccount")
                        .whereEqualTo("phoneNumber", strPhoneNumber)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {

                                } else {
                                    Log.d("FindIdActivity", "아이디 찾기 실패 : ", task.getException());
                                }
                            }
                        });
            }
        });





        //뒤로가기 버튼 클릭 시 - 로그인 화면으로 이동
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindIdActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}