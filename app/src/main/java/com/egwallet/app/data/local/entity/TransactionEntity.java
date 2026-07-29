package com.egwallet.app.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transactions")
public class TransactionEntity {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public long accountId;
    public int categoryId;
    public String type;
    public long amount;
    public String description;
    public String date;
}
