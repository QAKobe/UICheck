package com.solvd.api.pet;

import com.solvd.api.demo.pet.FindPetByStatus;
import com.solvd.api.demo.pet.TestDataProvider;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;

public class FindPetByStatusTest implements IAbstractTest {

    @Test(dataProvider = "statusProvider",dataProviderClass = TestDataProvider.class)
    @MethodOwner(owner="akalil")
    public void testFindPetByStatus(String petStatus) throws Exception{
        FindPetByStatus findPetByStatus=new FindPetByStatus();
        Response response=findPetByStatus.callAPIExpectSuccess();
        String status = response.jsonPath().getString("status");
        assertNotNull(status, "Status field is not present in the response");
    }
}
