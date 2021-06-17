package com.sincalexandrudaniel.newsreader.models.mapers;

import android.content.Context;

import com.sincalexandrudaniel.data.feature.news.model.Article;
import com.sincalexandrudaniel.newsreader.models.ItemViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticleToItemViewModelMapper implements Function<List<Article>, List<ItemViewModel>> {
    //TODO: Add constants instead of strings
    private final static String DEFAULT_TITLE = "Default Title";
    private final static String DEFAULT_CONTENT = "Default Content";
    private final static String DEFAULT_IMAGE_URL = "https://files.betamax.raywenderlich.com/attachments/collections/127/467591fe-b1b1-4ceb-af4d-543a54163d01.png";


    private final Context context;

    public ArticleToItemViewModelMapper(Context context) {
        this.context = context;
    }


    @Override
    public List<ItemViewModel> apply(@NotNull List<Article> articles) throws Exception {
        List<ItemViewModel> itemViewModelList = new ArrayList<>();
        for (Article currentArticle : articles) {
            ItemViewModel itemViewModel = new ItemViewModel();
            itemViewModel.titleNewsReader.set(!currentArticle.title.equals("") ? currentArticle.title : DEFAULT_TITLE);
            itemViewModel.contentNewsReader.set(!currentArticle.content.equals("") ? currentArticle.content : DEFAULT_CONTENT);
            itemViewModel.imageNewsReader.set(!currentArticle.imageUrl.equals("") ? currentArticle.imageUrl : DEFAULT_IMAGE_URL);
            itemViewModelList.add(itemViewModel);
        }

        return itemViewModelList;
    }
}
