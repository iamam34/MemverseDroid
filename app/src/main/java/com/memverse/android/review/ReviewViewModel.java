package com.memverse.android.review;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.memverse.android.Repository;
import com.memverse.datacontracts.Verse;

/**
 * Holds view state and defines actions invoked from the view, for the Review section.
 * <p>
 * Created by amy on 10/12/17.
 */

@SuppressWarnings("WeakerAccess")
public class ReviewViewModel extends ViewModel {
    private LiveData<Verse> verse;

    public void init(long verseId) {
        this.verse = Repository.getVerse(verseId);
    }

    public LiveData<Verse> getVerse() {
        return verse;
    }

    public void rateVerse(int rating) {
        Repository.rateVerse(rating);
    }

}
