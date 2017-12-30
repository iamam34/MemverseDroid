package com.memverse.android.apiclient.api;

import com.memverse.android.apiclient.model.ProgressReport;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ProgressReportsApi {
    /**
     * Returns progress data for user
     *
     * @return Call&lt;ProgressReport&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("progress_reports")
    Call<ProgressReport> showUserProgress();


}
