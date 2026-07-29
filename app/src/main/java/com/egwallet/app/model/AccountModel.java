package com.egwallet.app.model;

public class AccountModel {
    public long id;
    public String name;
    public String currency;
    public long balance;

    public AccountModel(long id, String name, String currency, long balance) {
        this.id = id;
        this.name = name;
        this.currency = currency;
        this.balance = balance;
    }
}
