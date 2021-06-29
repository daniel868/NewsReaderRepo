package com.sincalexandrudaniel.data.feature.news.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface NewsDao {
    @Query("SELECT * FROM newsTable")
    Flowable<List<NewsEntity>> queryNewsList();

    @Query("SELECT * FROM newsTable")
    Single<List<NewsEntity>> fetchDataFromDB();

    @Query("SELECT * FROM newsTable where newsTitle=:title")
    Single<NewsEntity> queryNewsItem(String title);

    @Query("DELETE FROM newsTable where id=:id")
    Completable deleteNewsItem(int id);

    @Query("DELETE FROM newsTable")
    Completable deleteALLNews();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertAllNews(List<NewsEntity> newsEntities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertNews(NewsEntity entity);

    @Query("UPDATE newsTable SET newsTitle =:newsTitle, newsPhotoUri =:newsImageUri where id =:id")
    Completable updateNews(String newsTitle, String newsImageUri, int id);

}
