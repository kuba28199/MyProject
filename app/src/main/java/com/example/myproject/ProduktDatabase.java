package com.example.myproject;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Produkt.class}, version = 1, exportSchema = false)
public abstract class ProduktDatabase extends RoomDatabase {
    public abstract ProduktDao produktDao();

    private static volatile ProduktDatabase INSTANCE;
    public static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ProduktDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ProduktDatabase.class) {
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ProduktDatabase.class, "produkt_db").build();
                }
            }
        }
        return INSTANCE;
    }


}
