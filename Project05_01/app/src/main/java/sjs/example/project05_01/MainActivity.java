package sjs.example.project05_01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = new Button(this);
        btn.setText("버튼");
        //레이아웃 객체 생성 및 설정 후 인플레이팅하여 출력
        LinearLayout baseLayout = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.MATCH_PARENT , LinearLayout.LayoutParams.MATCH_PARENT);

        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setBackgroundColor(Color.rgb(100 , 149 , 237));

        setContentView(baseLayout , params);

        btn.setBackgroundColor(Color.GREEN);
        btn.setTextColor(Color.WHITE);
        baseLayout.addView(btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this , "자바코드로만 생성한 버튼" , Toast.LENGTH_SHORT).show();
            }
        });
    }
}