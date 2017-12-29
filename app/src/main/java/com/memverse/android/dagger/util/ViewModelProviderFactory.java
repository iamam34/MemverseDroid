package com.memverse.android.dagger.util;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/**
 * Binds ViewModels for Dagger2
 * Copied from https://github.com/googlesamples/android-architecture-components/blob/619ef78/GithubBrowserSample/app/src/main/java/com/android/example/github/viewmodel/GithubViewModelFactory.java
 * <p>
 * Created by amy on 29/12/17.
 */

@Singleton
public class ViewModelProviderFactory implements ViewModelProvider.Factory {
    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> providerMap;

    @Inject
    ViewModelProviderFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> providerMap) {
        this.providerMap = providerMap;
    }

    @Override
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        Provider<? extends ViewModel> provider = providerMap.get(modelClass);
        if (provider == null) {
            for (Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> entry : providerMap.entrySet()) {
                if (modelClass.isAssignableFrom(entry.getKey())) {
                    provider = entry.getValue();
                    break;
                }
            }
        }
        if (provider == null) {
            throw new IllegalArgumentException("unknown model class " + modelClass);
        }
        try {
            //noinspection unchecked
            return (T) provider.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
