package sjs.example.ex11_04;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Ex11_04");

        final EditText editItem = findViewById(R.id.edtitem);
        Button btnAdd = findViewById(R.id.btnAdd);
        ListView lv = findViewById(R.id.listView);

        final ArrayList<String> midlist = new ArrayList<>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 , midlist);
        lv.setAdapter(adapter);

        AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity.this);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                midlist.add(editItem.getText().toString());
                editItem.setText("");
                adapter.notifyDataSetChanged();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                dig.setMessage(midlist.get(i).toString() + "를 삭제하시겠습니까?").setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        midlist.remove(i);
                        adapter.notifyDataSetChanged();
                    }
                });
                dig.show();
                return false;

            }
        });
    }
}