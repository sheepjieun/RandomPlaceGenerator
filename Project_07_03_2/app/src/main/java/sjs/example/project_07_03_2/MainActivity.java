package sjs.example.project_07_03_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText tvName , tvEmail;
    Button btn1;
    EditText edtname , edtemail;
    TextView toastt;
    View dialogV , toastV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("사용자 정보 입력");

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        btn1 = findViewById(R.id.button1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity.this);
                dig.setTitle("사용자 정보 입력");
                dig.setIcon(R.drawable.ic_menu_allfriends);

                dialogV = View.inflate(MainActivity.this , R.layout.dialog1, null);
                dig.setView(dialogV);



                dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Overrid
                    e
                    public void onClick(DialogInterface dialogInterface, int i) {
                        edtname = dialogV.findViewById(R.id.digEdt1);
                        edtemail = dialogV.findViewById(R.id.digEdt2);

                        tvName.setText(edtname.getText().toString());
                        tvEmail.setText(edtemail.getText().toString());

                    }
                });

                dig.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(MainActivity.this);
                        toastV = View.inflate(MainActivity.this , R.layout.toast1, null);
                        toastt = toastV.findViewById(R.id.toastText1);
                        toast.setView(toastV);
                        toast.show();
                    }
                });

                dig.show();
            }
        });
    }


}