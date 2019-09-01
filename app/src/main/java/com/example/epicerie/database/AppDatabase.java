package com.example.epicerie.database;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = ClientModel.class, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String Db_name = "Client_db";
    private static final String LOG_TAG ="AppDatabase" ;
    private static AppDatabase instance;

    public abstract ClientDAO clientDAO();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            Log.d(LOG_TAG, "Creating new database instance");

            instance = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,Db_name)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        Log.d(LOG_TAG, "Getting the  database instance");

        return instance;
    }

}
