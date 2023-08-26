package org.obs.homeWork;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class RadioButtonDemo extends Base {
    @Test
    public void radioButtonDemo() {
        driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
        List<WebElement> genders = driver.findElements(By.xpath("//input[@name='inlineRadioOptions']/following-sibling::label"));
        String genderToSelect = "Male";
        selectGender(genderToSelect, genders);
    }

    public void selectGender(String gender, List<WebElement> genders) {
        for (int i = 0; i < genders.size(); i++) {
            WebElement gen = genders.get(i);
            String genValue = gen.getText();
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
        selectGroupRadioButton("Male","19 t0 44",patientGender,patientAgeGroup);

    }

    public void selectGroupRadioButton(String gender, String ageGroup, List<WebElement> patientGender, List<WebElement> patientAgeGroup) {
        selectRadioButton(gender, patientGender);
        selectRadioButton(ageGroup, patientAgeGroup);
    }

    public void selectRadioButton(String option, List<WebElement> radioButtons) {
        for (WebElement radioButton : radioButtons) {
            String labelText = radioButton.getText();
            if (labelText.equalsIgnoreCase(option)) {
                radioButton.click();
            }

        }
        WebElement getResultsButton=driver.findElement(By.xpath("//button[@id='button-two']"));
        getResultsButton.click();

    }
}
