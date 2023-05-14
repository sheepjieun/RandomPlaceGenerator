package sjs.example.project0401_2021081048;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edit1 , edit2;
    Button btn_plus , btn_minus , btn_multi , btn_div;
    TextView txt_result;
    String num1 , num2;
    Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기"); //앱의 이름 설정
        //뷰변수에 인플레이팅하여 대입
        edit1 = findViewById(R.id.n1);
        edit2 = findViewById(R.id.n2);
        btn_plus = findViewById(R.id.plus);
        btn_minus = findViewById(R.id.minus);
        btn_multi = findViewById(R.id.multi);
        btn_div = findViewById(R.id.div);
        txt_result = findViewById(R.id.result);


        btn_plus.setOnTouchListener(new View.OnTouchListener() {
            //더하기 버튼 터치 메소드
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) + Integer.parseInt(num2);

                txt_result.setText("계산결과 : " + result.toString());

                return false;
            }
        });

        btn_minus.setOnTouchListener(new View.OnTouchListener() {
            //빼기 버튼 터치 메소드
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) - Integer.parseInt(num2);

                txt_result.setText("계산결과 : " + result.toString());

                return false;
            }
        });

        btn_multi.setOnTouchListener(new View.OnTouchListener() {
            //곱하기 버튼 터치 메소드
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) * Integer.parseInt(num2);

                txt_result.setText("계산결과 : " + result.toString());

                return false;
            }
        });

        btn_div.setOnTouchListener(new View.OnTouchListener() {
            //나누기 버튼 터치 메소드
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                // String형 숫자를 정수형으로 변환 후 계산

                txt_result.setText("계산결과 : " + result.toString());

                return false;

            }
        });
    }

}