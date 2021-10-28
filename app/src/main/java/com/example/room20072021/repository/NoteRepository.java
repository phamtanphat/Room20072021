package com.example.room20072021.repository;

import android.app.Application;
import android.content.Context;

import com.example.room20072021.database.NoteDao;
import com.example.room20072021.database.NoteDatabase;
import com.example.room20072021.database.NoteEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public class NoteRepository {
    private static NoteRepository instance = null;
    private NoteDao noteDao;

    private NoteRepository(Application context){
        noteDao = NoteDatabase.getInstance(context).noteDao();
    }

    public static NoteRepository getInstance(Application context){
        if (instance == null){
            instance = new NoteRepository(context);
        }
        return instance;
    }

    public Flowable<List<NoteEntity>> getListNote(){
        return noteDao.getListNote();
    }

}
