package com.solvd.api.pet;

import com.solvd.api.demo.pet.PostPet;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;
public class PostPetTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "akalil")
    public void testCreatePet() throws Exception {
        PostPet postPet = new PostPet();
        postPet.setProperties("api/pet/pet.properties");
        postPet.callAPIExpectSuccess();
        postPet.validateResponse();
    }
}
