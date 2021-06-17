package com.sincalexandrudaniel.data.di;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.sincalexandrudaniel.data.NewsRepository;
import com.sincalexandrudaniel.data.feature.news.NewsRepositoryImpl;
import com.sincalexandrudaniel.data.feature.news.local.NewsLocalDataStore;
import com.sincalexandrudaniel.data.feature.news.local.store.NewsDatabase;
import com.sincalexandrudaniel.data.feature.news.remote.NewsRemoteSource;
import com.sincalexandrudaniel.data.remote.HttpClientFactory;

import io.reactivex.annotations.NonNull;

public class RepoModule {
    @NonNull
    private Context context;

    @NonNull
    private HttpClientFactory httpClientFactory;


    private volatile NewsDatabase database;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource(), provideLocalDataStore());
    }

    private NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsAPI());
    }

    private NewsLocalDataStore provideLocalDataStore() {
        NewsDatabase database = getInstance();
        return new NewsLocalDataStore(database.newsDao());
    }

    private NewsDatabase getInstance() {
        if (database == null) {
            synchronized (NewsDatabase.class) {
                if (database == null) {
                    database = Room.databaseBuilder(context.getApplicationContext(),
                            NewsDatabase.class, "News.db").build();
                }
            }
        }
        return database;
    }
}
