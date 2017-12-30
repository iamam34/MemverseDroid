package com.memverse.android.apiclient.api;

import com.memverse.android.apiclient.model.Verse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface VerseApi {
    /**
     * Lookup a chapter by translation, book, and chapter number
     *
     * @param tl Bible translation of required verse (required)
     * @param bk Book (required)
     * @param ch Chapter (required)
     * @return Call&lt;Verse&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("verses/chapter")
    Call<Verse> findChapter(
            @retrofit2.http.Query("tl") String tl, @retrofit2.http.Query("bk") String bk, @retrofit2.http.Query("ch") String ch
    );

    /**
     * Returns a single verse
     *
     * @param id ID of verse to fetch (required)
     * @return Call&lt;Verse&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("verses/{id}")
    Call<Verse> findVerseById(
            @retrofit2.http.Path("id") Long id
    );

    /**
     * Search for a verse
     *
     * @param searchParams Search term expected in text of verse (required)
     * @return Call&lt;Verse&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("verses/search")
    Call<Verse> findVerseBySearchTerm(
            @retrofit2.http.Query("searchParams") String searchParams
    );

    /**
     * Lookup a verse by translation, book, chapter, and verse number
     *
     * @param tl Bible translation of required verse (required)
     * @param bk Book (required)
     * @param ch Chapter (required)
     * @param vs Verse number (required)
     * @return Call&lt;Verse&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("verses/lookup")
    Call<Verse> findVerseByTlBkChVs(
            @retrofit2.http.Query("tl") String tl, @retrofit2.http.Query("bk") String bk, @retrofit2.http.Query("ch") String ch, @retrofit2.http.Query("vs") String vs
    );

}
