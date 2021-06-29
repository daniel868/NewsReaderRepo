package com.sincalexandrudaniel.data;

import com.sincalexandrudaniel.data.feature.news.local.NewsEntity;
import com.sincalexandrudaniel.data.feature.news.model.Article;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

public interface NewsRepository {

    @NonNull
    Single<List<Article>> getNewsArticle();

    @NonNull
    Single<NewsEntity> getArticle(String title);
}
