package com.memverse.android.dagger;

import com.memverse.android.dagger.util.ViewModelProviderFactory;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Top-level component for the Memverse Droid application.
 * Created by amy on 29/12/17.
 */
@Component(modules = {ViewModelModule.class})
@Singleton
public interface ApplicationComponent {
    ViewModelProviderFactory viewModelProviderFactory();
}
