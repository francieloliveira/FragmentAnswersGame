package com.example.fragmentanswersgame.dao;

import androidx.fragment.app.FragmentActivity;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.fragmentanswersgame.dao.entity.Questoes;

@Database(entities = {Questoes.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract QuestoesDAO questoesDAO();
    public static volatile AppDatabase BD; //marcado como volatile por conta da checagem dupla no getAppDatabase
    public static AppDatabase getAppDatabase(FragmentActivity activity) {
        if (BD == null) {
            synchronized (AppDatabase.class) {
                if (BD == null) {
                    //Cria o BD
                    BD = Room.databaseBuilder(activity.getApplicationContext(),
                            AppDatabase.class, "bd_questoes").allowMainThreadQueries().build();
                }
            }
        }
        return BD;
    }
}


