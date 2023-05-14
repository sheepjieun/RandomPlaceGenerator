package sjs.example.baseapprev;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnMsg;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMsg = findViewById(R.id.btnMsg);

        Listner listner = new Listner();
        btnMsg.setOnClickListener(listner);
    }

    public class Listner implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this , "버튼이 클릭되었습니다." , Toast.LENGTH_SHORT).show();
        }
    }

}
