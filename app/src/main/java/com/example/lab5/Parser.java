package com.example.lab5;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parser {
    private static final String TAG = "Parser class";
    final Gson gson = new Gson();
    public ArrayList<Currency> getCurrencyList(String jsonString) {
        ArrayList<Currency> currencyList = new ArrayList<Currency>() ;
        try {
            JSONObject ratesJsonObj = new JSONObject(jsonString);
            JSONObject ratesSecondLvl = ratesJsonObj.getJSONObject("rates");
            Iterator<String> keyList = ratesSecondLvl.keys();

            while (keyList.hasNext()){
                String key = keyList.next();
                ratesSecondLvl.get(key);
                //parse value and use it
                Currency newCurrency = new Currency(key,ratesSecondLvl.get(key).toString());
                currencyList.add(newCurrency);
                Log.d(TAG, key + ": " + ratesSecondLvl.get(key).toString());

            }
            Log.d(TAG,keyList.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return currencyList;

    }



}
