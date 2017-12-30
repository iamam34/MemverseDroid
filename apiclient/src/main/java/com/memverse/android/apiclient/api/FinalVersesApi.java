package com.memverse.android.apiclient.api;

import com.memverse.android.apiclient.model.FinalVerse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface FinalVersesApi {
    /**
     * Returns final verse for each chapter of the Bible
     *
     * @return Call&lt;FinalVerse&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("final_verses")
    Call<FinalVerse> showFinalVerses();


}
