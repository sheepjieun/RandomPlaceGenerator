package sjs.example.baseapp02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnMsg;//전역변수 선언(버튼뷰 변수)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //버튼형 뷰변수에 버튼 뷰를 인플레이팅하여 대입
        btnMsg = findViewById(R.id.btnMsg);

        //클릭리스너를 버튼뷰에 설정

        //*
        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //이벤트 처리 구문 작성
                Toast.makeText(MainActivity.this, "버튼을 누르셨네요",
                        Toast.LENGTH_SHORT).show();
            }
        }); //*     클릭리스너의 추상메소드를 오버라이딩 처리
    }
}