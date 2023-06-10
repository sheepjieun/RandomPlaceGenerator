package com.example.mobileproject.Recommend.fragment;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.mobileproject.R;
import com.example.mobileproject.Recommend.activitiy.RecommendActivity2;

public class JejuFragment extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_jeju, container, false);
        Button btn_seoul1 = root.findViewById(R.id.seoul1);
        btn_seoul1.setOnClickListener(this);
        return root;
    }

    //서울 전체 누를 시 다음 화면으로 넘어감
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), RecommendActivity2.class);
        startActivity(intent);
    }
}