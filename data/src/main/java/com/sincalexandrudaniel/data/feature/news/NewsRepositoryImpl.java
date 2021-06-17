package com.sincalexandrudaniel.data.feature.news;

import android.annotation.SuppressLint;

import com.sincalexandrudaniel.data.NewsRepository;
import com.sincalexandrudaniel.data.feature.news.local.NewsLocalDataStore;
import com.sincalexandrudaniel.data.feature.news.model.Article;
import com.sincalexandrudaniel.data.feature.news.remote.NewsRemoteSource;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.Single;

public class NewsRepositoryImpl implements NewsRepository {
    private static final String TAG = "NewsRepositoryImpl";

    private final NewsRemoteSource remoteSource;
    private final NewsLocalDataStore localDataStore;


    public NewsRepositoryImpl(NewsRemoteSource remoteSource, NewsLocalDataStore localDataStore) {
        this.remoteSource = remoteSource;
        this.localDataStore = localDataStore;
    }


    @SuppressLint("CheckResult")
    @NotNull
    @Override
    public Single<List<Article>> getNewsArticle() {
        return remoteSource.getNewsArticle()
                .doOnSuccess(localDataStore::saveArticle)
                .onErrorResumeNext(localDataStore.fetchDataFromDB());
    }



}
