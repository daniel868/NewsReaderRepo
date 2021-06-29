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
import com.sincalexandrudaniel.newsreader.models.fragment.FragmentItemViewModel;

import org.jetbrains.annotations.NotNull;

public class ItemFragment extends Fragment {
    private static final String DEFAULT_NEWS_TITLE = "DEFAULT_NEWS_TITLE";
    private static final String TAG = "ItemFragment";
    private FragmentItemViewModel viewModel;
    private String newsTitle;

    public static ItemFragment newInstance() {
        return new ItemFragment();
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            newsTitle = ItemFragmentArgs.fromBundle(getArguments()).getNewsTitle().toString();
        } catch (Exception e) {
            Log.e(TAG, "onCreate: ", e);
            newsTitle = DEFAULT_NEWS_TITLE;
        } finally {
            Log.d(TAG, "onCreate: NewsTitle passed as argument: " + newsTitle);
        }

        viewModel = new ViewModelProvider(this, new ViewModelFactory(requireActivity().getApplication(), newsTitle)).get(FragmentItemViewModel.class);

        getLifecycle().addObserver(viewModel);
        Log.d(TAG, "ItemFragment viewModel: ");
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        FragmentArticleBinding binding = FragmentArticleBinding.inflate(inflater, container, false);
        binding.setFragmentViewModel(viewModel);
        return binding.getRoot();
    }
}
