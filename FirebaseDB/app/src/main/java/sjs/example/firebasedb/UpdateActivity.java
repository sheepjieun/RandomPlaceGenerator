package sjs.example.firebasedb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.HashMap;

public class UpdateActivity extends AppCompatActivity {

    EditText updateNameEdit , updateAgeEdit;
    Button updatebtn;

    String skey,sname,sage;
    String uname , uage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        DAOuser dao = new DAOuser();

        updateNameEdit = findViewById(R.id.update_name_edit);
        updateAgeEdit = findViewById(R.id.update_age_edit);
        updatebtn = findViewById(R.id.update_btn);

        getAndSetIntentData();

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //변경값
                uname = updateNameEdit.getText().toString();
                uage = updateAgeEdit.getText().toString();

                //파라미터 셋팅
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("user_name " , uname);
                hashMap.put("user_age " , uage);

                dao.update(skey , hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        Toast.makeText(getApplicationContext(),"정보 수정 성공" , Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"정보 수정 실패" + e.getMessage() , Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
    //데이터 받아서 화면에 출력하기
    private void getAndSetIntentData() {

        //값 있는지 check
        if(getIntent().hasExtra("key") && getIntent().hasExtra("name") && getIntent().hasExtra("age")){

            //데이터 가져오기
            skey = getIntent().getStringExtra("key");
            sname = getIntent().getStringExtra("name");
            sage = getIntent().getStringExtra("age");

            //데이터 넣기
            updateNameEdit.setText(sname);
            updateAgeEdit.setText(sage);


        }

    }


}
