package sjs.example.project0402;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(2021081048+"선지성");

        TextView txt1 , txt2;
        Switch touch;
        RadioGroup rgroup1;
        RadioButton and9 , and10 , and11;
        ImageView and , and1;
        Button reset , exit;

        touch = findViewById(R.id.start);
        txt2 = findViewById(R.id.txt2);
        rgroup1 = findViewById(R.id.rgroup1);
        and9 = findViewById(R.id.and9);
        and10 = findViewById(R.id.and10);
        and11 = findViewById(R.id.and11);
        and = findViewById(R.id.and);
        exit = findViewById(R.id.stop);
        reset = findViewById(R.id.reset);



        touch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (touch.isChecked()) {
                    txt2.setVisibility(View.VISIBLE);
                    rgroup1.setVisibility(View.VISIBLE);
                    and.setVisibility(View.VISIBLE);
                    exit.setVisibility(View.VISIBLE);
                    reset.setVisibility(View.VISIBLE);
                }
                else {
                    txt2.setVisibility(View.INVISIBLE);
                    rgroup1.setVisibility(View.INVISIBLE);
                    rgroup1.clearCheck();
                    and.setVisibility(View.GONE);
                    and.setImageBitmap(null);
                    exit.setVisibility(View.INVISIBLE);
                    reset.setVisibility(View.INVISIBLE);
                }
            }
        });
        rgroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(and9.isChecked()){
                    and.setImageResource(R.drawable.api43);
                }
                else if(and10.isChecked()){
                    and.setImageResource(R.drawable.api44);
                }
                else {
                    and.setImageResource(R.drawable.api50);
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rgroup1.clearCheck();
                and.setImageBitmap(null);
            }
        });

    }
}