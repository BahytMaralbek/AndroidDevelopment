package com.example.todolist;

import android.app.Application;
import android.util.Log;

import androidx.room.Room;

public class MyApp extends Application {

    public static MyApp instance;
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("MyApplication", "onCreate");
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "task_db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    public static MyApp getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }

}
