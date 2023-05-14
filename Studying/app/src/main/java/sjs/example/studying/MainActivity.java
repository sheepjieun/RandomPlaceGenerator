package sjs.example.project04_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("애완동물 사진 보기");

        TextView txt1, txt2;
        CheckBox chk;
        RadioGroup rgroup1;
        RadioButton dog, cat, rabbit;
        ImageButton ok;
        ImageView imgPet;

        chk = findViewById(R.id.start);
        txt2 = findViewById(R.id.txt2);
        rgroup1 = findViewById(R.id.rgroup1);
        dog = findViewById(R.id.dog);
        cat = findViewById(R.id.cat);
        rabbit = findViewById(R.id.rabbit);
        ok = findViewById(R.id.ok);
        imgPet = findViewById(R.id.imgPet);

        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chk.isChecked()) {
                    txt2.setVisibility(View.VISIBLE);
                    rgroup1.setVisibility(View.VISIBLE);
                    ok.setVisibility(View.VISIBLE);
                } else {
                    txt2.setVisibility(View.INVISIBLE);
                    rgroup1.setVisibility(View.INVISIBLE);
                    ok.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                    rgroup1.clearCheck();
                    imgPet.setImageBitmap(null);

                }
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dog.isChecked()) {
                    imgPet.setImageResource(R.drawable.dog2);
                } else if (cat.isChecked()) {
                    imgPet.setImageResource(R.drawable.cat);
                } else if (rabbit.isChecked()) {

                    imgPet.setImageResource(R.drawable.rabbit);
                } else {
                    imgPet.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "동물 먼저 선택하세요", Toast.LENGTH_SHORT).show();
                }
            }
            /*
            ImageButton cameraButton = findViewById(R.id.camera_button);
            cameraButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, PICK_IMAGE_REQUEST);
                }
            });

            @Override
            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri selectedImage = data.getData();
            // 선택한 이미지를 처리하는 코드 작성
             }
            }
             */


        });
    }
}

