package com.example.lab5;

import android.content.res.Resources;

public class Currency {
    String baseName;
    String value;

    public String getbaseName() {
        return baseName;
    }

    public String getValue() {
        return value;
    }

    public Currency(String baseName, String value) {
        this.baseName = baseName;
        this.value = value;
    }

    public void setbaseName(String baseName) {
        this.baseName = baseName;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        //getResources().getString(R.string.my_string);

        return App.getRes().getString(R.string.currency) + " " + baseName +" "+ App.getRes().getString(R.string.rate) + " " + value;
    }
}
