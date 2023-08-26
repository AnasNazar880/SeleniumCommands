package org.obs.homeWork;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
public class SelectInputDemo extends Base {
    @Test
    public void singleInputDemo() {
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement singleInput = driver.findElement(By.xpath("//select[@id='single-input-field']"));
        Select select = new Select(singleInput);
        List<WebElement> countryDropdown = select.getOptions();
        String expectedColourToSelected = "Red";
        selectColours(expectedColourToSelected, countryDropdown, select);
        WebElement selectedColour = select.getFirstSelectedOption();
        String actualColourSelected = selectedColour.getText();
        Assert.assertEquals(actualColourSelected, expectedColourToSelected, "colour is not selected");
    }

    public void selectColours(String colour, List<WebElement> dropDown, Select select) {
        boolean colourFound = false;
        for (int i = 0; i < dropDown.size(); i++) {
            WebElement dropdowns = dropDown.get(i);
            String dropName = dropdowns.getText();
            if (dropName.equals(colour)) {
                select.selectByValue(colour);
                colourFound = true;
            }
        }
        if (!colourFound) {
            throw new RuntimeException("colour is not selected");
        }
    }
    @Test
    public void multipleInputFields() {
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement selectColor = driver.findElement(By.xpath("//select[@id='multi-select-field']"));
        Select select = new Select(selectColor);
        boolean multiSelect = select.isMultiple();
        Assert.assertTrue(multiSelect, "DropDown should support multiple select");
        select.selectByVisibleText("Red");
        select.selectByVisibleText("Yellow");
        select.selectByVisibleText("Green");
        List<WebElement> colours = select.getAllSelectedOptions();
        Assert.assertEquals(colours.size(), 3, "NUmber of selected colour should be three");
        String[] expectedColours = {"Red", "Yellow", "Green"};
        for (int i = 0; i < colours.size(); i++) {
            WebElement colour = colours.get(i);
            String actualColours = colour.getText();
            Assert.assertEquals(actualColours, expectedColours[i], "Selected Colour does not match with actual colour");

        }
    }
}
