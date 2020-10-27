package com.example.lab5;

public class Currency {
    String currencyName;
    String value;

    public String getCurrencyName() {
        return currencyName;
    }

    public String getValue() {
        return value;
    }

    public Currency(String currencyName, String value) {
        this.currencyName = currencyName;
        this.value = value;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Currency: "+ currencyName + ", value= " + value;
    }
}
