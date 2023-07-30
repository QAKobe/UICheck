package com.solvd.api.demo.pet;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.*;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}${base_path}", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/pet/_post/rq.json")
@ResponseTemplatePath(path="api/pet/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostPet extends AbstractApiMethodV2 {

    public PostPet(){
        replaceUrlPlaceholder("base_url", Configuration.getRequired("pet_url"));
        replaceUrlPlaceholder("base_path",Configuration.getRequired("pet_path"));
    }
}
