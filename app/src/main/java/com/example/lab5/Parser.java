package com.example.lab5;

import android.util.Log;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;

public class Parser {
    private static final String TAG = "Parser class";
    public Exchange getbaseList(String jsonString) {
        ArrayList<Currency> baseList = new ArrayList<Currency>() ;
        Exchange exchangeStat = null;
        try {
            JSONObject ratesJsonObj = new JSONObject(jsonString);
            String base = String.valueOf(ratesJsonObj.get("base"));
            String date = String.valueOf(ratesJsonObj.get("date"));
            Log.d(TAG,date + " " + base);
            JSONObject ratesSecondLvl = ratesJsonObj.getJSONObject("rates");
            Iterator<String> keyList = ratesSecondLvl.keys();

            exchangeStat = new Exchange(base,date);
            while (keyList.hasNext()){
                String key = keyList.next();
                ratesSecondLvl.get(key);
                //Parsing into base object
                Currency newCurrency = new Currency(key,ratesSecondLvl.get(key).toString());
                baseList.add(newCurrency);
                Log.d(TAG, key + ": " + ratesSecondLvl.get(key).toString());
            }
            exchangeStat.setBaseList(baseList);
        } catch (JSONException e) {
            Log.d(TAG,e.toString());
        }

        return exchangeStat;

    }

}
