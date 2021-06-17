package com.sincalexandrudaniel.data.feature.news.local.mapers;

import com.sincalexandrudaniel.data.feature.news.local.NewsEntity;
import com.sincalexandrudaniel.data.feature.news.model.Article;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticleToNewsEntityMapper implements Function<List<Article>, List<NewsEntity>> {
    private final static String DEFAULT_TITLE = "Default Title";
    private final static String DEFAULT_CONTENT = "Default Content";
    private final static String DEFAULT_IMAGE_URL = "https://files.betamax.raywenderlich.com/attachments/collections/127/467591fe-b1b1-4ceb-af4d-543a54163d01.png";

    @Override
    public List<NewsEntity> apply(@NotNull List<Article> articles) {
        List<NewsEntity> newsEntities = new ArrayList<>();
        for (Article currentArticle : articles) {
            NewsEntity entity = new NewsEntity();
            entity.setNewsContent(!currentArticle.content.equals("") ? currentArticle.content : DEFAULT_CONTENT);
            entity.setNewsPhotoUri(!currentArticle.imageUrl.equals("") ? currentArticle.imageUrl : DEFAULT_IMAGE_URL);
            entity.setNewsTitle(!currentArticle.title.equals("") ? currentArticle.title : DEFAULT_TITLE);

            newsEntities.add(entity);
        }
        return newsEntities;
    }
}
