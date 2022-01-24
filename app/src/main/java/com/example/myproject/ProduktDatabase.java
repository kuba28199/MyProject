package com.example.myproject;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

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
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ProduktDatabase.class, "produkt_db").addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            databaseWriteExecutor.execute(()-> {
                ProduktDao dao = INSTANCE.produktDao();
                dao.deleteAll();

                Produkt produkt = new Produkt("Hamburger", 5, "Plaster wołowiny, pikle, cebula, keczup i musztarda!");
                dao.insert(produkt);
                Produkt produkt1 = new Produkt("Chicken Burger", 8, "Kotlet z piersi kurczaka w złocistej panierce, sos kanapkowy oraz pokrojone liście sałaty!");
                dao.insert(produkt1);
                Produkt produkt2 = new Produkt("Cheeseburger", 8, "");
                dao.insert(produkt2);
            });
        }
    };

}
