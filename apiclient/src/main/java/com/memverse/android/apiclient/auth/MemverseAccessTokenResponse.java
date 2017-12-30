package com.memverse.android.apiclient.auth;

import org.apache.oltu.oauth2.client.response.OAuthAccessTokenResponse;
import org.apache.oltu.oauth2.common.token.BasicOAuthToken;
import org.apache.oltu.oauth2.common.token.OAuthToken;
import org.apache.oltu.oauth2.common.utils.JSONUtils;

import java.util.Map;

/**
 * Created by amy on 30/12/17.
 */

public class MemverseAccessTokenResponse extends OAuthAccessTokenResponse {

    public String getAccessToken() {
        return getParam(org.apache.oltu.oauth2.common.OAuth.OAUTH_ACCESS_TOKEN);
    }

    public Long getExpiresIn() {
        String value = getParam(org.apache.oltu.oauth2.common.OAuth.OAUTH_EXPIRES_IN);
        return value == null ? null : Long.valueOf(value);
    }

    public String getRefreshToken() {
        return getParam(org.apache.oltu.oauth2.common.OAuth.OAUTH_EXPIRES_IN);
    }

    public String getScope() {
        return getParam(org.apache.oltu.oauth2.common.OAuth.OAUTH_SCOPE);
    }

    public OAuthToken getOAuthToken() {
        return new BasicOAuthToken(getAccessToken(), getExpiresIn(), getRefreshToken(), getScope());
    }

    protected void setBody(String body) {
        this.body = body;
        parameters = decodeJsonBody(body);
    }

    private Map<String, Object> decodeJsonBody(String body) {
        if (body == null || body.isEmpty()) {
            body = "{}";
        }
        return JSONUtils.parseJSON(body);
    }

    protected void setContentType(String contentType) {
        this.contentType = contentType;
    }

    protected void setResponseCode(int code) {
        this.responseCode = code;
    }
}
