import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class InputByArrowsTest {

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
        public void inputsValidation () {
            driver.get("https://the-internet.herokuapp.com/inputs");
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).sendKeys("It's a number field");
            String negative = (driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).getText());
            Assert.assertEquals(negative, driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).getText());
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).clear();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).sendKeys("99.999");
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).sendKeys(Keys.ARROW_UP);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            int result = Integer.parseInt(((driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).getAttribute("value"))));
            Assert.assertEquals(result, 100);
        }

            @AfterMethod(alwaysRun = true)
        public void quit() {
            driver.quit();
        }
    }