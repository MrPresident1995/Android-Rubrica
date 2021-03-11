package com.fabiohong.rubrica;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities= {Contatto.class}, version= 1)
public abstract class DBManager extends RoomDatabase {
    private static final String DB_NOME= "ContattoDB";
    private static DBManager instance;

    public static DBManager getInstance(Context c) {
        if(instance==null) {
            instance= Room.databaseBuilder(c, DBManager.class, DB_NOME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract ContattoDAO getContattoDAO();
}
