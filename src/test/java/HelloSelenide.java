import com.codeborne.selenide.SelenideDriver;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.*;
import static org.testng.Assert.assertEquals;


public class HelloSelenide {
    private SelenideDriver customFirefox;
    @Test
    public void OnAir() {
        isChrome();
        open("http://192.168.33.10:5000/login");
        assertEquals(title(), "Ninja+");
    }
}
