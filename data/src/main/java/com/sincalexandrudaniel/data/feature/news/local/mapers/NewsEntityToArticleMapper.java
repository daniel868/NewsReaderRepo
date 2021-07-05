package com.sincalexandrudaniel.data.feature.news.local.mapers;

import com.sincalexandrudaniel.data.feature.news.local.NewsEntity;
import com.sincalexandrudaniel.data.feature.news.model.Article;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class NewsEntityToArticleMapper implements Function<List<NewsEntity>, List<Article>> {
    @Override
    public List<Article> apply(@NotNull List<NewsEntity> newsEntities) throws Exception {
        List<Article> articleList = new ArrayList<>();
        for (NewsEntity currentEntity : newsEntities) {
            Article article = new Article(currentEntity.newsPhotoUri, currentEntity.newsTitle,
                    currentEntity.newsContent, "");
            articleList.add(article);
        }
        return articleList;
    }
}
