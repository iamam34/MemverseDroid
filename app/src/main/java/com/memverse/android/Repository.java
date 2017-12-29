package com.memverse.android;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.memverse.datacontracts.Verse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Abstraction layer to retrieve and update persisted data.
 * Created by amy on 10/12/17.
 */
@Singleton
public class Repository {

    private static final String LOG_TAG = Repository.class.getCanonicalName();

    private final ArrayList<Verse> verses;

    {
        verses = new ArrayList<>();
        verses.add(makeFakeVerse(0L));
        verses.add(makeFakeVerse(1L));
        verses.add(makeFakeVerse(2L));
        verses.add(makeFakeVerse(3L));
        verses.add(makeFakeVerse(4L));
        verses.add(makeFakeVerse(5L));
        verses.add(makeFakeVerse(6L));
        verses.add(makeFakeVerse(7L));
        verses.add(makeFakeVerse(8L));
        verses.add(makeFakeVerse(9L));
        verses.add(makeFakeVerse(10L));
        verses.add(makeFakeVerse(11L));
        verses.add(makeFakeVerse(12L));
        verses.add(makeFakeVerse(13L));
    }

    @Inject
    Repository() {

    }

    public List<Verse> getVerses() {
        return verses;
    }

    public void rateVerse(int rating) {
        Log.i(LOG_TAG, "Verse rating not yet implemented. Rating=" + rating);
    }

    public LiveData<Verse> getVerse(long verseId) {
        if (verseId >= verses.size()) {
            throw new IllegalArgumentException(String.format("%s is not a valid verseId", verseId));
        }
        MutableLiveData<Verse> liveData = new MutableLiveData<>();
        liveData.setValue(verses.get((int) verseId));
        return liveData;
    }

    public long getNextVerseId(final Long oldVerseId) {
        long nextVerseId;
        if (oldVerseId == null || oldVerseId < 0) {
            nextVerseId = 0;
        } else {
            nextVerseId = (oldVerseId + 1) % verses.size(); // TODO filter verses on next_test date and pick earliest
        }
        return nextVerseId;
    }

    private static Verse makeFakeVerse(long verseId) {
        return new Verse(
                verseId,
                null,
                1L,
                "Genesis",
                "1",
                1L,
                String.format("[%s] In the beginning God created heaven and earth.", verseId),
                "2017-12-07",
                "2017-12-10",
                false,
                null,
                null);
    }
}
