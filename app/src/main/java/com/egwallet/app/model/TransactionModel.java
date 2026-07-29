package com.egwallet.app.model;

public class TransactionModel {
    public long id;
    public String name;
    public String category;
    public String date;
    public long amount; // in FCFA
    public String type; // EXPENSE / INCOME

    public TransactionModel(long id, String name, String category, String date, long amount, String type) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.date = date;
        this.amount = amount;
        this.type = type;
    }
}
