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

import com.memverse.apiclient.ApiException;
import com.memverse.apiclient.model.FinalVerse;

import org.junit.Ignore;
import org.junit.Test;

/**
 * API tests for FinalVersesApi
 */
@Ignore
public class FinalVersesApiTest {

    private final FinalVersesApi api = new FinalVersesApi();


    /**
     * Returns final verse for each chapter of the Bible
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void showFinalVersesTest() throws ApiException {
        FinalVerse response = api.showFinalVerses();

        // TODO: test validations
    }

}
