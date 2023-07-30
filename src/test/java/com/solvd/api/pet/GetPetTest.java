package com.solvd.api.pet;

import com.solvd.api.demo.pet.GetPet;
import com.solvd.api.demo.pet.TestDataProvider;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;
import static org.testng.Assert.assertEquals;
public class GetPetTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Test(dataProvider = "idProvider",dataProviderClass = TestDataProvider.class)
    @MethodOwner(owner="akalil")
    public void testGetPetById(int petId) throws Exception{
        GetPet getPet=new GetPet(petId);
        Response response=getPet.callAPIExpectSuccess();
        int actualId = response.jsonPath().getInt("id");
        assertEquals(actualId, petId, "Pet ID mismatch in the response!");
//        getPet.validateResponse(JSONCompareMode.STRICT, ARRAY_CONTAINS.getKey());
//        getPet.validateResponseAgainstSchema("api/pet/_get/rs.schema");
    }

}
