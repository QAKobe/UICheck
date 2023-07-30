package com.solvd.api.pet;

import com.solvd.api.demo.pet.DeletePet;
import com.solvd.api.demo.pet.TestDataProvider;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;

public class DeletePetNegativeTest implements IAbstractTest {

    @Test(dataProvider = "invalidId",dataProviderClass = TestDataProvider.class)
    @MethodOwner(owner="akalil")
    public void testDeleteByInvalidId(int invalidId){
        DeletePet deletePetById = new DeletePet(invalidId);
        deletePetById.setProperties("api/pet/pet.properties");
        deletePetById.callAPI();
        deletePetById.validateResponse();
    }
}
