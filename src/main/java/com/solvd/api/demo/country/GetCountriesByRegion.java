package com.solvd.api.demo.country;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/v3.1/all", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetCountriesByRegion extends AbstractApiMethodV2 {
    public GetCountriesByRegion(String region) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));

    }
}
