package com.sincalexandrudaniel.newsreader.models;

import android.view.View;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

public class ItemViewModel {

    public final ObservableField<String> titleNewsReader;
    public final ObservableField<String> contentNewsReader;
    public final ObservableField<String> imageNewsReader;

    public ItemViewModel() {
        titleNewsReader = new ObservableField<>();
        contentNewsReader = new ObservableField<>();
        imageNewsReader = new ObservableField<>();
    }
}
