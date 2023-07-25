package com.solvd.api.countries;

import com.solvd.api.demo.country.FilterCountriesByLanguage;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FilterCountriesByLanguageTest extends AbstractTest {

    @Test()
    @Parameters({"languages"})
    @MethodOwner(owner = "aKalil")
    public void testFilterCountriesByLanguage(String languages) {

        FilterCountriesByLanguage filterCountriesByLanguage = new FilterCountriesByLanguage();
        Response response = filterCountriesByLanguage.callAPI();
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code: 200");

        List<Map<String, Object>> countryList = response.jsonPath().getList("$");

        Assert.assertFalse(countryList.isEmpty(), "The response should contain a list of countries");

        List<Map<String, Object>> countriesSpeakingEng = new ArrayList<>();

        for (Map<String, Object> country : countryList) {
            Map<String, Object> lang = (Map<String, Object>) country.get("languages");
            if (lang != null && lang.containsValue(languages)) {
                countriesSpeakingEng.add(country);
            }
        }

        // Verify that each country in the list has the specified language
        for (Map<String, Object> country : countriesSpeakingEng) {
            Map<String, Object> languagesMap = (Map<String, Object>) country.get("languages");
            boolean containsLanguage=languagesContainsLanguage(languagesMap,languages);
            Assert.assertTrue(containsLanguage,"The country should belong to the specified language");
        }
        System.out.println(countriesSpeakingEng);
    }
    // Helper method to check if the specified language exists in the nested languages map
    private boolean languagesContainsLanguage(Map<String, Object> languages, String language) {
        for (Object value : languages.values()) {
            if (value instanceof String && value.equals(language)) {
                return true;
            }
        }
        return false;
    }
}