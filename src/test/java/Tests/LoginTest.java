package Tests;

import Base.SharedData;
import Pages.IndexPage;
import Pages.LoginPage;
import org.junit.Test;

public class LoginTest extends SharedData {

    public IndexPage indexPage;
    public LoginPage loginPage;

    @Test
    public void login(){

        indexPage = new IndexPage(driver);
        loginPage = new LoginPage(driver);

        indexPage.clickSignIn();
        loginPage.loginInvalidProcess("test@test.com","Parola123","Invalid User Name or PassWord");

    }
}
