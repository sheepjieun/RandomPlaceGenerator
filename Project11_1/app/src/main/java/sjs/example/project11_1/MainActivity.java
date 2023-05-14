package sjs.example.project11_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

   Integer[] posterID = {R.drawable.mov01 , R.drawable.mov02 , R.drawable.mov03 , R.drawable.mov04 , R.drawable.mov05 ,R.drawable.mov06 ,
            R.drawable.mov07 , R.drawable.mov08 , R.drawable.mov09 , R.drawable.mov10 , R.drawable.mov11 ,R.drawable.mov12 ,
            R.drawable.mov13 , R.drawable.mov14 , R.drawable.mov15 , R.drawable.mov16 , R.drawable.mov17 ,R.drawable.mov18 ,
            R.drawable.mov19 , R.drawable.mov20 , R.drawable.mov21 , R.drawable.mov22 , R.drawable.mov23 ,R.drawable.mov24 ,
            R.drawable.mov25 , R.drawable.mov26 , R.drawable.mov27 , R.drawable.mov28 , R.drawable.mov29 ,R.drawable.mov30 };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gv = findViewById(R.id.gridView1);

        MyGridAdapter gAdapter = new MyGridAdapter(this); //항목 구성
        //this = MainActivity를 context를 통해 MyGridAdapter에 넘겨줌
        gv.setAdapter(gAdapter);
    }
} //Main
