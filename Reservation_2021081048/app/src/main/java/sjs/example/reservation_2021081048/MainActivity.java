package sjs.example.reservation_2021081048;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView auto;
    Button poster , next , back;
    TimePicker tp;
    TextView txt;
    ViewFlipper vf[] = new ViewFlipper[4];
    String name , date , min;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = {"12월5일 블랙팬서" , "12월6일 블랙팬서"
                , "12월7일 블랙팬서" , "12월5일 올빼미" , "12월6일 올빼미" , "12월7일 올빼미"
                ,"12월5일 압꾸정" , "12월6일 압꾸정" , "12월7일 압꾸정" , "12월4일 유포자들"
                , "12월6일 유포자들" , ""};

        auto = findViewById(R.id.autoCompleteTextView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
        auto.setAdapter(adapter);

        setTitle("영화예약(2021081048,선지성)");

        poster = findViewById(R.id.btnposter);
        next = findViewById(R.id.btnnext);
        back = findViewById(R.id.btnback);
        tp = findViewById(R.id.TimePicker1);
        txt = findViewById(R.id.txt);

        vf[0] = findViewById(R.id.viewflipper1);
        vf[1] = findViewById(R.id.viewflipper2);
        vf[2] = findViewById(R.id.viewflipper3);
        vf[3] = findViewById(R.id.viewflipper4);

        poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1달이 1일부터 최대 31일까지여서
                if (auto.getText().toString().equals(items)){


                for(int i = 1; i <= 31; i++) {


                    if (auto.getText().toString().equals("12월" + i + "일 블랙팬서")) {

                        vf[0].setVisibility(View.VISIBLE);
                        next.setVisibility(View.VISIBLE);
                        back.setVisibility(View.VISIBLE);
                        tp.setVisibility(View.VISIBLE);
                        txt.setVisibility(View.VISIBLE);

                        name = "블랙팬서";

                        for (int k = 0; k < vf.length; k++) {

                            if (vf[k] != vf[0]) {
                                vf[k].setVisibility(View.INVISIBLE);
                            }

                        }

                        for (int j = 1; j <= 31; j++) {
                            if (i == j) {
                                i = j;
                            }
                        }
                        date = "12월" + i + "일";
                    } else if (auto.getText().toString().equals("12월" + i + "일 올빼미")) {

                        vf[1].setVisibility(View.VISIBLE);
                        next.setVisibility(View.VISIBLE);
                        back.setVisibility(View.VISIBLE);
                        tp.setVisibility(View.VISIBLE);
                        txt.setVisibility(View.VISIBLE);

                        name = "올빼미";
                        for (int k = 0; k < vf.length; k++) {

                            if (vf[k] != vf[1]) {
                                vf[k].setVisibility(View.INVISIBLE);
                            }

                        }

                        for (int j = 1; j <= 31; j++) {
                            if (i == j) {
                                i = j;
                            }
                        }
                        date = "12월" + i + "일";
                    } else if (auto.getText().toString().equals("12월" + i + "일 압꾸정")) {

                        vf[2].setVisibility(View.VISIBLE);
                        next.setVisibility(View.VISIBLE);
                        back.setVisibility(View.VISIBLE);
                        tp.setVisibility(View.VISIBLE);
                        txt.setVisibility(View.VISIBLE);

                        name = "압꾸정";
                        for (int k = 0; k < vf.length; k++) {

                            if (vf[k] != vf[2]) {
                                vf[k].setVisibility(View.INVISIBLE);
                            }

                        }

                        for (int j = 1; j <= 31; j++) {
                            if (i == j) {
                                i = j;
                            }
                        }
                        date = "12월" + i + "일";
                    } else if (auto.getText().toString().equals("12월" + i + "일 유포자들")) {

                        vf[3].setVisibility(View.VISIBLE);
                        next.setVisibility(View.VISIBLE);
                        back.setVisibility(View.VISIBLE);
                        tp.setVisibility(View.VISIBLE);
                        txt.setVisibility(View.VISIBLE);

                        name = "유포자들";

                        for (int k = 0; k < vf.length; k++) {

                            if (vf[k] != vf[3]) {
                                vf[k].setVisibility(View.INVISIBLE);
                            }

                        }

                        for (int j = 1; j <= 31; j++) {
                            if (i == j) {
                                i = j;
                            }
                        }
                        date = "12월" + i + "일";
                    } else if (auto.getText().toString().equals("")) {


                        for (int k = 0; k < vf.length; k++) {

                            vf[k].setVisibility(View.INVISIBLE);
                        }



                    }
                }

                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i = 0; i < vf.length; i++){

                    for (int j = 0; j < vf.length; j++){
                        if (i == j){
                            vf[j].showNext();
                        }
                    }
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i = 0; i < vf.length; i++){

                    for (int j = 0; j < vf.length; j++){
                        if (i == j){
                            vf[j].showPrevious();
                        }
                    }
                }
            }
        });

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int h, int m) {

                String min = "";
                String hour = "";
                for(int i = 0 ; i <= 9; i++){
                    if( m == 0 + i){
                        min = "0" + i;
                        break;
                    }
                    else{
                        min = Integer.toString(m);
                    }
                }
                for (int i = 0; i <= 9; i++){
                    if (h == i){
                        hour = "0" + i;
                        break;
                    }
                    else{
                        hour = Integer.toString(h);
                    }
                }

                txt.setText(name + ": " + date + " " + hour +"시 " + min +"분으로 " + "예약되었습니다.");

            }
        });

    }


}

