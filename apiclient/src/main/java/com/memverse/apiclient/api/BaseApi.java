package com.memverse.apiclient.api;

import com.memverse.apiclient.ApiClient;

/**
 * Created by amy on 17/01/18.
 */

public abstract class BaseApi {
    protected ApiClient apiClient;

    public BaseApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
}
