package sjs.example.project06_01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Button btnstart , btnend;
    RadioGroup rgroup;
    RadioButton rdate , rtime;
    Chronometer chrono;
    TimePicker tpicker;
    CalendarView cal;
    TextView tvReserved;

    int selectYear , selectMonth , selectDay;
    //초기값으로 당일 날짜 값 받기

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("시간 예약");

        btnstart = findViewById(R.id.start);
        btnend = findViewById(R.id.end);
        rgroup = findViewById(R.id.rgroup);
        rdate = findViewById(R.id.Calendarview);
        rtime = findViewById(R.id.TimePicker);
        chrono = findViewById(R.id.chronometer1);
        tpicker = findViewById(R.id.TimePicker1);
        cal = findViewById(R.id.Calendar);

        tpicker.setVisibility(View.INVISIBLE);
        cal.setVisibility(View.INVISIBLE);

        rdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rdate.isChecked()) {
                    cal.setVisibility(View.VISIBLE);
                    tpicker.setVisibility(View.INVISIBLE);
                }
            }
        });

        rtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rtime.isChecked()){
                    cal.setVisibility(View.INVISIBLE);
                    tpicker.setVisibility(View.VISIBLE);
                }
            }
        });

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.parseColor("#FF0000"));

            }
        });

        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {

                selectYear = year;
                selectMonth = month + 1;
                selectDay = day;

            }
        });
        btnend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                tvReserved.setText("에약현황: "
                        + Integer.toString(selectYear) +"년 "
                        + Integer.toString(selectMonth) +"월 "
                        + Integer.toString(selectDay) + "일");
            }
        });

    }
}