package com.solvd.api.countries;

import com.solvd.api.demo.country.GetAllCountries;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class GetAllCountriesTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    @MethodOwner(owner = "aKalil")
    public void testGetAllCountries() {
        GetAllCountries getAllCountries = new GetAllCountries();
        Response response = getAllCountries.callAPIExpectSuccess();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Expected status code: 200");

        String contentType = response.getHeader("Content-Type");
        Assert.assertEquals(contentType, "application/json", "Expected content type: application/json");



    }


}
