package com.sincalexandrudaniel.newsreader.models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.sincalexandrudaniel.data.NewsRepository;
import com.sincalexandrudaniel.newsreader.DemoApplication;

import org.jetbrains.annotations.NotNull;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private final Application application;

    public ViewModelFactory(Application application) {
        this.application = application;
    }


    @NonNull
    @NotNull
    @Override
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(NewsReaderViewModel.class)) {
            NewsRepository repository = DemoApplication.getRepoModule().provideNewsRepository();
            return (T) new NewsReaderViewModel(application, repository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
