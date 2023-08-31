package org.obs.homeWork;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
public class RadioButtonDemo extends Base {
    @Test
    public void verifyRadioButtonDemo() {
        driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
        List<WebElement> genders = driver.findElements(By.xpath("//input[@name='inlineRadioOptions']/following-sibling::label"));
        String genderToSelect = "Male";
        selectGender(genderToSelect, genders);
    }

    public void selectGender(String gender, List<WebElement> genders) {
        String genderToSelect = "Male";
        for (int i = 0; i < genders.size(); i++) {
            WebElement gen = genders.get(i);
            String genValue = gen.getText();
            Assert.assertEquals(genValue,genderToSelect,"the gender is not correctly selected");
            if (genValue.equals(gender)) {
                gen.click();
            }
        }
        WebElement showSelectedValueButton = driver.findElement(By.xpath("//button[@id='button-one']"));
        showSelectedValueButton.click();
    }

    @Test
    public void validateGroupRadioButton() {
        driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
        List<WebElement> patientGender = driver.findElements(By.xpath("//input[@name='student-gender']//following-sibling::label"));
        List<WebElement> patientAgeGroup = driver.findElements(By.xpath("//input[@name='student-age']//following-sibling::label"));
        selectGroupRadioButton("Male", "19 t0 44", patientGender, patientAgeGroup);
       // WebElement selectGen = driver.findElement(By.xpath("//input[@id='inlineRadio11']//following-sibling::label"));
       // String actualGender = selectGen.getText();
        //Assert.assertTrue(actualGender.contains("male"), "selected gender should be male");
       // WebElement selectAge = driver.findElement(By.xpath("//input[@id='inlineRadio23']//following-sibling::label"));
        //String actualAgeSelected = selectAge.getText();
        //Assert.assertTrue(actualAgeSelected.contains("19 t0 44"), "selected age should be 19-44");
        WebElement getResultsButton=driver.findElement(By.xpath("//button[@id='button-two']"));
        getResultsButton.click();
        WebElement printedText=driver.findElement(By.xpath("//div[@id='message-two']"));
        String actualMessage=printedText.getText();
        String expectedMessage="Gender : Male<br>Age group: 19 to 44";
        expectedMessage = expectedMessage.replace("<br>", "\n");
        Assert.assertEquals(actualMessage,expectedMessage,"group radio button failed");
    }

    public void selectGroupRadioButton(String gender, String ageGroup, List<WebElement> patientGender, List<WebElement> patientAgeGroup) {
        selectRadioButton(gender, patientGender);
        selectRadioButton(ageGroup, patientAgeGroup);
    }

    public void selectRadioButton(String option, List<WebElement> radioButtons) {
        for (WebElement radioButton : radioButtons) {
            String actualOptions = radioButton.getText();
            if (actualOptions.equalsIgnoreCase(option)) {
                radioButton.click();
            }
        }
        WebElement getResultsButton = driver.findElement(By.xpath("//button[@id='button-two']"));
        getResultsButton.click();
    }
}


