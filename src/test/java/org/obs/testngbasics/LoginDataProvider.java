package org.obs.testngbasics;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    @DataProvider(name="userCredentials")
    public Object[][] userCredentials(){
        Object[][] data=new Object[3][2];
        data[0][0]="muhammadanas.n@gmail.com";
        data[0][1]="hyrin@2020";
        data[1][0]="muhammadanas@gmail.com";
        data[1][1]="Hyrin@2023";
        data[2][0]="muhammadana.n@gmail.com";
        data[2][1]="hyrin@2020";
        return data;
    }
}
