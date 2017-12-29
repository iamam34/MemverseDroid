package com.memverse.android.review;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.memverse.android.Repository;
import com.memverse.datacontracts.Verse;

import javax.inject.Inject;

/**
 * Holds view state and defines actions invoked from the view, for the Review section.
 * <p>
 * Created by amy on 10/12/17.
 */

@SuppressWarnings("WeakerAccess")
public class ReviewViewModel extends ViewModel {

    private static final String LOG_TAG = ReviewViewModel.class.getCanonicalName();

    public final LiveData<Verse> verse;
    public final MutableLiveData<String> guess = new MutableLiveData<>();

    private final Repository repository;
    private final MutableLiveData<Long> verseIdInput = new MutableLiveData<>();

    @Inject
    public ReviewViewModel(Repository repository) {
        Log.d(LOG_TAG, "calling constructor");

        this.repository = repository;

        verseIdInput.setValue(repository.getNextVerseId(null));
        verse = Transformations.switchMap(verseIdInput, new Function<Long, LiveData<Verse>>() {
            @Override
            public LiveData<Verse> apply(Long verseId) {
                return ReviewViewModel.this.repository.getVerse(verseId);
            }
        });
    }

    public void rateVerse(int rating) {
        repository.rateVerse(rating);
    }

    public void goToNextVerse() {
        long nextVerseId = repository.getNextVerseId(verseIdInput.getValue());
        verseIdInput.setValue(nextVerseId);
    }

}
