package Tests;

import Base.SharedData;
import Pages.IndexPage;
import Pages.RegisterPage;
import org.junit.Test;

public class RegisterTest extends SharedData {

    public IndexPage indexPage;
    public RegisterPage registerPage;

    @Test
    public void register(){

        indexPage = new IndexPage(driver);
        registerPage = new RegisterPage(driver);

        indexPage.clickSkipSignIn();

        registerPage.registerValidProcess("Radu","Botareanu",
                "Strada Sub Cetate, nr. 43F, et. 1, ap. 10, Floresti, jud. Cluj, Romania", "radu.botareanu@gmail.com",
                "0727561931", "English", "Java", "Australia", "1991",
                "C:\\Users\\40724\\Desktop\\Radu's Workspace\\1.png", "Tralala10", "Tralala10");
    }
}
