package com.example.mobileproject.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.mobileproject.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

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
    }
}