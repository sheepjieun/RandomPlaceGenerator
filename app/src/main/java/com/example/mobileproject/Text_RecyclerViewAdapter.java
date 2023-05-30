package com.example.mobileproject;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Text_RecyclerViewAdapter extends RecyclerView.Adapter<Text_RecyclerViewAdapter.ViewHolder>{

    private ArrayList<String> text_itemList;
    private ArrayList<Integer> countList;

    public Text_RecyclerViewAdapter(ArrayList<String> text_itemList) {
        this.text_itemList = text_itemList;
        this.countList = new ArrayList<>();
        for (int i = 0; i < text_itemList.size(); i++) {
            countList.add(0); // 초기 조회수를 0으로 설정
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = text_itemList.get(position);
        int counter = countList.get(position);
        holder.bind(item, counter);
    }

    @Override
    public int getItemCount() {
        return text_itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private TextView count;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.itemButton);
            count = itemView.findViewById(R.id.count_see);
        }

        public void bind(String item, int counter) {
            textView.setTextColor(Color.BLACK);
            textView.setText(item);
            count.setText(String.valueOf(counter));

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 클릭할 때마다 조회수 증가
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        int currentCount = countList.get(position);
                        countList.set(position, currentCount + 1);
                        notifyItemChanged(position);
                    }
                }
            });
        }

    }
}
