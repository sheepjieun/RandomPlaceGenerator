package sjs.example.project10_12;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ResultActivity extends Activity {

    Button back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_result);
        setTitle("투표 결과");

        Intent intent = getIntent();
        int voteResult[] = intent.getIntArrayExtra("VoteCount");
        String imgname[] = intent.getStringArrayExtra("Imgname");

        TextView tv[] = new TextView[imgname.length];
        RatingBar rbar[] = new RatingBar[imgname.length];
        Integer tvID[] = {R.id.tv1 , R.id.tv2 , R.id.tv3 , R.id.tv4 ,
                              R.id.tv5 , R.id.tv6 , R.id.tv7 , R.id.tv8 , R.id.tv9  } ;
        Integer rbarID[] = {R.id.rbar1 , R.id.rbar2 , R.id.rbar3 , R.id.rbar4 , R.id.rbar5
                                    , R.id.rbar6 , R.id.rbar7 , R.id.rbar8 , R.id.rbar9 };

        for (int i = 0; i < tvID.length; i++){
            tv[i] = (TextView) findViewById(tvID[i]);
            rbar[i] = (RatingBar) findViewById(rbarID[i]);


            tv[i].setText(imgname[i]);
            rbar[i].setRating(voteResult[i]);
        }



        back = findViewById(R.id.btnReturn);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}
