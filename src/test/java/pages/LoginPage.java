package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import tests.LoginTests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class LoginPage {

    public LoginPage open() {
        Selenide.open("/login");
        return this;
    }

    public LoginPage with(String email, String pass) {
        $("#emailId").setValue(email);
        $("#passId").setValue(pass);
        $("#login").click();
        return this;
    }

    public SelenideElement alert() {
        return  $(".user .info span");
    }

    public void clearSession() {
        executeJavaScript("localStorage.clear();");
    }

}
