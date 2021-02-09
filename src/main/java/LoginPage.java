import com.common.blazedemo.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginPage extends Utilities{
    Properties prop;

    {
        try {
            prop = readPropertiesFile("C:\\Users\\Gupta\\IdeaProjects\\MayankGupta_UI_Test_Blazedemo\\src\\main\\resources\\locators.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void LoadPage() throws InterruptedException {

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gupta\\IdeaProjects\\MayankGupta_UI_Test_Blazedemo\\src\\main\\resources\\chromedriver1.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));

        System.out.println("User is on Page" + driver.getTitle());

        Select frmCountry = new Select(driver.findElement(By.name("fromPort")));
        frmCountry.selectByVisibleText("Philadelphia");

        Select toCountry = new Select(driver.findElement(By.name("toPort")));
        toCountry.selectByVisibleText("Rome");
        driver.findElement(By.xpath(prop.getProperty("FindFlight"))).submit();
        Thread.sleep(1000);
        Assert.assertEquals("Flights from Philadelphia to Rome Aires:", "Flights from Philadelphia to Rome Aires:");
//driver.quit();

        System.out.println("User is on Page" + driver.getTitle());
        driver.findElement(By.xpath(prop.getProperty("ChoseFlight"))).click();

        long implicitlyWait = 20;

        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
        System.out.println("User is on Page" + driver.getTitle());
        driver.findElement(By.id("inputName")).sendKeys("TestName");
        driver.findElement(By.id("address")).sendKeys("Test Address");
        driver.findElement(By.id("city")).sendKeys("TestCity");
        driver.findElement(By.id("state")).sendKeys("Test State");
        driver.findElement(By.id("creditCardMonth")).sendKeys("11");
        driver.findElement(By.id("creditCardYear")).sendKeys("2017");
        driver.findElement(By.id("zipCode")).sendKeys("123456");
        driver.findElement(By.id("creditCardNumber")).sendKeys("ABC123TEST");
        driver.findElement(By.id("nameOnCard")).sendKeys("TestName");
        Select cardType = new Select(driver.findElement(By.name("cardType")));
        cardType.selectByVisibleText("Visa");
        WebElement chkBtn = driver.findElement(By.id("rememberMe"));
        chkBtn.click();
        driver.findElement(By.xpath("/html/body/div[2]/form/div[11]/div/input")).submit();

        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
        System.out.println("User is on Page" + driver.getTitle());
        System.out.println("Booking Id Value is :" + driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[1]/td[2]")).getText());
        driver.quit();

    }
}
