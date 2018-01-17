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

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * API tests for FinalVersesApi
 */
public class FinalVersesApiTest extends BaseApiTest {

    private final FinalVersesApi api = new FinalVersesApi();

    @Before
    public void setup() throws ApiException {
        configureAuthentication(api);
    }

    /**
     * Returns final verse for each chapter of the Bible
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void showFinalVersesTest() throws ApiException {
        List<FinalVerse> response = api.showFinalVerses();

        assertNotNull(response);
        FinalVerse finalVerse = response.get(0);
        assertNotNull(finalVerse.getBook());
        assertNotNull(finalVerse.getChapter());
        assertNotNull(finalVerse.getLastVerse());
    }

}
