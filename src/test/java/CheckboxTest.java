import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class CheckboxTest {

            WebDriver driver;

        @BeforeMethod
        public void setup() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
//        options.addArguments("headless");
//        options.addArguments("incognito");
//        options.addArguments("disable-notification");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        @Test

        public void checkboxes() {
            SoftAssert softAssert = new SoftAssert();
            driver.get("https://the-internet.herokuapp.com/checkboxes");
            boolean box1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]")).isSelected();
            softAssert.assertFalse(box1,"Первый чекбокс должен быть не отмечен");
            driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]")).click();
            boolean box1changed = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]")).isSelected();
            softAssert.assertTrue(box1changed, "Первый чекбокс должен быть отмечен после клика");
            boolean box2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).isSelected();
            softAssert.assertTrue(box2, "Второй чекбокс должен быть отмечен");
            driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).click();
            boolean box2changed = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).isSelected();
            Assert.assertFalse(box2changed,"Второй чекбокс должен быть не отмечен после клика");
            softAssert.assertAll();
        }

            @AfterMethod(alwaysRun = true)
        public void quit() {
            driver.quit();
        }
    }


