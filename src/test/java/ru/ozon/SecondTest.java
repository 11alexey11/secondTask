package ru.ozon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class SecondTest extends WebDriverSettings {

    @Test
    public void secondTest() throws InterruptedException {
        WebElement townClick = driver.findElement(By.xpath(".//button[@class='c5j0']"));
        townClick.click();
        WebElement townInput = driver.findElement(By.xpath(".//input[@class='ui-av9 ui-av6']"));
        townInput.sendKeys("Саратов");
        sleep(2000);
        WebElement chooseElement = driver.findElement(By.xpath("//a[@class='a7']"));
        chooseElement.click();
        sleep(1000);
        String currentTown = driver.findElement(By.xpath(".//span[@class='c5j3']")).getText();

        sleep(2000);
        WebElement townClickTwice = driver.findElement(By.xpath(".//button[@class='c5j0']"));
        townClickTwice.click();
        WebElement townInputTwice = driver.findElement(By.xpath(".//input[@class='ui-av9 ui-av6']"));
        townInputTwice.sendKeys("Вольск");
        sleep(2000);
        WebElement chooseElementTwice = driver.findElement(By.xpath("//a[@class='a7']"));
        chooseElementTwice.click();
        sleep(1000);
        String changeTown = driver.findElement(By.xpath(".//span[@class='c5j3']")).getText();
        Assert.assertFalse(currentTown, changeTown.equals(currentTown));

        sleep(2000);
        WebElement signIn = driver.findElement(By.xpath(".//div[@class='ui-b']"));
        signIn.click();
        sleep(30000);

        WebElement pointOfIssue = driver.findElement(By.xpath(".//a[contains(@href, '//www.ozon.ru/info/map/')]"));
        pointOfIssue.click();
        sleep(5000);
        String cityName = driver.findElement(By.xpath(".//span[@class='city-name-inner']")).getText();
        Assert.assertEquals(changeTown, cityName);
        sleep(2000);
    }
}
