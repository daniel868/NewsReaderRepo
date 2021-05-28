package com.sincalexandrudaniel.newsreader.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sincalexandrudaniel.newsreader.databinding.ItemNewsReaderBinding;
import com.sincalexandrudaniel.newsreader.databinding.ItemNewsReaderBindingImpl;
import com.sincalexandrudaniel.newsreader.models.ItemViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class NewsReaderAdapter extends RecyclerView.Adapter<NewsReaderAdapter.NewsViewHolder> {
    private List<ItemViewModel> newsReaderList;

    public NewsReaderAdapter() {
        this.newsReaderList = new ArrayList<>();
    }

    @NonNull
    @NotNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ItemNewsReaderBinding binder = ItemNewsReaderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new NewsViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NewsViewHolder holder, int position) {
        holder.binding.setViewModel(newsReaderList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsReaderList.size();
    }

    public void setNewsReaderList(List<ItemViewModel> newsReaderList) {
        this.newsReaderList = newsReaderList;
        notifyDataSetChanged();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        final ItemNewsReaderBinding binding;

        public NewsViewHolder(ItemNewsReaderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
