package com.example.mobileproject;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    EditText editText;
    LinearLayout historyLayout;
    ArrayList<String> searchHistory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.search);
        historyLayout = findViewById(R.id.historyLayout);

        searchHistory = new ArrayList<>();

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    addSearchHistory();
                    return true;
                }
                return false;
            }
        });
    }

    public  void addSearchHistory() {
        String searchQuery = editText.getText().toString().trim();

        if (!TextUtils.isEmpty(searchQuery)) {
            searchHistory.add(searchQuery);
            updateSearchHistoryUI();
            editText.setText("");
        }
    }

    public void updateSearchHistoryUI() {
        historyLayout.removeAllViews();

        for (final String searchQuery : searchHistory) {
            TextView textView = new TextView(this);
            textView.setText(searchQuery);

            Button deleteButton = new Button(this);
            deleteButton.setText("X");
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteSearchHistory(searchQuery);
                }
            });

            LinearLayout rowLayout = new LinearLayout(this);
            rowLayout.addView(textView);
            rowLayout.addView(deleteButton);

            historyLayout.addView(rowLayout);
        }
    }

    public void deleteSearchHistory(String searchQuery) {
        searchHistory.remove(searchQuery);
        updateSearchHistoryUI();
    }
}

