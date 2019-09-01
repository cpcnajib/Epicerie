package com.example.epicerie.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Client")
public class ClientModel {
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "phoneNumber")
    @PrimaryKey
    @NonNull
    private String phoneNumber;
    @ColumnInfo(name = "password")
    private String password;
    @ColumnInfo(name = "solde")
    private String solde;

    public ClientModel() {
    }

    public ClientModel(String name, @NonNull String phoneNumber, String password, String solde) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.solde = solde;
    }

    public String getSolde() {
        return solde;
    }

    public void setSolde(String solde) {
        this.solde = solde;
    }

    public ClientModel(String name, String phoneNumber, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.solde = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
