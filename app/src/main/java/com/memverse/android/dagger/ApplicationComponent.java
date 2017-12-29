package com.memverse.android.dagger;

import com.memverse.android.MemverseApplication;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * Top-level component for the Memverse Droid application.
 * Created by amy on 29/12/17.
 */
@Component(modules = {ViewModelModule.class, ActivityBindingModule.class, AndroidInjectionModule.class})
interface ApplicationComponent extends AndroidInjector<MemverseApplication> {
}
