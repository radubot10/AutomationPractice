package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    public WebDriver driver;

    @Test

    public void register(){

        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Index.html");
        driver.manage().window().maximize();

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
