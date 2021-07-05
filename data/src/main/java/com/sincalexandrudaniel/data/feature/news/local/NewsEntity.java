package com.sincalexandrudaniel.data.feature.news.local;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "newsTable")
public class NewsEntity {

    @PrimaryKey(autoGenerate = true)
    @Nullable
    public Integer id;

    public final String newsTitle;

    public final String newsContent;

    public final String newsPhotoUri;

    public NewsEntity(String newsTitle, String newsContent, String newsPhotoUri) {
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.newsPhotoUri = newsPhotoUri;
    }
}
