package sjs.example.myex10_15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txt1 , txt2 ;
    Button plus ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("메인 액티비티");

        txt1 = findViewById(R.id.edt1);
        txt2 = findViewById(R.id.edt2);
        plus = findViewById(R.id.btnplus);



        Intent intent = new Intent(MainActivity.this , SecondActivity.class);



        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent.putExtra("1" , Integer.parseInt(txt1.getText().toString()));
                intent.putExtra("2" , Integer.parseInt(txt2.getText().toString()));

            }
        });


    }
}