package Tests;

import Base.SharedData;
import Pages.IndexPage;
import Pages.RegisterPage;
import Pages.WindowPage;
import org.junit.Test;

public class WindowTest extends SharedData {

    public IndexPage indexPage;
    public RegisterPage registerPage;
    public WindowPage windowPage;

    @Test
    public void windowTest(){

        indexPage = new IndexPage(driver);
        registerPage = new RegisterPage(driver);
        windowPage = new WindowPage(driver);

        indexPage.clickSkipSignIn();

        registerPage.goToWindowPage();

        windowPage.newTabProcess();
        windowPage.newWindowProcess();
        windowPage.multipleTabsProcess();

    }

}
