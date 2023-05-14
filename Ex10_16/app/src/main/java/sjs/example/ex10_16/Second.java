package sjs.example.ex10_16;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Second extends AppCompatActivity {

    Button back;
    int hapv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        back = findViewById(R.id.back);

        Intent intent = getIntent();

        hapv = intent.getIntExtra("1" , 0) + intent.getIntExtra("2" , 0);

        Toast.makeText(Second.this , "합계 : " + hapv , Toast.LENGTH_SHORT).show();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent out = new Intent(Second.this , MainActivity.class);

                out.putExtra("hapv" , hapv);
                setResult(RESULT_OK , out);
                finish();
            }
        });

    }
}
