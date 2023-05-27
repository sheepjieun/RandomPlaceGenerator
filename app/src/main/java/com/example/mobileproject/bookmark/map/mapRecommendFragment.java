package com.example.mobileproject.bookmark.map;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mobileproject.R;
import com.example.mobileproject.bookmark.place.BookmarkPlaceFragment;

public class mapRecommendFragment extends Fragment {

    ImageButton btn_disition;
    Context context;

    public mapRecommendFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.map_recommend_button,container, false);


        btn_disition = view.findViewById(R.id.btnDisition);

        btn_disition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMyDialog();
            }
        });

        return view;
    }

    public void showMyDialog(){
        Dialog mapDialog = new Dialog(context);
        mapDialog.setContentView(R.layout.map_dialog);

        EditText edit_course;
        Button btn_check, btn_cancel;

        edit_course = mapDialog.findViewById(R.id.editCourse);
        btn_check = mapDialog.findViewById(R.id.btnCheck);
        btn_cancel = mapDialog.findViewById(R.id.btnCancel);

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edit_course.length() != 0){

                    Toast.makeText(context, "해당 이름으로 코스가 생성되었습니다."  , Toast.LENGTH_SHORT).show();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.container, new mapMadedFragment());
                    fragmentTransaction.commit();
                    mapDialog.dismiss();
                }else{
                    Toast.makeText(context, "지역 이름으로 코스가 생성되었습니다.", Toast.LENGTH_SHORT).show();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.container, new mapMadedFragment());
                    fragmentTransaction.commit();
                    mapDialog.dismiss();
                }

            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapDialog.dismiss();
            }
        });

        mapDialog.show();
    }
}
