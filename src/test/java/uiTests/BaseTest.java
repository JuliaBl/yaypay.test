package uiTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import core.utils.AllureSelenide;
import core.utils.prop.Config;
import core.utils.prop.PropertiesLoader;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static core.logger.Logger.LOGGER;

public abstract class BaseTest {

    private static final Config config = PropertiesLoader.getConfig();

    @BeforeClass
    public void setUpDriver() {
        if (Boolean.parseBoolean(config.isRemote())) {
            Configuration.remote = config.getRemoteUrl();
        } else {
            ChromeDriverManager.getInstance().setup();
        }
        Configuration.browser = config.getBrowser();
        LOGGER.info("Browser  is " + config.getBrowser());
        Configuration.baseUrl = config.getAppUrl();
        LOGGER.info("Driver has been set");
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        Selenide.close();
        LOGGER.info("Browser has been closed");
    }
}