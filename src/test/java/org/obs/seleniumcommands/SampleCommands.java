package org.obs.seleniumcommands;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleCommands {
    @Test
    public void verifyStringResult(){
        String expectedResult="Hello";
        String actualResult="Hello01";
        Assert.assertEquals(actualResult,expectedResult,"result not matched");

    }
@Test
    public void verifyIntegerResult(){
        int expValue=1;
        int actValue=1;
        Assert.assertEquals(actValue,expValue,"Result not matched");
    }
@Test
    public void verifyBooleanTrue(){
boolean actValue=true;
Assert.assertTrue(actValue,"result not matched");
    }
@Test
    public void verifyBooleanFalse(){
        Assert.assertFalse(false,"result not matched");
}
}
