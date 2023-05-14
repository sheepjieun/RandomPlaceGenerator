package sjs.example.myex10_15;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        int hapvalue = intent.getIntExtra("1" , 0) + intent.getIntExtra("2",0);


        Toast.makeText(SecondActivity.this , "결과 :" + hapvalue,Toast.LENGTH_SHORT).show();

        Button back = findViewById(R.id.btnback);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }
}
