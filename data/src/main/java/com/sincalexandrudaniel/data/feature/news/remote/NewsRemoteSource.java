package com.sincalexandrudaniel.data.feature.news.remote;

import com.sincalexandrudaniel.data.feature.news.model.Article;
import com.sincalexandrudaniel.data.feature.news.remote.mapper.NewsDtoToNewsMapper;
import com.sincalexandrudaniel.data.remote.NewsAPI;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class NewsRemoteSource {
    public static final String API_KEY = "dec01c28382047e8a74eaa1817dacaaa";
    private static final String EN_LANGUAGE_FILTER = "en";

    @NonNull
    private final NewsAPI newsAPI;

    public NewsRemoteSource(@NonNull NewsAPI newsAPI) {
        this.newsAPI = newsAPI;
    }

    public Single<List<Article>> getNewsArticle() {
        return newsAPI.getNewsArticles(API_KEY, EN_LANGUAGE_FILTER)
                .subscribeOn(Schedulers.io())
                .map(new NewsDtoToNewsMapper());
    }
}
