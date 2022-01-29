package Tests;

import Base.SharedData;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest extends SharedData {

    // Declaram variabila WebDriver.

    @Test
    public void login(){

        WebElement signInElement = driver.findElement(By.id("btn1"));
        signInElement.click();

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='E mail']"));
        String emailValue = "radu.botareanu@gmail.com";
        emailElement.sendKeys(emailValue);

        WebElement passwordElement = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        String passwordValue = "AlexDorhaEsteLenes6";
        passwordElement.sendKeys(passwordValue);

        WebElement enterElement = driver.findElement(By.id("enterbtn"));
        enterElement.click();

        WebElement loginError = driver.findElement(By.cssSelector("label[id='errormsg']"));
        String expectedErrorMesssage = "Invalid User Name or PassWord";
        String actualErrorMessage = loginError.getText();
        Assert.assertEquals("Textul cautat nu e corect.",expectedErrorMesssage, actualErrorMessage);

        // Quit = inchidem instanta cu toate tab-urile deschise.
        // Close = inchidem tab-ul curent.


    }
}
