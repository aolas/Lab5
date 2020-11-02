package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "Main activity";

    private ListView baseListView;
    private TextView txtExchange;
    DataLoader getData = new DataLoader();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseListView = findViewById(R.id.baseListView);
        txtExchange = findViewById(R.id.txtExchange);
        getData.getData(this,baseListView,txtExchange);

        baseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Currency selectedCurency = (Currency) adapterView.getItemAtPosition(position);
                Log.d(TAG,selectedCurency.toString());
            }
        });

    }

}