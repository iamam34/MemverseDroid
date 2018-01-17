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

import com.google.gson.reflect.TypeToken;
import com.memverse.apiclient.ApiCallback;
import com.memverse.apiclient.ApiClient;
import com.memverse.apiclient.ApiException;
import com.memverse.apiclient.ApiResponse;
import com.memverse.apiclient.Configuration;
import com.memverse.apiclient.Pair;
import com.memverse.apiclient.ProgressRequestBody;
import com.memverse.apiclient.ProgressResponseBody;
import com.memverse.apiclient.model.Memverse;
import com.memverse.apiclient.model.Passage;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassageApi extends BaseApi {
    public PassageApi() {
        this(Configuration.getDefaultApiClient());
    }

    public PassageApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Build call for deletePassageById
     *
     * @param id                      ID of passage to delete (required)
     * @param progressListener        Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deletePassageByIdCall(Long id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/passages/{id}"
                .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                            .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                            .build();
                }
            });
        }

        String[] localVarAuthNames = new String[]{"oauth2"};
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deletePassageByIdValidateBeforeCall(Long id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {

        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deletePassageById(Async)");
        }


        com.squareup.okhttp.Call call = deletePassageByIdCall(id, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Delete a passage
     *
     * @param id ID of passage to delete (required)
     * @return Passage
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Passage deletePassageById(Long id) throws ApiException {
        ApiResponse<Passage> resp = deletePassageByIdWithHttpInfo(id);
        return resp.getData();
    }

    /**
     * Delete a passage
     *
     * @param id ID of passage to delete (required)
     * @return ApiResponse&lt;Passage&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Passage> deletePassageByIdWithHttpInfo(Long id) throws ApiException {
        com.squareup.okhttp.Call call = deletePassageByIdValidateBeforeCall(id, null, null);
        Type localVarReturnType = new TypeToken<Passage>() {
        }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * (asynchronously)
     * Delete a passage
     *
     * @param id       ID of passage to delete (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deletePassageByIdAsync(Long id, final ApiCallback<Passage> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deletePassageByIdValidateBeforeCall(id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Passage>() {
        }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }

    /**
     * Build call for findPassageById
     *
     * @param id                      ID of passage to fetch (required)
     * @param progressListener        Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call findPassageByIdCall(Long id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/passages/{id}"
                .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                            .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                            .build();
                }
            });
        }

        String[] localVarAuthNames = new String[]{"oauth2"};
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call findPassageByIdValidateBeforeCall(Long id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {

        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling findPassageById(Async)");
        }


        com.squareup.okhttp.Call call = findPassageByIdCall(id, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns a single passage by primary key (ID)
     *
     * @param id ID of passage to fetch (required)
     * @return Passage
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Passage findPassageById(Long id) throws ApiException {
        ApiResponse<Passage> resp = findPassageByIdWithHttpInfo(id);
        return resp.getData();
    }

    /**
     * Returns a single passage by primary key (ID)
     *
     * @param id ID of passage to fetch (required)
     * @return ApiResponse&lt;Passage&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Passage> findPassageByIdWithHttpInfo(Long id) throws ApiException {
        com.squareup.okhttp.Call call = findPassageByIdValidateBeforeCall(id, null, null);
        Type localVarReturnType = new TypeToken<Passage>() {
        }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * (asynchronously)
     * Returns a single passage by primary key (ID)
     *
     * @param id       ID of passage to fetch (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call findPassageByIdAsync(Long id, final ApiCallback<Passage> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = findPassageByIdValidateBeforeCall(id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Passage>() {
        }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }

    /**
     * Build call for showMemversesForPassage
     *
     * @param passageId               ID of passage (required)
     * @param page                    Page number requested (optional)
     * @param progressListener        Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call showMemversesForPassageCall(Long passageId, Long page, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/passages/{passage_id}/memverses"
                .replaceAll("\\{" + "passage_id" + "\\}", apiClient.escapeString(passageId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (page != null)
            localVarQueryParams.addAll(apiClient.parameterToPair("page", page));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                            .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                            .build();
                }
            });
        }

        String[] localVarAuthNames = new String[]{"oauth2"};
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call showMemversesForPassageValidateBeforeCall(Long passageId, Long page, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {

        // verify the required parameter 'passageId' is set
        if (passageId == null) {
            throw new ApiException("Missing the required parameter 'passageId' when calling showMemversesForPassage(Async)");
        }


        com.squareup.okhttp.Call call = showMemversesForPassageCall(passageId, page, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns memory verses for a given passage
     *
     * @param passageId ID of passage (required)
     * @param page      Page number requested (optional)
     * @return Memverse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Memverse showMemversesForPassage(Long passageId, Long page) throws ApiException {
        ApiResponse<Memverse> resp = showMemversesForPassageWithHttpInfo(passageId, page);
        return resp.getData();
    }

    /**
     * Returns memory verses for a given passage
     *
     * @param passageId ID of passage (required)
     * @param page      Page number requested (optional)
     * @return ApiResponse&lt;Memverse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Memverse> showMemversesForPassageWithHttpInfo(Long passageId, Long page) throws ApiException {
        com.squareup.okhttp.Call call = showMemversesForPassageValidateBeforeCall(passageId, page, null, null);
        Type localVarReturnType = new TypeToken<Memverse>() {
        }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * (asynchronously)
     * Returns memory verses for a given passage
     *
     * @param passageId ID of passage (required)
     * @param page      Page number requested (optional)
     * @param callback  The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call showMemversesForPassageAsync(Long passageId, Long page, final ApiCallback<Memverse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = showMemversesForPassageValidateBeforeCall(passageId, page, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Memverse>() {
        }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }

    /**
     * Build call for showPassages
     *
     * @param page                    Page number requested (optional)
     * @param progressListener        Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call showPassagesCall(Long page, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/passages";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (page != null)
            localVarQueryParams.addAll(apiClient.parameterToPair("page", page));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                            .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                            .build();
                }
            });
        }

        String[] localVarAuthNames = new String[]{"oauth2"};
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call showPassagesValidateBeforeCall(Long page, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {


        com.squareup.okhttp.Call call = showPassagesCall(page, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns passages (consecutive memory verses) for current user
     *
     * @param page Page number requested (optional)
     * @return Passage
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Passage showPassages(Long page) throws ApiException {
        ApiResponse<Passage> resp = showPassagesWithHttpInfo(page);
        return resp.getData();
    }

    /**
     * Returns passages (consecutive memory verses) for current user
     *
     * @param page Page number requested (optional)
     * @return ApiResponse&lt;Passage&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Passage> showPassagesWithHttpInfo(Long page) throws ApiException {
        com.squareup.okhttp.Call call = showPassagesValidateBeforeCall(page, null, null);
        Type localVarReturnType = new TypeToken<Passage>() {
        }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * (asynchronously)
     * Returns passages (consecutive memory verses) for current user
     *
     * @param page     Page number requested (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call showPassagesAsync(Long page, final ApiCallback<Passage> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = showPassagesValidateBeforeCall(page, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Passage>() {
        }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
