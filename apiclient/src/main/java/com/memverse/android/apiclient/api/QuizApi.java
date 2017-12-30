package com.memverse.android.apiclient.api;

import com.memverse.android.apiclient.model.Quiz;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface QuizApi {
    /**
     * Returns the upcoming live quiz
     *
     * @return Call&lt;Quiz&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("quizzes/upcoming")
    Call<Quiz> findUpcomingQuiz();


    /**
     * Record a user score for a live quiz question
     *
     * @param usrId       Memverse user ID (required)
     * @param usrName     Memverse user name (required)
     * @param usrLogin    Memverse user login (email address) (required)
     * @param questionId  Quiz question ID (primary key) (required)
     * @param questionNum Quiz question number (required)
     * @param score       The user score (max&#x3D;10) (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("record_score")
    Call<Void> recordUserScore(
            @retrofit2.http.Query("usr_id") String usrId, @retrofit2.http.Query("usr_name") String usrName, @retrofit2.http.Query("usr_login") String usrLogin, @retrofit2.http.Query("question_id") Long questionId, @retrofit2.http.Query("question_num") Long questionNum, @retrofit2.http.Query("score") Long score
    );

}
