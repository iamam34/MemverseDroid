package com.memverse.android.review;

import android.arch.lifecycle.ViewModel;

import com.memverse.android.Repository;
import com.memverse.datacontracts.Verse;

/**
 * Holds view state and defines actions invoked from the view, for the Review section.
 * <p>
 * Created by amy on 10/12/17.
 */

public class ReviewViewModel extends ViewModel {

    private final Repository _repository;

    private Verse currentVerse;
    private String guess;

    public ReviewViewModel(Repository repository) { // TODO use Dagger2 for DependencyInjection
        _repository = repository;

        guess = "";
    }

    public Verse getCurrentVerse() {
        if (currentVerse == null) {
            currentVerse = _repository.getVerses().get(0);
        }
        return currentVerse;
    }

    public boolean rateVerse(int rating) {
        return _repository.rateVerse(rating);
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }
}
