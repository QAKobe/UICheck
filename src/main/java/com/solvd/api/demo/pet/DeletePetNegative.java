package com.solvd.api.demo.pet;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;
@Endpoint(url= "${base_url}${base_path}/${endpoint}", methodType = HttpMethodType.DELETE)
@RequestTemplatePath(path="api/pet/_delete/invalid_id.json")
@ResponseTemplatePath(path="api/pet/_delete/rs.json")
@SuccessfulHttpStatus(status= HttpResponseStatusType.NOT_FOUND_404)
public class DeletePetNegative extends AbstractApiMethodV2 {
        public DeletePetNegative(int invalidId){
            replaceUrlPlaceholder("base_url", Configuration.getRequired("url"));
            replaceUrlPlaceholder("base_path", Configuration.getRequired("path"));
            replaceUrlPlaceholder("endpoint",String.valueOf(invalidId));
        }
    }

