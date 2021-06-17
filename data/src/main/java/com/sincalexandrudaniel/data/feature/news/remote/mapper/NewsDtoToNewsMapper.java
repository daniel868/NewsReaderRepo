package com.sincalexandrudaniel.data.feature.news.remote.mapper;

import com.sincalexandrudaniel.data.feature.news.model.Article;
import com.sincalexandrudaniel.data.feature.news.remote.model.ArticleDto;
import com.sincalexandrudaniel.data.feature.news.remote.model.ArticleListDto;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class NewsDtoToNewsMapper implements Function<ArticleListDto, List<Article>> {

    //TODO: get data from a dto  (dto = data transfer object )
    // and assign it to an article item



    @Override
    public List<Article> apply(@NotNull ArticleListDto articleListDto) throws Exception {
        List<Article> articles = new ArrayList<>();
        for (ArticleDto dto : articleListDto.articles) {
            Article article = new Article(
                    dto.urlToImage != null ? dto.urlToImage : "",
                    dto.title != null ? dto.title : "",
                    dto.content != null ? dto.content : "",
                    dto.description != null ? dto.description : ""
            );
            articles.add(article);
        }
        return articles;
    }
}
