package com.example.epicerie.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ClientDAO {
    @Query("select * from client")
    List<ClientModel> getClient();

    @Query("select * from client where phoneNumber LIke :phoneNumber")
    ClientModel getClientByPhoneNumber(String phoneNumber);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertClient(ClientModel clientModel);

    @Update
    void updateClient(ClientModel clientModel);

    @Delete
    void deleteClient(ClientModel clientModel);


}
