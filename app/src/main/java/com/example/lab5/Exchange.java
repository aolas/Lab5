package com.example.lab5;

import java.util.ArrayList;

public class Exchange {
    private String base;
    private String date;
    private ArrayList<Currency> currencyList;

    public Exchange(String base, String date) {
        this.base = base;
        this.date = date;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Currency> getbaseList() {
        return currencyList;
    }

    public void setBaseList(ArrayList<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    @Override
    public String toString() {
        return App.getRes().getString(R.string.currency) + " 1 " + base + " " + App.getRes().getString(R.string.date) + " " + date;
    }
}
