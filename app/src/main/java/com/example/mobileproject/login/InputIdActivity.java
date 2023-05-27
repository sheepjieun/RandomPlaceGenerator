package com.example.mobileproject.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.mobileproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class InputIdActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth; //파이어베이스 인증
    private FirebaseFirestore firestore; //firestore 데이터베이스
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
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Firestore에서 등록된 핸드폰번호를 확인하여 가입 여부 확인
                String strId = et_id.getText().toString();
                firestore.collection("UserAccount")
                        .whereEqualTo("id", strId)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    QuerySnapshot querySnapshot = task.getResult();
                                    if (task.getResult() != null && !task.getResult().isEmpty()) {
                                        DocumentSnapshot document = querySnapshot.getDocuments().get(0);
                                        String id = document.getString("id");
                                        if (id != null) {
                                            Intent intent = new Intent(InputIdActivity.this, HintAnswerActivity.class);
                                            intent.putExtra("id", id);
                                            startActivity(intent);
                                        } else {
                                            Log.d("InputIdActivity", "ID not found");
                                        }
                                    } else {
                                        Log.d("InputIdActivity", "아이디 찾기 실패 : ", task.getException());
                                    }
                                }else {
                                    Log.d("InputIdActivity", "Failed to find ID", task.getException());
                                }
                            }
                        });
            }
        });

        //뒤로가기 버튼 클릭 시 - 로그인 화면으로 이동
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InputIdActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}