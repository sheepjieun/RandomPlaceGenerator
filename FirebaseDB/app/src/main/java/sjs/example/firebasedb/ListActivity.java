package sjs.example.firebasedb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    UserAdapter adapter;

    DAOuser dao;

    String key;

    ArrayList<User> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.rv);

        recyclerView.setHasFixedSize(true);

        //화면 설정
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        //어뎁터 설정
        adapter = new UserAdapter(this , list);

        //recyclerView 어뎁터 설정
        recyclerView.setAdapter(adapter);

        //데이터베이스 초기화
        dao = new DAOuser();

        //데이터 가져오기
        loadData();

    }

    private void loadData() {

        dao.get().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();

                for(DataSnapshot data : snapshot.getChildren()){

                    User user = data.getValue(User.class);

                    //key값 가져오기
                    key = data.getKey();

                    //key값 user에 담기
                    user.setUser_key(key);

                    //리스트에 담기
                    list.add(user);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}