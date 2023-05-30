package com.example.mobileproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.List;

public class Slide_list_Adapter extends ArrayAdapter<String> {

    private Context context;
    private List<String> itemList;
    private View.OnClickListener[] itemClickListeners;

    public Slide_list_Adapter(Context context, List<String> itemList) {
        super(context, 0, itemList);
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public View getView(final int index, View view, @NonNull ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.slide_list_layout, parent, false);
        }

        String item = itemList.get(index);

        TextView place_list_item = view.findViewById(R.id.slide_list_item);
        place_list_item.setText(item);

        // 각 아이템에 클릭 이벤트 추가
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 아이템 클릭 시 실행될 동작 정의
                Toast.makeText(context, itemList.get(index), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    public void setItemClickListeners(View.OnClickListener[] clickListeners) {
        if (clickListeners.length == itemList.size()) {
            itemClickListeners = clickListeners;
        } else {
            throw new IllegalArgumentException("배열의 아이템이 아닙니다.");
        }
    }
}