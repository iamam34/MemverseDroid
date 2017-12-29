package com.memverse.android.dagger;

import com.memverse.android.MainActivity;
import com.memverse.android.list.MemversesListFragment;
import com.memverse.android.review.ReviewFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * We want Dagger.Android to create a Subcomponent which has a parent Component of whichever module ActivityBindingModule is on,
 * in our case that will be AppComponent. The beautiful part about this setup is that you never need to tell AppComponent that it is going to have all these subcomponents
 * nor do you need to tell these subcomponents that AppComponent exists.
 * We are also telling Dagger.Android that this generated SubComponent needs to include the specified modules and be aware of a scope annotation @ActivityScoped
 * When Dagger.Android annotation processor runs it will create one subcomponent for each activity.
 * <p>
 * Created by amy on 29/12/17.
 */
@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    @Singleton
    public abstract MainActivity contributeMainActivityInjector();

    @ContributesAndroidInjector
    @Singleton
    public abstract ReviewFragment contributeReviewFragmentInjector();

    @ContributesAndroidInjector
    @Singleton
    public abstract MemversesListFragment contributeMemversesListFragmentInjector();

}
