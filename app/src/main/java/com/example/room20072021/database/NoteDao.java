package com.example.room20072021.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;

@Dao
public interface NoteDao {

    @Query("Select * from note")
    Observable<List<NoteEntity>> getListNote();

    @Insert
    Maybe<Long> insertNote(NoteEntity noteEntity);

    @Update
    Maybe<Integer> updateNote(NoteEntity noteEntity);

    @Delete
    Completable deleteNote(NoteEntity noteEntity);

}
