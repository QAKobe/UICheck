package com.solvd.api.countries;

import com.solvd.api.demo.country.GetCountriesByRegion;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetCountriesByRegionTest extends AbstractTest {
    @Test
    @Parameters("region")
    @MethodOwner(owner="aKalil")
    public void testGetCountriesByRegion(String region) {
        GetCountriesByRegion getCountriesByRegion = new GetCountriesByRegion(region);
        Response response = getCountriesByRegion.callAPI();
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code: 200");

        List<Map<String, Object>> countries = response.jsonPath().getList("$");

        Assert.assertFalse(countries.isEmpty(), "The response should contain a list of countries");

        // Filter out countries that do not belong to the specified region
        List<Map<String, Object>> countriesInEurope = new ArrayList<>();
        for (Map<String, Object> country : countries) {
            String countryRegion = (String) country.get("region");
            if (countryRegion.equals(region)) {
                countriesInEurope.add(country);
            }
        }

        // Verify that each country in the list has the specified region
        for (Map<String, Object> country : countriesInEurope) {
            String countryRegion = (String) country.get("region");
            Assert.assertEquals(countryRegion, region, "The country should belong to the specified region");
        }
        System.out.println(countriesInEurope);
    }
    }
