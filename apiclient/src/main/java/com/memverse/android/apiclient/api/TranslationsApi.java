package com.memverse.android.apiclient.api;

import com.memverse.android.apiclient.model.Translation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface TranslationsApi {
    /**
     * Returns available Bible translations
     *
     * @return Call&lt;Translation&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("translations")
    Call<Translation> showTranslations();


}
