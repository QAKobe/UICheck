package com.solvd.api.demo.country;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;
import org.testng.annotations.DataProvider;

@Endpoint(url = "${base_url}/${rest_end}", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class InvalidCountryName extends AbstractApiMethodV2 {
    public InvalidCountryName() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("rest_end",Configuration.getRequired("restEnd"));
    }
    @DataProvider(name = "invalidCountryName")
    public static Object[][] provideInvalidCountryName() {
        return new Object[][]{
                {"Atlantis"},
                {"Neverland"},
                // Add more invalid country names as needed
        };
    }
}
