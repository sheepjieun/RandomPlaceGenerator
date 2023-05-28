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

public class FindIdActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth; //파이어베이스 인증
    private FirebaseFirestore firestore; //firestore 데이터베이스
    private EditText et_phoneNumber;

    private final UserRepository userRepository = new FirestoreUserRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id);

        et_phoneNumber = findViewById(R.id.et_phoneNumber);
        ImageButton btn_findId = findViewById(R.id.btn_findId);
        ImageButton btn_back = findViewById(R.id.btn_back);

        firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        //아이디 찾기 버튼 클릭 시
        btn_findId.setOnClickListener(v->{
            //Firestore에서 등록된 핸드폰번호를 확인하여 가입 여부 확인
            String strPhoneNumber = et_phoneNumber.getText().toString();
            if (strPhoneNumber.isEmpty()) {
                DialogUtil.showAlertDialog(FindIdActivity.this, "아이디 찾기", "휴대폰 번호를 입력해주세요!", null);
            } else {
                userRepository.findUserByField("phoneNumber", strPhoneNumber, "id", new UserRepositoryCallback() {
                    @Override
                    public void onUserFound(String foundField) {
                        Intent intent = new Intent(FindIdActivity.this, FindIdResultActivity.class);
                        intent.putExtra("id", foundField);
                        startActivity(intent);
                    }
                    @Override
                    public void onUserNotFound(String errorMessage) {
                        DialogUtil.showAlertDialog(FindIdActivity.this, "아이디 찾기", "해당하는 휴대폰 번호가 없습니다.", null);
                        Log.d("FindIdActivity", "Failed to find ID: " + errorMessage);
                    }
                });
            }
        });
        //뒤로가기 버튼 클릭 시 - 로그인 화면으로 이동
        btn_back.setOnClickListener(v -> {
            Intent BackIntent = new Intent(FindIdActivity.this, LoginActivity.class);
            startActivity(BackIntent);
        });
    }
}