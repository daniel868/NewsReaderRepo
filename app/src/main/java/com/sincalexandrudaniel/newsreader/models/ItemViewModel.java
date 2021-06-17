package com.sincalexandrudaniel.newsreader.models;

import androidx.databinding.ObservableField;

public class ItemViewModel {
    private static final String TAG = "ItemViewModel";

    public final ObservableField<String> titleNewsReader;
    public final ObservableField<String> contentNewsReader;
    public final ObservableField<String> imageNewsReader;

    public ItemViewModel() {
        titleNewsReader = new ObservableField<>();
        contentNewsReader = new ObservableField<>();
        imageNewsReader = new ObservableField<>();
    }
}
