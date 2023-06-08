package com.example.mobileproject.Home.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.mobileproject.R;
import com.example.mobileproject.baseactivity.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment); //내부적으로 FragmentManager를 관리
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        /*BottomNavigationView와 NavController를 연결
        각 메뉴 아이템 클릭에 따라 NavController가 적절한 네비게이션 액션을 수행
        이 때 네비게이션 액션은 nav_graph.xml에 정의된 대로 수행되며, 이를 통해 각 프래그먼트로의 이동이 가능*/
    }
}