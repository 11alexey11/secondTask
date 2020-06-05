package ru.ozon;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    public ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/HP/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.ozon.ru/");
        driver.manage().window().maximize();
    }

    @After
    public void close() {
        driver.quit();
    }
}
