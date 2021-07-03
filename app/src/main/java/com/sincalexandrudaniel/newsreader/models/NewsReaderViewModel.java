package com.sincalexandrudaniel.newsreader.models;import android.annotation.SuppressLint;import android.app.Application;import android.util.Log;import androidx.annotation.NonNull;import androidx.databinding.ObservableArrayList;import androidx.databinding.ObservableBoolean;import androidx.databinding.ObservableField;import androidx.databinding.ObservableList;import androidx.lifecycle.AndroidViewModel;import androidx.lifecycle.Lifecycle;import androidx.lifecycle.LifecycleObserver;import androidx.lifecycle.OnLifecycleEvent;import com.sincalexandrudaniel.data.NewsRepository;import com.sincalexandrudaniel.newsreader.R;import com.sincalexandrudaniel.newsreader.models.mapers.ArticleToItemViewModelMapper;import com.sincalexandrudaniel.newsreader.reactive.SingleLiveEvent;import java.util.List;import io.reactivex.android.schedulers.AndroidSchedulers;import io.reactivex.disposables.Disposable;public class NewsReaderViewModel extends AndroidViewModel implements LifecycleObserver {    public static final String LINK = "https://newsapi.org/";    private static final String TAG = "NewsReaderViewModel";    public final ObservableList<ItemViewModel> items;    public final ObservableBoolean isLoading;    private final NewsRepository repository;    private final ObservableField<String> resultText;    private final SingleLiveEvent<Throwable> error;    private final SingleLiveEvent<String> openLink;    private Disposable disposable;    public NewsReaderViewModel(Application application, NewsRepository repository) {        super(application);        this.items = new ObservableArrayList<>();        this.repository = repository;        this.isLoading = new ObservableBoolean();        this.resultText = new ObservableField<>();        this.error = new SingleLiveEvent<>();        this.openLink = new SingleLiveEvent<>();    }    @SuppressLint("CheckResult")    @OnLifecycleEvent(Lifecycle.Event.ON_START)    public void refresh() {        Log.d(TAG, "refresh: Called ");        if ((disposable == null || disposable.isDisposed()) && items.isEmpty()) {            isLoading.set(true);            disposable = repository.getNewsArticle()                    .map(new ArticleToItemViewModelMapper(getApplication()))                    .observeOn(AndroidSchedulers.mainThread())                    .subscribe(                            this::onNewsArticleReceived,                            this::onNewsArticleError);        }    }    private void onNewsArticleReceived(@NonNull List<ItemViewModel> articles) {        isLoading.set(false);        resultText.set(getApplication().getString(R.string.results, articles.size()));        items.clear();        items.addAll(articles);    }    private void onNewsArticleError(Throwable throwable) {        isLoading.set(false);        error.setValue(throwable);    }    public void onPoweredBySelected() {        openLink.setValue(LINK);    }}