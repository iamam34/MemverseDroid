package com.memverse.android.apiclient.api;

import com.memverse.android.apiclient.model.Memverse;
import com.memverse.android.apiclient.model.Passage;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface PassageApi {
    /**
     * Delete a passage
     *
     * @param id ID of passage to delete (required)
     * @return Call&lt;Passage&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @DELETE("passages/{id}")
    Call<Passage> deletePassageById(
            @retrofit2.http.Path("id") Long id
    );

    /**
     * Returns a single passage by primary key (ID)
     *
     * @param id ID of passage to fetch (required)
     * @return Call&lt;Passage&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("passages/{id}")
    Call<Passage> findPassageById(
            @retrofit2.http.Path("id") Long id
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
     * Returns passages (consecutive memory verses) for current user
     *
     * @param page Page number requested (optional)
     * @return Call&lt;Passage&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("passages")
    Call<Passage> showPassages(
            @retrofit2.http.Query("page") Long page
    );

}
