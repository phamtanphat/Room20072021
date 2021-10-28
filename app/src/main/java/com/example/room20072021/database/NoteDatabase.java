package com.example.room20072021.database;

import android.app.Application;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {NoteEntity.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {
    private static NoteDatabase instance = null;

    public abstract NoteDao noteDao();

    public synchronized static NoteDatabase getInstance(Application application) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    application,
                    NoteDatabase.class,
                    "note.sql"
            ).build();
        }
        return instance;
    }
}
