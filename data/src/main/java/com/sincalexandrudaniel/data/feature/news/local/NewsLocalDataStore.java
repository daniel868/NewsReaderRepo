package com.sincalexandrudaniel.data.feature.news.local;

import android.annotation.SuppressLint;
import android.util.Log;

import com.sincalexandrudaniel.data.feature.news.local.mapers.ArticleToNewsEntityMapper;
import com.sincalexandrudaniel.data.feature.news.local.mapers.NewsEntityToArticleMapper;
import com.sincalexandrudaniel.data.feature.news.model.Article;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class NewsLocalDataStore {
    private static final String TAG = "NewsLocalDataStore";

    private final NewsDao newsDao;

    public Flowable<List<NewsEntity>> getNewsEntities() {
        return newsDao.queryNewsList();
    }

    public Completable insert(NewsEntity newsEntity) {
        return newsDao.insertNews(newsEntity);
    }

    public NewsLocalDataStore(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    public Single<List<NewsEntity>> getAllEntities() {
        return newsDao.fetchDataFromDB();
    }

    public Single<List<Article>> fetchDataFromDB() {
        Log.d(TAG, "Getting data from DB");
        return getAllEntities().map(new NewsEntityToArticleMapper());
    }

    public Single<NewsEntity> queryEntityFromDB(String title) {
        return newsDao.queryNewsItem(title);
    }

    @SuppressLint("CheckResult")
    public void saveArticle(List<Article> articles) {
        Log.d(TAG, "saveArticle into localDataStore: Called");

        newsDao.deleteALLNews()
                .andThen(
                        Single.just(articles)
                                .map(new ArticleToNewsEntityMapper())
                                .flatMapCompletable(newsDao::insertAllNews)

                ).subscribeOn(Schedulers.io())
                .subscribe(
                        () -> Log.d(TAG, "Prev articles deleted and the new article saved to DB"),
                        throwable -> Log.e(TAG, "Failed deleted and saved from DB", throwable)
                );


    }
}
