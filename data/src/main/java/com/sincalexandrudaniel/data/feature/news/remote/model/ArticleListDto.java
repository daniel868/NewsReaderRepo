package com.sincalexandrudaniel.data.feature.news.remote.model;

import java.util.List;

public class ArticleListDto {
    public final int totalResult;
    public final List<ArticleDto> articles;

    public ArticleListDto(int totalResult, List<ArticleDto> articles) {
        this.totalResult = totalResult;
        this.articles = articles;
    }

}
