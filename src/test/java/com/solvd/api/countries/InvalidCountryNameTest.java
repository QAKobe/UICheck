package com.solvd.api.countries;
import com.solvd.api.demo.country.InvalidCountryName;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class InvalidCountryNameTest extends AbstractTest {

    @Test()
    @Parameters({"invalidCountryName"})
    @MethodOwner(owner = "aKalil")
    public void testInvalidCountryName(String invalidCountryName) {
        InvalidCountryName invalidCountry = new InvalidCountryName();
        Response response = invalidCountry.callAPI();
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code: 200");

        List<Map<String, Object>> countryList = response.jsonPath().getList("$");
        Assert.assertFalse(countryList.isEmpty(), "The response should contain a list of countries");

        boolean hasInvalidCountry = false;
        for (Map<String, Object> country : countryList) {
            Map<String, Object> nameMap = (Map<String, Object>) country.get("name");
            String commonName = (String) nameMap.get("common");
            if (commonName.equalsIgnoreCase(invalidCountryName)) {
                hasInvalidCountry = true;
                break;
            }
        }

        Assert.assertFalse(hasInvalidCountry, "The country is invalid: " + invalidCountryName);
    }
}
