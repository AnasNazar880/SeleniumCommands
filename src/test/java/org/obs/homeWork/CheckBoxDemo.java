package org.obs.homeWork;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class CheckBoxDemo extends Base {
    @Test
    public void singleCheckBox() {
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        WebElement singleCheckBox = driver.findElement(By.xpath("//div//div[@class='card-body']//div[@class='form-check']//input[@class='form-check-input']"));
        Assert.assertFalse(singleCheckBox.isSelected(), "checkbox is  selected");
        singleCheckBox.click();
        Assert.assertTrue(singleCheckBox.isSelected(), "checkbox is not selected");
    }

    @Test
    public void multipleCheckBoxDemo() {
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        List<WebElement> multipleCheckBox = driver.findElements(By.xpath("//input[@class='check-box-list']/ following-sibling::label"));
        //  selectMultipleCheck("Check Box One", multipleCheckBox);
        selectMultipleCheck("Check Box One", "Check Box Two", multipleCheckBox);
        selectMultipleCheck("Check Box One", "Check Box Two", "Check Box Three", multipleCheckBox);
        selectMultipleCheck("Check Box One", "Check Box Two", "Check Box Three", "Check Box Four", multipleCheckBox);
    }

    public void selectMultipleCheck(String checkBoxOne, List<WebElement> multipleCheckBox) {
        String[] expectedOptions = {"Check Box One"};
        int numberOfOptions = Math.min(expectedOptions.length, multipleCheckBox.size());
        for (int i = 0; i < numberOfOptions; i++) {
            WebElement checkBoxes = multipleCheckBox.get(i);
            String actualOptions = checkBoxes.getText();
            Assert.assertEquals(actualOptions, expectedOptions[i], "the options are not matching");
            if (actualOptions.equals(checkBoxOne)) {
                checkBoxes.click();
                break;
            }
        }
    }

    public void selectMultipleCheck(String checkBoxOne, String checkBoxTwo, List<WebElement> multipleCheckBox) {
        String[] expectedOptions = {"Check Box One", "Check Box Two"};
        int numberOfOptions = Math.min(expectedOptions.length, multipleCheckBox.size());
        for (int i = 0; i < numberOfOptions; i++) {
            WebElement checkbox = multipleCheckBox.get(i);
            String actualOptions = checkbox.getText();
            Assert.assertEquals(actualOptions, expectedOptions[i], "the options are not matching");
            if (actualOptions.equals(checkBoxOne) || actualOptions.equals(checkBoxTwo)) {
                checkbox.click();
            }
        }
    }

    public void selectMultipleCheck(String checkBoxOne, String checkBoxTwo, String checkboxThree, List<WebElement> multipleCheckBox) {
        String[] expectedOptions = {"Check Box One", "Check Box Two", "Check Box Three"};
        int numberOfOptions = Math.min(expectedOptions.length, multipleCheckBox.size());
        for (int i = 0; i < numberOfOptions; i++) {
            WebElement checkbox = multipleCheckBox.get(i);
            String actualOptions = checkbox.getText();
            Assert.assertEquals(actualOptions, expectedOptions[i], "options are not matching");
            if (actualOptions.equals(checkBoxOne) || actualOptions.equals(checkBoxTwo) || actualOptions.equals(checkboxThree)) {
                checkbox.click();
            }
        }
    }

    public void selectMultipleCheck(String checkBoxOne, String checkBoxTwo, String checkboxThree, String checkBoxFour, List<WebElement> multipleCheckBox) {
        String[] expectedOptions = {"Check Box One", "Check Box Two", "Check Box Three", "Check Box Four"};
        int numberOfOptions = Math.min(expectedOptions.length, multipleCheckBox.size());
        for (int i = 0; i < multipleCheckBox.size(); i++) {
            WebElement checkBox = multipleCheckBox.get(i);
            String actualOptions = checkBox.getText();
            Assert.assertEquals(actualOptions, expectedOptions, "the options are not matching");
            if (actualOptions.equals(checkBoxOne) || actualOptions.equals(checkBoxTwo) || actualOptions.equals(checkboxThree) || actualOptions.equals(checkBoxFour)) {
                checkBox.click();
            }
        }
    }
}
