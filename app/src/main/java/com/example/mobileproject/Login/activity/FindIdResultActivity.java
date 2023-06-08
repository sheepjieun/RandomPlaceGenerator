package com.example.mobileproject.Login.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mobileproject.R;
import com.example.mobileproject.Repository.FindField;
import com.example.mobileproject.Repository.FindFieldInterface;
import com.example.mobileproject.Repository.FindFiledCallback;
import com.example.mobileproject.util.DialogUtil;

public class FindIdResultActivity extends AppCompatActivity {

    private TextView tv_content;
    private ImageButton btn_ok, btn_findPassword;
    private final FindFieldInterface findFieldInterface = new FindField();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id_result);

        tv_content = findViewById(R.id.tv_content);
        btn_ok = findViewById(R.id.btn_ok);
        btn_findPassword = findViewById(R.id.btn_findPassword);

        // FindIdActivity에서 전달된 값 받기
        Intent intent = getIntent();
        String foundId = intent.getStringExtra("id");

        // tv_content에 값 설정
        if (foundId != null) {
            tv_content.setText("회원님의 아이디는 : " + foundId + " 입니다.");
        } else {
            tv_content.setText("아이디를 찾을 수 없습니다.");
        }

        //뒤로가기 버튼 클릭 시 - 로그인 화면으로 이동
        btn_ok.setOnClickListener(v -> {
            Intent BackIntent = new Intent(FindIdResultActivity.this, LoginActivity.class);
            startActivity(BackIntent);
        });

        //비밀번호 찾기 버튼 클릭 시
        btn_findPassword.setOnClickListener(v -> {
            findFieldInterface.findUserByField("id", foundId, "passwordHint", new FindFiledCallback() {
                @Override
                public void onUserFound(String foundField) {
                    Intent intent = new Intent(FindIdResultActivity.this, HintAnswerActivity.class);
                    intent.putExtra("id", foundId);
                    intent.putExtra("pwHint", foundField);
                    startActivity(intent);
                }
                @Override
                public void onUserNotFound(String errorMessage) {
                    DialogUtil.showAlertDialog(FindIdResultActivity.this, "비밀번호 찾기", errorMessage, null);
                    Log.d("InputIdActivity", errorMessage);
                }
            });
        });
    }
}