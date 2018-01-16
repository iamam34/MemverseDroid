/*
 * Swagger Memverse
 * Memverse API
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.memverse.apiclient.api;

import com.memverse.apiclient.ApiClient;
import com.memverse.apiclient.ApiException;
import com.memverse.apiclient.model.AccessToken;

import org.junit.Test;

import java.util.Date;

import static com.memverse.apiclient.CustomMatchers.isWithinASecondOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * API tests for AuthorizationApi
 */
public class AuthorizationApiTest {


    private static final String clientId = null;
    private static final String clientSecret = null;

    private final AuthorizationApi api;

    public AuthorizationApiTest() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath("https://www.memverse.com");
        apiClient.setUsername(clientId);
        apiClient.setPassword(clientSecret);
        api = new AuthorizationApi(apiClient);
    }


    /**
     * Request an API access token. This access token should be used for all future requests as per the Oauth2 Password Flow.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void requestAccessTokenTest() throws ApiException {
        String grantType = "password";
        String username = null;
        String password = null;
        String clientId = AuthorizationApiTest.clientId;
        AccessToken response = api.requestAccessToken(grantType, username, password, clientId);

        assertNotNull(response);
        assertNotNull(response.getAccessToken());
        assertNotEquals("", response.getAccessToken());
        assertEquals("bearer", response.getTokenType());
        assertEquals("public", response.getScope());
        assertThat(response.getCreatedAt(), isWithinASecondOf(new Date()));
    }
}
