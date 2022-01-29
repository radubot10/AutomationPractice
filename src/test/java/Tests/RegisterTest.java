package Tests;

import Base.SharedData;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterTest extends SharedData {

    @Test
    public void register(){

        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        skipSignInElement.click();

        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        firstNameElement.click();
        String firstNameValue = "Radu";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        lastNameElement.click();
        String lastNameValue = "Botareanu";
        lastNameElement.sendKeys(lastNameValue);

        WebElement addressElement = driver.findElement(By.cssSelector("textarea[rows='3']"));
        addressElement.click();
        String addressValue = "Strada Sub Cetate, nr. 43F, et. 1, ap. 10, Floresti, jud. Cluj, Romania";
        addressElement.sendKeys(addressValue);

        WebElement emailElement = driver.findElement(By.cssSelector("input[type='email']"));
        emailElement.click();
        String emailValue = "radu.botareanu@gmail.com";
        emailElement.sendKeys(emailValue);

        WebElement phoneNumberElement = driver.findElement(By.cssSelector("input[type='tel']"));
        phoneNumberElement.click();
        String phoneNumberValue = "0727561931";
        phoneNumberElement.sendKeys(phoneNumberValue);

        WebElement genderElement = driver.findElement(By.cssSelector("input[value='Male']"));
        genderElement.click();

        WebElement hobbiesElement = driver.findElement(By.cssSelector("input[value='Movies']"));
        hobbiesElement.click();

        WebElement languagesElement = driver.findElement(By.cssSelector("div[id='msdd']"));
        languagesElement.click();
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

        phoneNumberElement.click();

        WebElement countryElement = driver.findElement(By.cssSelector("span[role='combobox']"));
        countryElement.click();
        WebElement countryInputElement = driver.findElement(By.className("select2-search__field"));
        countryInputElement.sendKeys("Australia");
        countryInputElement.sendKeys(Keys.ENTER);

        WebElement yearElement = driver.findElement(By.id("yearbox"));
        Select yearSelect = new Select(yearElement);
        yearSelect.selectByValue("1991");
        yearElement.click();

        WebElement uploadFileElement = driver.findElement(By.cssSelector("div>input[id=\"imagesrc\"]"));
        uploadFileElement.sendKeys("C:\\Users\\40724\\Desktop\\Radu's Workspace\\1.png");

        WebElement passwordElement = driver.findElement(By.cssSelector("input[id='firstpassword']"));
        passwordElement.click();
        String passwordValue = "Tralala10!";
        passwordElement.sendKeys(passwordValue);

        WebElement confirmPasswordElement = driver.findElement(By.cssSelector("input[id='secondpassword']"));
        confirmPasswordElement.click();
        String confirmPasswordValue = "Tralala10!";
        confirmPasswordElement.sendKeys(confirmPasswordValue);



    }
}
