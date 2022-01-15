package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    // Declaram variabila WebDriver.

    public WebDriver driver;

    @Test

    public void login(){

        // Setam driver-ul de Chrome.
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");

        // Deschidem o instanta de Chrome.
        driver = new ChromeDriver();

        // Accesam un URL.
        driver.get("http://demo.automationtesting.in/Index.html");

        //Facem driver-ul in modul maximized.
        driver.manage().window().maximize();

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
        driver.quit();

    }
}
