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
import com.memverse.apiclient.model.User;

import org.junit.Ignore;
import org.junit.Test;

/**
 * API tests for CurrentUserApi
 */
@Ignore
public class CurrentUserApiTest {

    private final CurrentUserApi api = new CurrentUserApi();


    /**
     * Returns credential for current user
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void findCurrentUserTest() throws ApiException {
        User response = api.findCurrentUser();

        // TODO: test validations
    }

}