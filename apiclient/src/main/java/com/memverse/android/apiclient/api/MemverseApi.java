package com.memverse.android.apiclient.api;

import com.memverse.android.apiclient.model.Memverse;
import com.memverse.android.apiclient.model.MemverseInput;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface MemverseApi {
    /**
     * Creates a new memory verse
     *
     * @param verseId ID of verse to add as a new memory verse for current user (required)
     * @return Call&lt;Memverse&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("memverses")
    Call<Memverse> createMemverse(
            @retrofit2.http.Body MemverseInput verseId
    );

    /**
     * Delete a memory verse
     *
     * @param id ID of memory verse to delete (required)
     * @return Call&lt;Memverse&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @DELETE("memverses/{id}")
    Call<Memverse> deleteMemverseById(
            @retrofit2.http.Path("id") Long id
    );

    /**
     * Returns a single memory verse
     *
     * @param id ID of memory verse to fetch (required)
     * @return Call&lt;Memverse&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("memverses/{id}")
    Call<Memverse> findMemverseById(
            @retrofit2.http.Path("id") Long id
    );

    /**
     * Returns memory verses for current user
     *
     * @param sort Field to specify sort order (optional)
     * @param page Page number requested (optional)
     * @return Call&lt;Memverse&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("memverses")
    Call<Memverse> showMemverses(
            @retrofit2.http.Query("sort") String sort, @retrofit2.http.Query("page") Long page
    );

    /**
     * Returns memory verses for a given passage
     *
     * @param passageId ID of passage (required)
     * @param page      Page number requested (optional)
     * @return Call&lt;Memverse&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("passages/{passage_id}/memverses")
    Call<Memverse> showMemversesForPassage(
            @retrofit2.http.Path("passage_id") Long passageId, @retrofit2.http.Query("page") Long page
    );

    /**
     * Record a rating for a memory verse
     *
     * @param id ID of memory verse to update (required)
     * @param q  Rating of verse recall (required)
     * @return Call&lt;Memverse&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @PUT("memverses/{id}")
    Call<Memverse> updateMemverseById(
            @retrofit2.http.Path("id") Long id, @retrofit2.http.Query("q") Long q
    );

}
