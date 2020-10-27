package com.example.lab5;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;


public class DataLoader {
    ArrayList<Currency>  currencyList;

    public static final String TAG = "Data loader";
    public void getData(final Context context, final ListView currencyListView){
        final Gson gson = new Gson();
        final Parser dataParser = new Parser();


        String url = "https://api.exchangeratesapi.io/latest";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                currencyList = dataParser.getCurrencyList(response);
                for(Currency cur : currencyList){
                    Log.d(TAG,cur.toString());
                }
                ArrayAdapter<Currency> dataAdapter = new ArrayAdapter<Currency>(context, android.R.layout.simple_list_item_1, currencyList);
                currencyListView.setAdapter(dataAdapter);
                //RatesJasonOBJ rates = gson.fromJson(response,RatesJasonOBJ.class);
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                error.printStackTrace();
            }

        });
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
        queue.start();
    }
}
