package com.memverse.apiclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by amy on 16/01/18.
 */

public class AccessToken {

    @SerializedName("access_token")
    private String accessToken = null;

    @SerializedName("token_type")
    private String tokenType = null;

    @SerializedName("scope")
    private String scope = null;

    @SerializedName("created_at")
    private Date createdAt = null;

    public AccessToken accessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    @ApiModelProperty(required = true, value = "")
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public AccessToken tokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    @ApiModelProperty(required = true, value = "")
    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public AccessToken scope(String scope) {
        this.scope = scope;
        return this;
    }

    @ApiModelProperty(required = true, value = "")
    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public AccessToken createdAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @ApiModelProperty(required = true, value = "")
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
