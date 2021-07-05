package com.sincalexandrudaniel.newsreader.ui.itemfragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.sincalexandrudaniel.newsreader.databinding.FragmentArticleBinding;
import com.sincalexandrudaniel.newsreader.models.ViewModelFactory;
import com.sincalexandrudaniel.newsreader.models.fragment.ReadArticleViewModel;

import org.jetbrains.annotations.NotNull;

public class ReadArticleFragment extends Fragment {
    private static final String TAG = "ItemFragment";
    private ReadArticleViewModel viewModel;

    public static ReadArticleFragment newInstance() {
        return new ReadArticleFragment();
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String newsTitle = ReadArticleFragmentArgs.fromBundle(getArguments()).getNewsTitle();

        viewModel = new ViewModelProvider(this, new ViewModelFactory(requireActivity().getApplication(), newsTitle)).get(ReadArticleViewModel.class);

        getLifecycle().addObserver(viewModel);
        Log.d(TAG, "ItemFragment viewModel: ");
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        FragmentArticleBinding binding = FragmentArticleBinding.inflate(inflater, container, false);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }
}
