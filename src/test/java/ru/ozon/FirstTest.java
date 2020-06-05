package ru.ozon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class FirstTest extends WebDriverSettings {

    @Test
    public void firstTest() throws InterruptedException {
        WebElement signIn = driver.findElement(By.xpath(".//div[@class='ui-b']"));
        signIn.click();
        sleep(40000);
        WebElement profile = driver.findElement(By.xpath(".//span[@class='a9r6']"));
        Assert.assertEquals(profile.getText(), "Кабинет");
        sleep(2000);
    }
}
