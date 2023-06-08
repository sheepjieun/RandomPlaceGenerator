package com.example.mobileproject.Login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.mobileproject.Home.activity.MainActivity;
import com.example.mobileproject.R;
import com.example.mobileproject.baseactivity.BaseActivity;

public class TestLoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_login);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(TestLoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); //로그인 완료 시 현재 액티비티 파괴
        });
    }
}