package com.sincalexandrudaniel.newsreader.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.sincalexandrudaniel.newsreader.databinding.MainFragmentBinding;
import com.sincalexandrudaniel.newsreader.models.NewsReaderViewModel;
import com.sincalexandrudaniel.newsreader.models.ViewModelFactory;

import org.jetbrains.annotations.NotNull;

public class NewsListFragment extends Fragment {
    private static final String TAG = "MainFragment";
    private NewsReaderViewModel viewModel;

    public static NewsListFragment newInstance() {
        return new NewsListFragment();
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this, new ViewModelFactory(requireActivity().getApplication())).get(NewsReaderViewModel.class);

        getLifecycle().addObserver(viewModel);
        Log.d(TAG, "onCreate: " + viewModel);
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        MainFragmentBinding binding = MainFragmentBinding.inflate(inflater, container, false);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

}