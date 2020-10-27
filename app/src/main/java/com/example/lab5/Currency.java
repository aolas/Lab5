package com.example.lab5;

import android.content.res.Resources;

import androidx.core.graphics.drawable.IconCompat;

import static androidx.core.content.res.TypedArrayUtils.getText;


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
        return "Currency: " + baseName + " Rate: " + value;
    }
}
