package com.solvd.api.demo.pet;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name="statusProvider")
    public static Object[][] statusProvider() {
        return new Object[][] {
                { "available" },
//                { "pending" },
//                { "sold" }
        };
    }
    @DataProvider(name="idProvider")
    public static Object[][] idProvider() {
        return new Object[][] {
                { 1233 },
//                { 1122 },
        };
    }

    @DataProvider(name="invalidId")
    public static Object[][] invalidId() {
        return new Object[][] {
                { 1236 },
//                { 1126 },
        };
    }

    @DataProvider(name = "petData")
    public static Object[][] petDataProvider() {
        return new Object[][] {
                { 1233,"Fluffy", "available" },
//                { 1122,"Buddy", "pending" },
//                { 1355,"Max", "sold" }
        };
    }
}
