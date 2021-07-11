package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.SideBar;

import static com.codeborne.selenide.Condition.text;

public class LoginTests {

    @DataProvider(name = "login-alerts")
    public Object[][] loginProvider() {
        return new Object[][] {
                {"magrones@ninjaplus.com", "abc123", "Usuário e/ou senha inválidos"},
                {"404@ninjaplus.com", "pwd123", "Usuário e/ou senha inválidos"},
                {"", "pwd123", "Opps. Cadê o email?"},
                {"magrones@ninjaplus.com", "", "Opps. Cadê a senha?"}
        };
    }

    protected static LoginPage login;
    protected static SideBar   side;

    @BeforeMethod
    public void start() {
        System.setProperty("webdriver.chrome.driver", "webDrivers\\chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.browser = "http://192.168.33.10:5000";

        login = new LoginPage();
        side = new SideBar();
    }

    @Test
    public void LoginSuccess() {
        login
                .open()
                .with("magrones@ninjaplus.com", "pwd123");

       side
               .loggedUser()
               .shouldHave(text("David"));
    }

    @Test(dataProvider = "login-alerts")
    public void PasswordIncorrect(String email, String password, String expectAlert) {

        login
                .open()
                .with(email, password)
                .alert().shouldHave((text(expectAlert)));
    }

    @AfterMethod
    public void clearUp() {
        login
                .clearSession();
    }

}
