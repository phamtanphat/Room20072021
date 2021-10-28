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

import java.util.List;

public class MainActivity extends AppCompatActivity {

    NoteViewModel noteViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteViewModel = new ViewModelProvider(this,new NoteViewModel.NoteViewModelFactory(getApplication())).get(NoteViewModel.class);


        //observe data
        noteViewModel.getListNote().observe(this, new Observer<List<NoteEntity>>() {
            @Override
            public void onChanged(List<NoteEntity> noteEntities) {
                Log.d("BBB",noteEntities.size() + "");
            }
        });

        // call data
        noteViewModel.queryGetListNote();

    }
}