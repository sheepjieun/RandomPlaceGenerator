package sjs.example.firebasedb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserVH> {


    private Context context;
    // context

    ArrayList<User> list = new ArrayList<>();
    //User에 속한 값의 배열

    public UserAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public UserVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        return new UserVH(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UserVH holder, int position) {

        User user = list.get(holder.getBindingAdapterPosition());

        //이름
        holder.nameText.setText(user.getUser_name());

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context , UpdateActivity.class); // context = 현재 클래스 -> 업데이트 클래스로

                //user 클래스에 있는 user_값들을 클래스.get(value)로 가져와서 각각의 값의 인텐트로 보내줌
                intent.putExtra("key" , user.getUser_key());
                intent.putExtra("name" , user.getUser_name());
                intent.putExtra("age" , user.getUser_age());

                //현재 액티비티에서 시작
                context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {

        //list 크기
        return list.size();
    }

    public

    class UserVH extends RecyclerView.ViewHolder{

        TextView nameText;

        CardView cardview;

        public UserVH(@NonNull View itemView) {

            super(itemView);

            nameText = itemView.findViewById(R.id.name_text);

            cardview = itemView.findViewById(R.id.card_view);
        }
    }
}
