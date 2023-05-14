package sjs.example.firebaseonevalue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name_edit = findViewById(R.id.name_edit);
        EditText age_edit = findViewById(R.id.age_edit);
        Button addbtn = findViewById(R.id.add_btn);

        DAOUser dao = new DAOUser();

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = name_edit.getText().toString(); //이름
                String age = age_edit.getText().toString(); //나이

                User user = new User("" , name ,age);

                dao.add(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        Toast.makeText(getApplicationContext(), "성공" , Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "실패" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}