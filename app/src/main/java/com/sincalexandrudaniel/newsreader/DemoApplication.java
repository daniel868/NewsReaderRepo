package com.sincalexandrudaniel.newsreader;

import android.app.Application;

import com.sincalexandrudaniel.data.di.RepoModule;

public class DemoApplication extends Application {
    private static RepoModule repoModule;

    @Override
    public void onCreate() {
        super.onCreate();
        this.repoModule = new RepoModule(this);
    }

    public static RepoModule getRepoModule() {
        return repoModule;
    }
}
