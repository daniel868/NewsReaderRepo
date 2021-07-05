package com.sincalexandrudaniel.newsreader.binding;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sincalexandrudaniel.newsreader.adapter.NewsReaderAdapter;
import com.sincalexandrudaniel.newsreader.models.ItemViewModel;

import java.util.List;

public class RecyclerBinder {

    @BindingAdapter("items")
    public static void addItems(RecyclerView recyclerView, List<ItemViewModel> itemViewModelList) {
        NewsReaderAdapter adapter = (NewsReaderAdapter) recyclerView.getAdapter();
        if (adapter == null) {
            adapter = new NewsReaderAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(adapter);
        }
        adapter.setNewsReaderList(itemViewModelList);
    }
}

