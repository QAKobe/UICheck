package com.solvd.api.demo.pet;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/v2/swagger.json", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/pet/_post/rq.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetPet extends AbstractApiMethodV2 {
    public GetPet() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("pet_url"));
    }
}
