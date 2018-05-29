package com.memverse.apiclient.api;

import com.memverse.apiclient.ApiException;
import com.memverse.apiclient.MemverseApiConstants;
import com.memverse.apiclient.auth.OAuthFlow;
import com.memverse.apiclient.model.AccessToken;

/**
 * Created by amy on 17/01/18.
 */

public abstract class BaseApiTest {

    protected void configureAuthentication(BaseApi api) throws ApiException {
        api.getApiClient().setAccessToken(getAccessToken());
    }

    private String getAccessToken() throws ApiException {
        OAuthFlow grantType = OAuthFlow.PASSWORD;
        String username = MemverseApiConstants.USERNAME;
        String password = MemverseApiConstants.PASSWORD;
        String clientId = MemverseApiConstants.CLIENT_ID;

        AuthorizationApi authorizationApi = new AuthorizationApi();
        AccessToken response = authorizationApi.requestAccessToken(grantType, username, password, clientId);
        return response.getAccessToken();
    }
}
