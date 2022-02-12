package Tests;

import Base.SharedData;
import Help.ElementMethods;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterTest extends SharedData {

    public ElementMethods elementMethods;

    @Test
    public void register(){

        elementMethods = new ElementMethods(driver);

        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        elementMethods.clickElement(skipSignInElement);

        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        elementMethods.clickElement(firstNameElement);
        String firstNameValue = "Radu";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        elementMethods.clickElement(lastNameElement);
        String lastNameValue = "Botareanu";
        lastNameElement.sendKeys(lastNameValue);

        WebElement addressElement = driver.findElement(By.cssSelector("textarea[rows='3']"));
        elementMethods.clickElement(addressElement);
        String addressValue = "Strada Sub Cetate, nr. 43F, et. 1, ap. 10, Floresti, jud. Cluj, Romania";
        addressElement.sendKeys(addressValue);

        WebElement emailElement = driver.findElement(By.cssSelector("input[type='email']"));
        elementMethods.clickElement(emailElement);
        String emailValue = "radu.botareanu@gmail.com";
        emailElement.sendKeys(emailValue);

        WebElement phoneNumberElement = driver.findElement(By.cssSelector("input[type='tel']"));
        elementMethods.clickElement(phoneNumberElement);
        String phoneNumberValue = "0727561931";
        phoneNumberElement.sendKeys(phoneNumberValue);

        WebElement genderElement = driver.findElement(By.cssSelector("input[value='Male']"));
        elementMethods.clickElement(genderElement);

        WebElement hobbiesElement = driver.findElement(By.cssSelector("input[value='Movies']"));
        elementMethods.clickElement(hobbiesElement);

        WebElement languagesElement = driver.findElement(By.cssSelector("div[id='msdd']"));
        elementMethods.clickElement(languagesElement);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        List<WebElement> LanguageOptions = driver.findElements(By.cssSelector(".ui-autocomplete.ui-front>li>a"));
        for (int index = 0;index < LanguageOptions.size();index++){
            if (LanguageOptions.get(index).getText().equals("English")
                    || LanguageOptions.get(index).getText().equals("Arabic")
                    || LanguageOptions.get(index).getText().equals("Estonian")){
                LanguageOptions.get(index).click();
            }
        }

        WebElement skills = driver.findElement(By.id("Skills"));
        elementMethods.selectElementByText(skills, "Java");

        WebElement countryElement = driver.findElement(By.cssSelector("span[role='combobox']"));
        elementMethods.clickElement(countryElement);
        WebElement countryInputElement = driver.findElement(By.className("select2-search__field"));
        countryInputElement.sendKeys("Australia");
        countryInputElement.sendKeys(Keys.ENTER);

        WebElement yearElement = driver.findElement(By.id("yearbox"));
        elementMethods.selectElementByValue(yearElement, "1991");


        WebElement uploadFileElement = driver.findElement(By.cssSelector("div>input[id=\"imagesrc\"]"));
        uploadFileElement.sendKeys("C:\\Users\\40724\\Desktop\\Radu's Workspace\\1.png");

        WebElement passwordElement = driver.findElement(By.cssSelector("input[id='firstpassword']"));
        elementMethods.clickElement(passwordElement);
        String passwordValue = "Tralala10!";
        passwordElement.sendKeys(passwordValue);

        WebElement confirmPasswordElement = driver.findElement(By.cssSelector("input[id='secondpassword']"));
        elementMethods.clickElement(confirmPasswordElement);
        String confirmPasswordValue = "Tralala10!";
        confirmPasswordElement.sendKeys(confirmPasswordValue);

    }
}
