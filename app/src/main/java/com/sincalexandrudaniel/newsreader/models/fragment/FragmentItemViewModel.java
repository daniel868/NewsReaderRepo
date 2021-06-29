package com.sincalexandrudaniel.newsreader.models.fragment;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.sincalexandrudaniel.data.NewsRepository;
import com.sincalexandrudaniel.data.feature.news.local.NewsEntity;

import org.jetbrains.annotations.NotNull;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class FragmentItemViewModel extends AndroidViewModel implements LifecycleObserver {


    private static final String TAG = "FragmentItemViewModel";
    private NewsRepository repository;
    private final String newsTitle;

    public final ObservableField<String> fragmentTitle;
    public final ObservableField<String> fragmentContent;
    public final ObservableField<String> fragmentImageUri;


    public FragmentItemViewModel(@NonNull @NotNull Application application, NewsRepository repository, String newsTitle) {
        super(application);
        this.repository = repository;
        this.newsTitle = newsTitle;
        fragmentTitle = new ObservableField<>();
        fragmentContent = new ObservableField<>();
        fragmentImageUri = new ObservableField<>();

        Log.d(TAG, "FragmentItemViewModel: " + this);
    }

    @SuppressLint("CheckResult")
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onRefresh() {
        repository.getArticle(newsTitle)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onEntityReceived,
                        this::onEntityError);
    }

    private void onEntityReceived(@NonNull NewsEntity newsEntity) {
        fragmentImageUri.set(newsEntity.newsPhotoUri);
        fragmentTitle.set(newsEntity.newsTitle);
        fragmentContent.set(newsEntity.newsContent);


    }

    private void onEntityError(Throwable throwable) {
        Log.e(TAG, "Error loading entity", throwable);
    }
}
