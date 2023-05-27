package com.example.mobileproject.bookmark.place;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileproject.R;

import java.util.ArrayList;

public class BookmarkPlaceListItemAdapter extends RecyclerView.Adapter<BookmarkPlaceListItemAdapter.CustomViewHolder> {

    // 데이터를 저장하는 ArrayList
    private ArrayList<BookmarkPlaceData> arrayList;
    // 이미지, 이름, 위치 정보를 담은 배열

    // 생성자를 통해 ArrayList를 전달받음
    public BookmarkPlaceListItemAdapter(ArrayList<BookmarkPlaceData> arrayList) {
        this.arrayList = arrayList;
    }

    // 새로운 뷰 홀더 생성
    @NonNull
    @Override
    public BookmarkPlaceListItemAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //onCreate이랑 비슷하게 recyclerView가 처음 생성될 때 생명주기를 뜻한다.
        // 뷰 홀더를 위한 뷰 생성
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookmark_place_list, parent,false);
        // 뷰 홀더 객체 생성
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    // 뷰 홀더의 내용을 변경하는 함수
    @Override
    public void onBindViewHolder(@NonNull BookmarkPlaceListItemAdapter.CustomViewHolder holder, int position) {
        // 뷰 홀더에 들어갈 데이터를 가져옴
        holder.placeImageView.setImageResource(arrayList.get(position).getPlaceImageView());
        holder.placeName.setText(arrayList.get(position).getPlaceName());
        holder.placeLocation.setText(arrayList.get(position).getPlaceLocation());

        // 뷰 클릭 리스너 설정
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String curName = holder.placeName.getText().toString();
                Toast.makeText(view.getContext(), curName, Toast.LENGTH_SHORT).show();
            }
        });

        // 삭제 버튼 클릭 리스너 설정
        holder.placeDelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(holder.getAdapterPosition());
            }
        });
    }

    // 데이터 개수 반환
    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    // 아이템 삭제 함수
    public void remove(int position) {
        try {
            arrayList.remove(position);
            notifyItemRemoved(position);
        } catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
    }

    // 뷰 홀더 클래스
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView placeImageView;
        protected TextView placeName;
        protected TextView placeLocation;
        protected ImageView placeDelBtn;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            //activity가 이니기 때문에 itmeView에서 받아온다.
            this.placeImageView = (ImageView)itemView.findViewById(R.id.placeImageView);
            this.placeName = (TextView) itemView.findViewById(R.id.placeName);
            this.placeLocation = (TextView) itemView.findViewById(R.id.placeLocation);
            this.placeDelBtn = (ImageView) itemView.findViewById(R.id.placeDelBtn);
        }
    }
    public void updateList(ArrayList<BookmarkPlaceData> newList) {
        arrayList.clear(); // 기존 데이터를 모두 제거합니다.
        arrayList.addAll(newList); // 새로운 데이터로 ArrayList를 업데이트합니다.
        notifyDataSetChanged(); // RecyclerView에 변경된 데이터를 알립니다.
    }



}
