package com.solvd.api.pet;

import com.solvd.api.demo.pet.DeletePet;
import com.solvd.api.demo.pet.TestDataProvider;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;
public class DeletePetTest implements IAbstractTest {
    @Test(dataProvider = "idProvider",dataProviderClass = TestDataProvider.class)
    @MethodOwner(owner="akalil")
    public void testDeleteById(int petId){
        DeletePet deletePetById = new DeletePet(petId);
        deletePetById.setProperties("api/pet/pet.properties");
        deletePetById.callAPIExpectSuccess();
        deletePetById.validateResponse();
    }

}
