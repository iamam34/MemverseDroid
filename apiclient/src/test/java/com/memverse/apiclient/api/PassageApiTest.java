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
import com.memverse.apiclient.model.Memverse;
import com.memverse.apiclient.model.Passage;

import org.junit.Ignore;
import org.junit.Test;

/**
 * API tests for PassageApi
 */
@Ignore
public class PassageApiTest {

    private final PassageApi api = new PassageApi();


    /**
     * Delete a passage
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deletePassageByIdTest() throws ApiException {
        Long id = null;
        Passage response = api.deletePassageById(id);

        // TODO: test validations
    }

    /**
     * Returns a single passage by primary key (ID)
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void findPassageByIdTest() throws ApiException {
        Long id = null;
        Passage response = api.findPassageById(id);

        // TODO: test validations
    }

    /**
     * Returns memory verses for a given passage
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void showMemversesForPassageTest() throws ApiException {
        Long passageId = null;
        Long page = null;
        Memverse response = api.showMemversesForPassage(passageId, page);

        // TODO: test validations
    }

    /**
     * Returns passages (consecutive memory verses) for current user
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void showPassagesTest() throws ApiException {
        Long page = null;
        Passage response = api.showPassages(page);

        // TODO: test validations
    }

}
