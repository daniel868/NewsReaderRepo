package com.sincalexandrudaniel.newsreader.models;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.sincalexandrudaniel.data.NewsRepository;
import com.sincalexandrudaniel.newsreader.NewsReaderApplication;
import com.sincalexandrudaniel.newsreader.models.fragment.FragmentItemViewModel;

import org.jetbrains.annotations.NotNull;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private static final String TAG = "ViewModelFactory";
    private final Application application;
    private String newsTitle;

    public ViewModelFactory(Application application) {
        this.application = application;
    }

    public ViewModelFactory(Application application, String itemTitle) {
        this.application = application;
        this.newsTitle = itemTitle;
    }


    @NonNull
    @NotNull
    @Override
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        NewsRepository repository = NewsReaderApplication.getRepoModule().provideNewsRepository();
        if (modelClass.isAssignableFrom(NewsReaderViewModel.class)) {
            Log.d(TAG, "create: " + repository);
            return (T) new NewsReaderViewModel(application, repository);
        } else if (modelClass.isAssignableFrom(FragmentItemViewModel.class)) {
            Log.d(TAG, "create: " + repository);
            return (T) new FragmentItemViewModel(application, repository,newsTitle);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }

    public String getNewsTitle() {
        return newsTitle;
    }
}
