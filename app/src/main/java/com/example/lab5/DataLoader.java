package com.example.lab5;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class DataLoader {
    Exchange exchangeStat;
    public static final String TAG = "Data loader";
    public void getData(final Context context, final ListView baseListView, final TextView txtExchange){
        final Parser dataParser = new Parser();
        String url = "https://api.exchangeratesapi.io/latest";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                exchangeStat = dataParser.getbaseList(response);
                if (exchangeStat != null){
                    txtExchange.setText(exchangeStat.toString());
                    ArrayAdapter<Currency> dataAdapter = new ArrayAdapter<Currency>(context, android.R.layout.simple_list_item_1, exchangeStat.getbaseList());
                    baseListView.setAdapter(dataAdapter);
                } else{
                    txtExchange.setText(R.string.parserError);
                }

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                txtExchange.setText(R.string.parserError);
                error.printStackTrace();
            }

        });
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
        queue.start();
    }
}
