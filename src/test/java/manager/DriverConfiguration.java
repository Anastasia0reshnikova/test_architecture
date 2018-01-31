package manager;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

import static com.codeborne.selenide.Selenide.open;
import static manager.ApplicationManager.getProperties;

/**
 * Created by a.oreshnikova on 30.01.2018.
 */

public class DriverConfiguration {

    private ApplicationManager app;

    DriverConfiguration(ApplicationManager app) {
        this.app = app;
        setAllDriverPath();
        setDriver();
        setDriverProperties();
    }

    public WebDriver getDriver() {
        return WebDriverRunner.getWebDriver();
    }

    public void stopDriver() {
        WebDriverRunner.closeWebDriver();
    }

    private String getBrowser() {
        return getProperties("web.browser");
    }

    private void setAllDriverPath(){
        String osName = System.getProperty("os.name").toLowerCase();
        String browser = getBrowser();
        if (osName.equals("windows")) {
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
            }
            if (browser.equals("marionette")) {
                System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\geckodriver.exe");
            }
        }
        if (osName.equals("mac")){
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
            }
            if (browser.equals("marionette")) {
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
            }
        }
        if (osName.equals("linux")){
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver_lin");
            }
        }
    }

    private void setDriver() {
        switch (getBrowser()) {
            case BrowserType.FIREFOX: {
                Configuration.browser = "marionette";
                //setWebsoketsForFirefox();
                break;
            }
            case BrowserType.CHROME:
                Configuration.browser = "chrome";
                //setWebsoketsForChrome();
                break;
            default:
                throw new ExceptionInInitializerError("Браузер " + getBrowser() + "в текущей конфигурации отсутствует");
        }
    }

    private void setDriverProperties() {
        Configuration.fastSetValue = true;
        Configuration.reopenBrowserOnFail = false;
        Configuration.savePageSource = false;
        Configuration.screenshots = true;
        Configuration.startMaximized = true;
        //Configuration.browserSize = "1280x1024";
    }

    @Step("Открывается Главная страница Кабинета")
    public void goToUrl() {
        open(getProperties("web.url"));
    }
}
