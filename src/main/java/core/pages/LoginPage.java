package core.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage{
    private static final By EMAIL_INPUT_FIELD_LOCATOR = By.xpath("//div[@class='login-screen']//input[@type='email']");
    private static final By PASSWORD_INPUT_FIELD_LOCATOR = By.xpath("//div[@class='login-screen']//input[@type='password']");
    private static final By SIGNIN_BUTTON_LOCAROR = By.cssSelector("button.btn.btn-primary.btn-large.btn-block");

    public LoginPage open() {
      Selenide.open("/app/login");
      return this;
    }

    public DashboardPage tryLoginAs(String userEmail, String userPassword) {
      $(EMAIL_INPUT_FIELD_LOCATOR).val(userEmail);
      $(PASSWORD_INPUT_FIELD_LOCATOR).val(userPassword);
      $(SIGNIN_BUTTON_LOCAROR).click();
      return page(DashboardPage.class);
    }
}
