package com.solvd.api.countries;

import com.solvd.api.demo.country.ValidateCapital;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class ValidateCapitalTest {

    @Test
    @MethodOwner(owner="aKalil")
    public void validateCapital() {
        String expectedCapital = "Bishkek";

        ValidateCapital validateCapital=new ValidateCapital();
        Response response=validateCapital.callAPIExpectSuccess();

        List<Map<String, Object>> parsedCountries = response.as(new TypeRef<>() {
        });
        String actualCapital=parsedCountries.stream()
                .filter(country -> country.get("name").toString().contains("Kyrgyzstan"))
                .map(country ->((List<String>)country.get("capital")).get(0))
                .findFirst()
                .orElse("");

        System.out.println("actualCapital = " + actualCapital);
        System.out.println("expectedCapital = " + expectedCapital);
        Assert.assertEquals(expectedCapital, actualCapital);


    }
}
