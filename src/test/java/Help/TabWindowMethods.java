package Help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TabWindowMethods {

    public WebDriver driver;

    public TabWindowMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToTab(int index){
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));
        System.out.println("Titlul paginii: "+driver.getTitle());
    }

    public void closeCurrentTab(){
        driver.close();
    }
}
