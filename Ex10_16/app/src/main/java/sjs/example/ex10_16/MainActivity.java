package sjs.example.ex10_16;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txt1 , txt2;
    Button plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.edt1);
        txt2 = findViewById(R.id.edt2);
        plus = findViewById(R.id.plus);

        Intent intent = new Intent(MainActivity.this , Second.class);


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent.putExtra("1" , Integer.parseInt(txt1.getText().toString()));
                intent.putExtra("2" , Integer.parseInt(txt2.getText().toString()));


                startActivityForResult(intent , 0);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){

            int result = data.getIntExtra("hapv" , 0);

            Toast.makeText(this , "합계 : " + result ,Toast.LENGTH_SHORT).show();
        }

    }
}