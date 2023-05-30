        package com.example.mobileproject;

        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.ArrayList;

        public class Text_Fragment extends Fragment {

            private ArrayList<String> text_itemList;
            private RecyclerView text_recycler;
            private Text_RecyclerViewAdapter text_recycler_adapter;

            @Nullable
            @Override
            public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                View view = inflater.inflate(R.layout.fragment_text, container, false);

                text_itemList = new ArrayList<>();
                text_itemList.add("경빈코스");
                text_itemList.add("장호코스");
                text_itemList.add("지성코스");
                text_itemList.add("지은코스");

                text_recycler = view.findViewById(R.id.text_rv);
                text_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
                text_recycler_adapter = new Text_RecyclerViewAdapter(text_itemList);
                text_recycler.setAdapter(text_recycler_adapter);
                return view;
            }

            // 나머지 코드
        }


