package sjs.example.ex06_15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    Button btnPrev , btnNext;
    ViewFlipper vF1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);

        vF1 = findViewById(R.id.vF1);



    }

    public void clicked(View v){
        if (v.equals(btnNext) ){
            vF1.showNext();
        }
        else if(v.equals(btnPrev)) {
            vF1.showPrevious();
        }

    }
}