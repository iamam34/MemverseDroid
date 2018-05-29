package com.memverse.apiclient.model;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by amy on 17/01/18.
 */

public class Response<T> {

    @SerializedName("response")
    private T response = null;

    public Response<T> response(T response) {
        this.response = response;
        return this;
    }

    @ApiModelProperty(required = true, value = "")
    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

}
