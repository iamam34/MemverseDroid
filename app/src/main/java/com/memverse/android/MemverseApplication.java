package com.memverse.android;

import android.support.v4.app.Fragment;

import com.memverse.android.dagger.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Top-level Android application.
 * <p>
 * Created by amy on 29/12/17.
 */

public class MemverseApplication extends DaggerApplication implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingFragmentInjector;

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.create();
    }

    /**
     * Implements HasSupportFragmentInjector because superclass DaggerApplication only handles non-support Fragments.
     *
     * @return dispatchingFragmentInjector
     */
    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingFragmentInjector;
    }

}


