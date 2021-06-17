package com.sincalexandrudaniel.data.feature.news.local;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "newsTable")
public class NewsEntity {

    @PrimaryKey(autoGenerate = true)
    @Nullable
    public Integer id;

    private String newsTitle;

    private String newsContent;

    private String newsPhotoUri;

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getNewsPhotoUri() {
        return newsPhotoUri;
    }

    public void setNewsPhotoUri(String newsPhotoUri) {
        this.newsPhotoUri = newsPhotoUri;
    }
}
