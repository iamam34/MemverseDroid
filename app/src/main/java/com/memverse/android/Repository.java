package com.memverse.android;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.memverse.datacontracts.Verse;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstraction layer to retrieve and update persisted data.
 * Created by amy on 10/12/17.
 */

public class Repository {
    private static final String LOG_TAG = Repository.class.getCanonicalName();

    public static List<Verse> getVerses() {
        ArrayList<Verse> verses = new ArrayList<>();
        verses.add(makeFakeVerse(1L));
        verses.add(makeFakeVerse(1L));
        verses.add(makeFakeVerse(1L));
        verses.add(makeFakeVerse(1L));
        verses.add(makeFakeVerse(1L));
        verses.add(makeFakeVerse(1L));
        verses.add(makeFakeVerse(1L));
        verses.add(makeFakeVerse(1L));
        verses.add(makeFakeVerse(1L));
        verses.add(makeFakeVerse(1L));
        verses.add(makeFakeVerse(1L));
        verses.add(makeFakeVerse(1L));
        verses.add(makeFakeVerse(1L));
        return verses;
    }

    public static void rateVerse(int rating) {
        Log.i(LOG_TAG, "Verse rating not yet implemented. Rating=" + rating);
    }

    private static Verse makeFakeVerse(long verseId) {
        return new Verse(
                verseId,
                null,
                1L,
                "Genesis",
                "1",
                1L,
                "In the beginning God created heaven and earth.",
                "2017-12-07",
                "2017-12-10",
                false,
                null,
                null);
    }

    public static LiveData<Verse> getVerse(long verseId) {
        MutableLiveData<Verse> liveData = new MutableLiveData<>();
        liveData.setValue(makeFakeVerse(verseId));
        return liveData;
    }
}
