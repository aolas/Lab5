package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "Main activity";

    private ListView currencyListView;
    DataLoader getData = new DataLoader();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currencyListView = findViewById(R.id.currencyListView);
        getData.getData(this,currencyListView);

    }
}