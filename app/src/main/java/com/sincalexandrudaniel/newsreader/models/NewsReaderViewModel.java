package com.sincalexandrudaniel.newsreader.models;

import android.util.Log;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

public class NewsReaderViewModel extends ViewModel implements LifecycleObserver {
    private static final String TAG = "NewsReaderViewModel";

    public final ObservableList<ItemViewModel> items;

    public NewsReaderViewModel() {
        this.items = new ObservableArrayList<>();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void refresh() {
        Log.d(TAG, "refresh: Called ");

        if (items.isEmpty()) {
            ItemViewModel itemViewModel = new ItemViewModel();
            itemViewModel.contentNewsReader.set("TestContent");
            itemViewModel.titleNewsReader.set("TestTitle");
            itemViewModel.imageNewsReader.set("https://digipedia.ro/wp-content/uploads/2017/08/ANDROID.png");
            items.add(itemViewModel);
            ItemViewModel itemViewModel1 = new ItemViewModel();
            itemViewModel1.contentNewsReader.set("TestContent1");
            itemViewModel1.titleNewsReader.set("TestTitle2");
            itemViewModel1.imageNewsReader.set("https://yt3.ggpht.com/ytc/AAUvwnix1W5yfYHFVUru51TRhdeSyFkMhglTrBp_IYP1qA=s900-c-k-c0x00ffffff-no-rj");
            items.add(itemViewModel1);
        }
    }
}
