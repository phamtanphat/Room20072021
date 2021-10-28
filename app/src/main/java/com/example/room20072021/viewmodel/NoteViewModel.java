package com.example.room20072021.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.room20072021.database.NoteEntity;
import com.example.room20072021.repository.NoteRepository;

import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository noteRepository;
    private MutableLiveData<List<NoteEntity>> listNote;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository = NoteRepository.getInstance(getApplication());
        listNote = new MutableLiveData<>();
    }

    public void queryGetListNote(){
        noteRepository.getListNote()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(noteEntities -> listNote.setValue(noteEntities));
    }

    public LiveData<List<NoteEntity>> getListNote(){
        return listNote;
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
