package ru.ozon;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class FirstTest extends WebDriverSettings {

    @Step("Проверка входа")
    public static void checkSignIn(String str1, String str2) throws IOException {
        Assert.assertEquals(str1, str2);
        getBytes("signin.png");
    }

    @Test
    public void firstTest() throws InterruptedException, IOException {
        WebElement signIn = driver.findElement(By.xpath(".//div[@class='ui-b']"));
        signIn.click();
        sleep(40000);
        WebElement profile = driver.findElement(By.xpath(".//span[@class='bb2']"));
        checkSignIn(profile.getText(), "Кабинет");
        sleep(10000);
    }
}
