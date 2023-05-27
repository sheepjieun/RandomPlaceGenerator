package com.example.mobileproject.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mobileproject.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class HintAnswerActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth; //파이어베이스 인증
    private FirebaseFirestore firestore; //firestore 데이터베이스

    private TextView tv_id, tv_hint;
    private EditText et_hintAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint_answer);

        et_hintAnswer = findViewById(R.id.et_hintAnswer);
        ImageButton btn_back = findViewById(R.id.btn_back);
        ImageButton btn_ok = findViewById(R.id.btn_ok);
        tv_id = findViewById(R.id.tv_id);
        tv_hint = findViewById(R.id.tv_hint);

        firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        // InputIdActivity에서 전달된 ID값 받기
        Intent intent = getIntent();
        String foundId = intent.getStringExtra("id");

        tv_id.setText(foundId);

        // Firestore에서 해당 ID의 문서를 찾아 passwordHint 필드의 값을 가져와서 TextView에 설정
        firestore.collection("UserAccount")
                .whereEqualTo("id", foundId)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult() != null && !task.getResult().isEmpty()) {
                        DocumentSnapshot document = task.getResult().getDocuments().get(0);
                        String passwordHint = document.getString("passwordHint");
                        tv_hint.setText(passwordHint);
                    } else {
                        // 해당 문서를 찾지 못한 경우 또는 passwordHint 필드가 없는 경우
                        tv_hint.setText("No password hint found");
                        Log.d("HintAnswerActivity", "password is not found");
                    }
                });

        // 뒤로가기 버튼 클릭 시 - 이전 화면인 InputIdActivity로 돌아감
        btn_back.setOnClickListener(v -> onBackPressed());

        // 확인 버튼 클릭 시
        btn_ok.setOnClickListener(v -> {
            // TODO: 힌트 답변 확인 및 처리
            //TODO 1. et_hintAnswer String으로 변환
            //TODO 2. hintAnswer와 필드값  passwordHintAnswer가 같은지 비교
            //TODO 3. 같으면 다음 activity ResetPasswordActivity로 id값 intent 값 넘겨서 이동
            //TODO 4. 다르면 대화상자 출력 "힌트 답변이 일치하지 않습니다!"

            String hintAnswer = et_hintAnswer.getText().toString();

            // Firestore에서 해당 ID의 문서를 찾아 passwordHintAnswer 필드의 값과 입력한 힌트 답변을 비교
            firestore.collection("UserAccount")
                    .whereEqualTo("id", foundId)
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful() && task.getResult() != null && !task.getResult().isEmpty()) {
                            DocumentSnapshot document = task.getResult().getDocuments().get(0);
                            String passwordHintAnswer = document.getString("passwordHintAnswer");
                            if (passwordHintAnswer.equals(hintAnswer)) {
                                // 힌트 답변이 일치하는 경우
                                // 다음 액티비티로 ID 값을 전달
                                Intent resetPasswordIntent = new Intent(HintAnswerActivity.this, ResetPasswordActivity.class);
                                resetPasswordIntent.putExtra("id", foundId);
                                startActivity(resetPasswordIntent);
                                finish(); // 현재 액티비티 종료
                            } else {
                                // 힌트 답변이 일치하지 않는 경우
                                // 대화상자 출력 "힌트 답변이 일치하지 않습니다!"
                                AlertDialog.Builder builder = new AlertDialog.Builder(HintAnswerActivity.this);
                                builder.setTitle("알림")
                                        .setMessage("힌트 답변이 일치하지 않습니다!")
                                        .setPositiveButton("확인", null)
                                        .show();
                            }
                        } else {
                            // 해당 문서를 찾지 못한 경우 또는 passwordHintAnswer 필드가 없는 경우
                            tv_hint.setText("No password hint found");
                            Log.d("HintAnswerActivity", "password is not found");
                        }
                    });
        });
    }
}