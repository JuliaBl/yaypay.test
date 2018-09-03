package core.pages.component;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static core.logger.Logger.LOGGER;

public class LeftMenu {
    private static final By LEFT_MENU_LOCATOR = By.xpath("//div[@class='left-menu']");

    public static <T> T openMenuItem (LeftMenuOption leftMenuOption, Class<T> tClass){
        $(LEFT_MENU_LOCATOR).find(By.xpath("//li[@class='left-menu-item']//p[contains(text(), '"+leftMenuOption.optionText()+"')]")).click();
        LOGGER.info("Open menu option " + leftMenuOption.optionText());
        return page(tClass);
    }
}
