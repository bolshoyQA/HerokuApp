import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
            driver.get("https://the-internet.herokuapp.com/checkboxes");
            boolean box1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]")).isSelected();
            Assert.assertFalse(box1);
            driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]")).click();
            boolean box1changed = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]")).isSelected();
            Assert.assertTrue(box1changed);
            boolean box2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).isSelected();
            Assert.assertTrue(box2);
            driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).click();
            boolean box2changed = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).isSelected();
            Assert.assertFalse(box2changed);
        }

            @AfterMethod(alwaysRun = true)
        public void quit() {
            driver.quit();


        }
    }


