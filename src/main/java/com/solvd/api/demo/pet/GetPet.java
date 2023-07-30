package com.solvd.api.demo.pet;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Endpoint(url = "${base_url}${base_path}/${endpoint}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/pet/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetPet extends AbstractApiMethodV2{
    public GetPet(int petId) throws Exception {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("url"));
        replaceUrlPlaceholder("base_path", Configuration.getRequired("path"));
        replaceUrlPlaceholder("endpoint",String.valueOf(petId));
        String responseTemplate = readResourceFile("src/test/resources/api/pet/_get/rs.json");
        responseTemplate = responseTemplate.replace("\"{{pet_id}}\"", String.valueOf(petId));
    }
    private String readResourceFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

}
