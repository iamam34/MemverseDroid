package com.memverse.android.dagger;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.memverse.android.dagger.util.ViewModelKey;
import com.memverse.android.dagger.util.ViewModelProviderFactory;
import com.memverse.android.review.ReviewViewModel;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Module defining injectable ViewModels. For use with custom ViewModelProviderFactory.
 * <p>
 * Created by amy on 29/12/17.
 */
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ReviewViewModel.class)
    abstract ViewModel bindReviewViewModel(ReviewViewModel reviewViewModel);

    @Binds
    @Singleton
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory factory);
}
