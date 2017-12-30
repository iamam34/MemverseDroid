package com.memverse.android.apiclient.api;

import com.memverse.android.apiclient.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface CurrentUserApi {
    /**
     * Returns credential for current user
     *
     * @return Call&lt;User&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("me")
    Call<User> findCurrentUser();


}
