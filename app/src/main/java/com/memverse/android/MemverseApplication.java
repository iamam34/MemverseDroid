package com.memverse.android;

import android.app.Application;

import com.memverse.android.dagger.ApplicationComponent;
import com.memverse.android.dagger.DaggerApplicationComponent;

/**
 * Top-level Android application.
 * <p>
 * Created by amy on 29/12/17.
 */

public class MemverseApplication extends Application {

    private static MemverseApplication instance;

    private ApplicationComponent component;

    public static MemverseApplication getInstance() {
        return instance;
    }

    public ApplicationComponent getDaggerComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        component = DaggerApplicationComponent.create();
    }

}


