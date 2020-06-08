package ru.ozon;

import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    public ChromeDriver driver;

    @Attachment
    public static byte[] getBytes(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("src/main/resources", resourceName));
    }

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
