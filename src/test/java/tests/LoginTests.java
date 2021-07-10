import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.isChrome;

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

    @Test
    public void LoginSucesso() {
       System.setProperty("webdriver.chrome.driver", "webDrivers\\chromedriver.exe");
       isChrome();
       open("http://192.168.33.10:5000");

       $("#emailId").setValue("magrones@ninjaplus.com");
       $("#passId").setValue("pwd123");
       $("#login").click();

       $(".user .info span").shouldHave(text("David"));
    }

    @Test(dataProvider = "login-alerts")
    public void PasswordIncorreto(String email, String password, String expectAlert) {
        System.setProperty("webdriver.chrome.driver", "webDrivers\\chromedriver.exe");
        isChrome();

        executeJavaScript("localStorage.clear();");
        open("http://192.168.33.10:5000");

        $("#emailId").setValue(email);
        $("#passId").setValue(password);
        $("#login").click();

        $(".alert span").shouldHave((text(expectAlert)));
    }

}
