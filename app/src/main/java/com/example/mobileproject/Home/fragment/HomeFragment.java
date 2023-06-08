package com.example.mobileproject.Home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileproject.R;
import com.example.mobileproject.Home.activity.BestActivity;
import com.example.mobileproject.Home.adapter.BestAdapter;
import com.example.mobileproject.basefragment.HomeBaseFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends HomeBaseFragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // 이번달 인기 장소에 관한 리사이클러뷰 설정
        RecyclerView recyclerViewPlace = view.findViewById(R.id.recyclerview_home_place);
        recyclerViewPlace.setHasFixedSize(true);
        LinearLayoutManager layoutManagerPlace = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPlace.setLayoutManager(layoutManagerPlace);

        List<String> myDatasetPlace = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            myDatasetPlace.add("홈화면 장소 " + (i+1));
        }
        BestAdapter mAdapterPlace = new BestAdapter(myDatasetPlace);
        recyclerViewPlace.setAdapter(mAdapterPlace);

        // 이번달 인기 코스에 관한 리사이클러뷰 설정
        RecyclerView recyclerViewCourse = view.findViewById(R.id.recyclerview_home_course);
        recyclerViewCourse.setHasFixedSize(true);
        LinearLayoutManager layoutManagerCourse = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCourse.setLayoutManager(layoutManagerCourse);

        List<String> myDatasetCourse = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            myDatasetCourse.add("홈화면 코스 " + (i+1));
        }
        BestAdapter mAdapterCourse = new BestAdapter(myDatasetCourse);
        recyclerViewCourse.setAdapter(mAdapterCourse);

        // 장소, 코스 더보기 버튼
        Button btn_bestPlace = view.findViewById(R.id.btn_bestPlace);
        Button btn_bestCourse = view.findViewById(R.id.btn_bestCourse);

        btn_bestPlace.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), BestActivity.class);
            startActivity(intent);
        });

        btn_bestCourse.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), BestActivity.class);
            startActivity(intent);
        });

        return view;
    }
}
