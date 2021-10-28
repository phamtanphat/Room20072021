package com.example.room20072021.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.room20072021.repository.NoteRepository;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository noteRepository;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository = NoteRepository.getInstance(getApplication());
    }


    public static class NoteViewModelFactory implements ViewModelProvider.Factory {

        @NonNull
        private Application application;

        public NoteViewModelFactory(@NonNull Application application) {
            this.application = application;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
            if (aClass.isAssignableFrom(NoteViewModel.class)){
                return (T) new NoteViewModel(application);
            }
            throw new IllegalArgumentException("Unable to construct viewmodel");
        }
    }
}
