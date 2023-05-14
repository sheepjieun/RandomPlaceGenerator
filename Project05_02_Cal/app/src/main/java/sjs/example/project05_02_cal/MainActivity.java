package sjs.example.project05_02_cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edit1 , edit2;
    Button btnAdd , btnSub , btnMul , btnDiv;
    TextView txtresult;
    String num1 , num2;
    Integer result;

    Button[] numbtns = new Button[10];
    int[] btnID = {R.id.btnnNum0,R.id.btnnNum1,R.id.btnnNum2,R.id.btnnNum3,R.id.btnnNum4,R.id.btnnNum5,R.id.btnnNum6,
            R.id.btnnNum7,R.id.btnnNum8,R.id.btnnNum9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("테이블 레이아웃 계산기");

        edit1 = findViewById(R.id.Edit1);
        edit2 = findViewById(R.id.Edit2);

        for (int i = 0; i < numbtns.length; i++){
            numbtns[i] = findViewById(btnID[i]);
        }

        btnAdd = findViewById(R.id.btnnAdd);
        btnSub = findViewById(R.id.btnnSub);
        btnMul = findViewById(R.id.btnnMul);
        btnDiv = findViewById(R.id.btnnDiv);

        txtresult = findViewById(R.id.TextResult);

        onTouchEx ot = new onTouchEx();
        btnAdd.setOnTouchListener(ot);
        btnSub.setOnTouchListener(ot);
        btnMul.setOnTouchListener(ot);
        btnDiv.setOnTouchListener(ot);

        for (int i = 0; i < numbtns.length; i++){

            final int index = i;

            numbtns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(edit1.isFocused()) {
                        edit1.append(numbtns[index].getText().toString());
                    }
                    else if(edit2.isFocused()){
                        edit2.append(numbtns[index].getText().toString());
                    }
                }
            });
        }
    }
    class onTouchEx implements View.OnTouchListener{
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            switch(view.getId()){
                case R.id.btnnAdd:result = Integer.parseInt(num1) + Integer.parseInt(num2); break;
                case R.id.btnnSub:result = Integer.parseInt(num1) - Integer.parseInt(num2); break;
                case R.id.btnnMul:result = Integer.parseInt(num1) * Integer.parseInt(num2); break;
                case R.id.btnnDiv:result = Integer.parseInt(num1) / Integer.parseInt(num2); break;
            }
            txtresult.setText("계산결과 : " + result.toString());
            return false;
        }
    }
}