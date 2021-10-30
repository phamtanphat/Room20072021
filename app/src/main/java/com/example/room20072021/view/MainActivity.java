package com.example.room20072021.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.room20072021.R;
import com.example.room20072021.database.NoteEntity;
import com.example.room20072021.viewmodel.NoteViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    NoteViewModel noteViewModel;
    List<NoteEntity> mNoteEntities;
    Button mBtnDelete,mBtnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnDelete = findViewById(R.id.buttonDelete);
        mBtnUpdate = findViewById(R.id.buttonUpdate);

        noteViewModel = new ViewModelProvider(this,new NoteViewModel.NoteViewModelFactory(getApplication())).get(NoteViewModel.class);

        mNoteEntities = new ArrayList<>();
        //observe data
        noteViewModel.getListNote().observe(this, new Observer<List<NoteEntity>>() {
            @Override
            public void onChanged(List<NoteEntity> noteEntities) {
                mNoteEntities.clear();
                mNoteEntities.addAll(noteEntities);
                for (int i = 0; i < mNoteEntities.size(); i++) {
                    Log.d("BBB",mNoteEntities.get(i).toString());
                }
            }
        });

        noteViewModel.getIdUpdate().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Log.d("BBB","Id update " + integer);
            }
        });
//
//
//        noteViewModel.getIdInsert().observe(this, new Observer<Long>() {
//            @Override
//            public void onChanged(Long aLong) {
//                Log.d("BBB","Id insert " + aLong);
//            }
//        });
        noteViewModel.getIdInsert().observe(this, new Observer<Long>() {
            @Override
            public void onChanged(Long aLong) {
                Log.d("BBB","Id insert " + aLong);
            }
        });

        // call data
        noteViewModel.queryGetListNote();
//        noteViewModel.insertNote(new NoteEntity("Work 4","Do something 4"));

        mBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteViewModel.deletedNote(mNoteEntities.get(mNoteEntities.size() - 1));
            }
        });

        mBtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                noteViewModel.deletedNote(mNoteEntities.get(mNoteEntities.size() - 1));
                NoteEntity noteEntity = mNoteEntities.get(mNoteEntities.size() - 1);
                noteEntity.setDescription("Do something 3.1");
                noteEntity.setTitle("Work 3.1");
                noteViewModel.updateNote(noteEntity);
            }
        });

    }
}