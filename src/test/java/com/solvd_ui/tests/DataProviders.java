package com.solvd_ui.tests;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "testData")
    public Object[][] testData() {

        return new Object[][]{{"test@test.com", "123456789"}
                , {"test@gmail.com", "0987654321"},
                  {"qwert][poiu", "    98   "}};


    }
}
