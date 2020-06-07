package ru.ozon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class FourthTest extends  WebDriverSettings{

    @Test
    public void fourthTest() throws InterruptedException {
        WebElement catalog = driver.findElement(By.xpath(".//button[@class='ui-a9']"));
        catalog.click();
        sleep(1000);
        WebElement appliances = driver.findElement(By.xpath(".//span[contains(text(), 'Бытовая техника')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(appliances).build().perform();
        sleep(1000);
        WebElement juicers = driver.findElement(By.xpath(".//span[contains(text(), 'Соковыжималки')]"));
        juicers.click();
        sleep(2000);
        WebElement firstP = driver.findElement(By.xpath(".//p[contains(text(), 'от')]"));
        WebElement firstInput = firstP.findElement(By.xpath("preceding-sibling::input[1]"));
        firstInput.click();
        firstInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE), "3000\n");
        sleep(5000);
        WebElement secondP = driver.findElement(By.xpath(".//p[contains(text(), 'до')]"));
        WebElement secondInput = secondP.findElement(By.xpath("preceding-sibling::input[1]"));
        secondInput.click();
        secondInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE), "4000");
        secondInput.sendKeys(Keys.ENTER);
        sleep(5000);
        WebElement thirdInput = driver.findElements(By.xpath(".//input[@qa-id='range-from']")).get(1);
        thirdInput.click();
        thirdInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE), "1000");
        thirdInput.sendKeys(Keys.ENTER);
        sleep(5000);

        ArrayList<WebElement> listPrices = (ArrayList<WebElement>)
                driver.findElements(By.xpath(".//span[@class='a2b5']"));
        ArrayList<WebElement> listPricesSale = (ArrayList<WebElement>)
                driver.findElements(By.xpath(".//span[@class='a2b5 a2b6']"));
        listPrices.addAll(listPricesSale);
        sleep(1000);
        Boolean flag = true;
        for (int i = 0; i < listPrices.size(); i++) {
            if (listPrices.get(i).getText().charAt(0) != '3' & listPrices.get(i).getText() != "4000") {
                flag = false;
                break;
            }
        }
        Assert.assertEquals(flag.toString(), "true");
        sleep(1000);

        WebElement cheap = driver.findElement(By.xpath(".//input[@class='ui-a1f3']"));
        cheap.click();
        cheap.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        sleep(5000);

        WebElement addButton = driver.findElement(By.cssSelector("[data-widget=\"megaPaginator\"] > div"))
                .findElement(By.cssSelector("div[data-widget=\"searchResultsV2\"]"))
                .findElements(By.cssSelector("div > div[style=\"grid-column-start: span 12;\"]"))
                .get(0)
                .findElements(By.cssSelector("div > div > div[style=\"width: 25%; max-width: 25%; flex: 0 0 25%;\"]"))
                .get(1).findElements(By.cssSelector("div > button"))
                .get(1);
        JavascriptExecutor executor = driver;
        executor.executeScript("arguments[0].click();", addButton);
        sleep(3000);
        WebElement cartButton = driver.findElement(By.xpath(".//a[contains(@href, '/cart')]"));
        cartButton.click();
        sleep(2000);
        WebElement numberButton = driver.findElement(By.xpath(".//input[@class='ui-a1f3']"));
        numberButton.click();
        sleep(1000);
        numberButton.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        sleep(5000);
        WebElement cartButtonChange = driver.findElement(By.xpath(".//span[@class='f-caption--bold a9r4']"));
        Assert.assertEquals(cartButtonChange.getText(), "5");
        sleep(3000);
    }
}
