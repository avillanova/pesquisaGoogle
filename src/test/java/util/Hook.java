package util;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hook {
    private static WebDriver driver;

    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=pt-br");
        driver = new ChromeDriver(options);
        driver.get("http://www.google.com.br/");
        driver.manage().window().maximize();
    }

    @After
    public void after(){
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
