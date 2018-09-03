package core.pages;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage{
    private static final By DASHBOARD_HEADER_LOCATOR = By.xpath("//div[@class='header']");

    public DashboardPage() {
        $(DASHBOARD_HEADER_LOCATOR).shouldHave(Condition.text("Dashboard"));
    }
}
