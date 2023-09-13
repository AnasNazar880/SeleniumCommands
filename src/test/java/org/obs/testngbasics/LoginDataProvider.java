package org.obs.testngbasics;

import org.obs.utility.ExcelUtility;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    @DataProvider(name = "userCredentials")
    public Object[][] userCredentials() {
        Object[][] data = new Object[3][2];
        data[0][0] = "muhammadanas.n@gmail.com";
        data[0][1] = "hyrin@2020";
        data[1][0] = "muhammadanas@gmail.com";
        data[1][1] = "Hyrin@2023";
        data[2][0] = "muhammadana.n@gmail.com";
        data[2][1] = "hyrin@2020";
        return data;
    }

    @DataProvider(name = "OrangeLoginCredentials")
    public Object[][] OrangeLoginCredentials() {
        Object[][] loginData = new Object[3][2];
        loginData[0][0] = "admin12";
        loginData[0][1] = "admin123"; //right
        loginData[1][0] = "Admin";
        loginData[1][1] = "admin1234";
        loginData[2][0] = "administer";
        loginData[2][1] = "admins456";
        return loginData;
    }

    @DataProvider(name = "userCredentialsFromExcel")
    public Object[][] userCredentialsFromExcel() {
        ExcelUtility excel = new ExcelUtility();
        Object[][] data = excel.dataProviderRead("verifyInvalidLogin");
        return data;
    }
}


