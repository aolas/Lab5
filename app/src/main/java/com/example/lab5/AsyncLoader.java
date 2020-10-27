package com.example.lab5;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class AsyncLoader  extends AsyncTask<Integer, Void, Void> {
    private static final String TAG = "Async tack in progress";


    /** Create a new textview array to display the results */
    private String url ="https://api.exchangeratesapi.io/latest", reply = "";

    // Request a string response from the provided URL.
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // Display the first 500 characters of the response string.
                    reply = response;
                    Log.v(TAG, "Response is: "+ response.substring(0,500));
                }
            }, new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {
            Log.v(TAG,String.valueOf(error));
        }
    });


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        //here tu initiaize variable for async task
    }

    @Override
    protected Void doInBackground(Integer... integers) {



        for (int i = 0; i<integers[0];i++){
            Log.d(TAG,"Ro in background" + String.valueOf(i));
            Parser getNewData = new Parser();
            SystemClock.sleep(50000);
            Log.d(TAG,getNewData.toString());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //here we can put anything we need after execution
    }
}
/*
    private void getData(){
        final Gson gson = new Gson();
        String url = "https://api.exchangeratesapi.io/latest";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                txtDataView.setText(response);
                RatesJasonOBJ rates = gson.fromJson(response,RatesJasonOBJ.class);

                txtDataView.setText(rates.toString());
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                error.printStackTrace();
            }

        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
        queue.start();
    }

 */