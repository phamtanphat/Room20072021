package com.example.room20072021.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface NoteDao {

    @Query("Select * from note")
    Flowable<List<NoteEntity>> getListNote();

}
