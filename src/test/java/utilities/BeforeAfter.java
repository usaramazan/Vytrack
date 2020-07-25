package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BeforeAfter {

    @BeforeMethod
    public void setUp()  {

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().get("https://qa2.vytrack.com/user/login");
        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(ConfigReader.getProperty("validUsername1"));
        Driver.getDriver().findElement(By.id("prependedInput2")).sendKeys(ConfigReader.getProperty("validPassword"));
        Driver.getDriver().findElement(By.id("_submit")).click();

        Actions actions = new Actions(Driver.getDriver());
        WebElement fleet = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        actions.moveToElement(fleet).perform();

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();

    }
}
