package com.sincalexandrudaniel.data.remote;

import com.sincalexandrudaniel.data.feature.news.remote.model.ArticleDto;
import com.sincalexandrudaniel.data.feature.news.remote.model.ArticleListDto;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsAPI {
    @GET("/v2/top-headlines")
    Single<ArticleListDto> getNewsArticles(@Query("apiKey") String apiKey, @Query("language") String language);
}
