package com.solvd.api.demo.pet;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url= "${base_url}/v2/swagger.json", methodType = HttpMethodType.DELETE)
@RequestTemplatePath(path="api/pet/_delete/rq.json")
@SuccessfulHttpStatus(status= HttpResponseStatusType.OK_200)
public class DeletePet extends AbstractApiMethodV2 {
    public DeletePet(){
        replaceUrlPlaceholder("base_url", Configuration.getRequired("pet_url"));
    }

}
