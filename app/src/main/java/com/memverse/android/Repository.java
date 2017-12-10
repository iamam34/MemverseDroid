package com.memverse.android;

import com.memverse.datacontracts.Verse;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstraction layer to retrieve and update persisted data.
 * Created by amy on 10/12/17.
 */

public class Repository {
    public List<Verse> getVerses() {
        ArrayList<Verse> verses = new ArrayList<>();
        verses.add(makeFakeVerse());
        return verses;
    }

    public boolean rateVerse(int rating) {
        throw new UnsupportedOperationException("Verse rating not yet implemented. Rating=" + rating);
    }

    private Verse makeFakeVerse() {
        return new Verse(
                111L,
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
}
