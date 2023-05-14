package sjs.example.myfragment03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Fragment1 fragment1;
    Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
    }

    public void onFragChanged(int index){
        if (index == 0){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
        }
        else if (index == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
        }
    }
}