package com.solvd.api.demo.pet;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}${base_path}${endpoint}", methodType = HttpMethodType.GET)
//@ResponseTemplatePath(path = "api/pet/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class FindPetByStatus extends AbstractApiMethodV2 {
    public FindPetByStatus() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("url"));
        replaceUrlPlaceholder("base_path", Configuration.getRequired("path"));
        replaceUrlPlaceholder("endpoint",Configuration.getRequired("status"));
    }
}
