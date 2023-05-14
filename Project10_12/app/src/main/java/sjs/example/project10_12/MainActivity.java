package sjs.example.project10_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button end;
    int voteCount[] = new int[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        end = findViewById(R.id.btnResult);

        setTitle("명화 선호도 투표");
        Toast.makeText(this , "선호하는 명화에 투표한 후 " + '\n' +"투표가 끝나면 투표 종료를 눌러주세요" ,Toast.LENGTH_SHORT).show();

        for (int i = 0 ; i < voteCount.length; i++){
            voteCount[i] = 0;
        }

        ImageView img[] = new ImageView[9];
        Integer imgid[] = {R.id.iv1 , R.id.iv2 , R.id.iv3 , R.id.iv4 , R.id.iv5 ,R.id.iv6 ,
                             R.id.iv7 , R.id.iv8 , R.id.iv9 };

        final String imgname[] = {"독서하는 소녀" , "꽃장식 모자 소녀" , "부채를 든 소녀"
                                    , "이레느깡 단 베르양" , "잠자는 소녀" , "테라스의 두 자매"
                                    ,"피아노 레슨" , "피아노 앞의 소녀들" , "해변에서"};

        for (int i = 0; i < imgid.length; i++){
            final int index;

            index = i;
            img[index] = (ImageView) findViewById(imgid[index]);
            img[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    voteCount[index]++;

                    Toast.makeText(MainActivity.this , "명화 : "+ imgname[index] + " 투표수"+ voteCount[index] +"증가" , Toast.LENGTH_SHORT).show();

                }
            });
        }

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent inint = new Intent(MainActivity.this , ResultActivity.class);

                inint.putExtra("VoteCount" , voteCount);
                inint.putExtra("Imgname" , imgname);
                startActivity(inint);

            }
        });




    }
}