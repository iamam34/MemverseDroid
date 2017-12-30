package com.memverse.android.apiclient.api;

import com.memverse.android.apiclient.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface UserApi {
    /**
     * Creates a new user
     *
     * @param name     User name (required)
     * @param email    User email (required)
     * @param password User password (required)
     * @return Call&lt;User&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("users")
    Call<User> createUser(
            @retrofit2.http.Query("name") String name, @retrofit2.http.Query("email") String email, @retrofit2.http.Query("password") String password
    );

    /**
     * Returns a single user
     *
     * @param id ID of user to fetch (required)
     * @return Call&lt;User&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("users/{id}")
    Call<User> findUserById(
            @retrofit2.http.Path("id") Long id
    );

    /**
     * Partial updates to a user
     *
     * @param id ID of user to update (required)
     * @return Call&lt;User&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @PUT("users/{id}")
    Call<User> updateUserById(
            @retrofit2.http.Path("id") Long id
    );

}
