package com.sincalexandrudaniel.data.feature.news.local.store;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.sincalexandrudaniel.data.feature.news.local.NewsDao;
import com.sincalexandrudaniel.data.feature.news.local.NewsEntity;

@Database(entities = {NewsEntity.class}, version = 1)
public abstract class NewsDatabase extends RoomDatabase {

    public abstract NewsDao newsDao();

}
