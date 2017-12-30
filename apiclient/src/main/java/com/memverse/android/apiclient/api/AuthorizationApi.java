package com.memverse.android.apiclient.api;

import com.memverse.android.apiclient.model.User;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AuthorizationApi {
    /**
     * Request an API access token. This access token should be used for all future requests as per the Oauth2 Password Flow.
     *
     * @param grantType Password flow is best option for supporting a mobile app (required)
     * @param username  User name on Memverse.com (email address) (required)
     * @param password  User password on Memverse.com (required)
     * @param clientId  Contact admin@memverse.com to get a client_id (required)
     * @return Call&lt;User&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("oauth/token")
    Call<User> requestAccessToken(
            @retrofit2.http.Path("grant_type") String grantType, @retrofit2.http.Path("username") String username, @retrofit2.http.Path("password") String password, @retrofit2.http.Path("client_id") String clientId
    );

}
