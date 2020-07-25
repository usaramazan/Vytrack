package fleet_vehicle_odometer;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BeforeAfter;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class VehicleOdometer extends BeforeAfter  {

    @Test
    public void TC1_seeOdometerGrid() throws InterruptedException {

//        Driver.getDriver().get("https://qa2.vytrack.com/user/login");
//        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(ConfigReader.getProperty("validUsername1"));
//        Driver.getDriver().findElement(By.id("prependedInput2")).sendKeys(ConfigReader.getProperty("validPassword"));
//        Driver.getDriver().findElement(By.id("_submit")).click();

//        Actions actions = new Actions(Driver.getDriver());
//        WebElement fleet = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
//        actions.moveToElement(fleet).perform();
        Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Odometer']")).click();
        String expected = "Vehicle Odometer";
        Thread.sleep(2000);
        String actual= Driver.getDriver().getTitle();
        System.out.println(actual);
        Assert.assertTrue(actual.contains(expected));

    }
    @Test
    public void TC2_createVehicleOdometer() throws InterruptedException {
//        Actions actions = new Actions(Driver.getDriver());
//        WebElement fleet = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
//        actions.moveToElement(fleet).perform();
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Odometer']")).click();
        Thread.sleep(3000);
        WebElement createVehicleOdometer = Driver.getDriver().findElement(By.xpath("//a[@title='Create Vehicle Odometer']"));
        createVehicleOdometer.click();
        Thread.sleep(2000);
        WebElement odometerValue = Driver.getDriver().findElement(By.xpath("//input[contains(@id, 'custom_entity_type_OdometerValue')]"));
        odometerValue.sendKeys("2000");

        WebElement date = Driver.getDriver().findElement(By.xpath("//input[@placeholder='Choose a date']"));
        date.click();

        Thread.sleep(5000);
        Select selectMonth = new Select(Driver.getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']")));
        selectMonth.selectByVisibleText("Jun");
        Thread.sleep(5000);
        Select selectYear = new Select(Driver.getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']")));
        selectYear.selectByVisibleText("2010");
        Thread.sleep(2000);
        WebElement day = Driver.getDriver().findElement(By.xpath("//table/tbody/tr[1]/td[7]"));
        day.click();
        Thread.sleep(2000);

        WebElement driverName = Driver.getDriver().findElement(By.xpath("//input[contains(@id, 'custom_entity_type_Driver')]"));
        driverName.sendKeys("Ramazan Ak");
        Thread.sleep(2000);
//        Select selectUnit = new Select(Driver.getDriver().findElement(By.xpath("(//a[@href='javascript:void(0)']/span)[1]")));
//        selectUnit.selectByIndex(1);
        Driver.getDriver().findElement(By.xpath("(//a[@href='javascript:void(0)']/span)[1]")).click();
        Driver.getDriver().findElement(By.xpath("//div[.='km']")).click();

        WebElement save = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        save.click();

        Thread.sleep(2000);
        Actions actions2 = new Actions(Driver.getDriver());
        WebElement fleet2 = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        actions2.moveToElement(fleet2).perform();
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Odometer']")).click();
        Thread.sleep(3000);

        Driver.getDriver().findElement(By.xpath("//input[@type='number']")).clear();
        WebElement pageNumber = Driver.getDriver().findElement(By.xpath("//label[@class='dib'][2]"));
        String number = pageNumber.getText().substring(3);
        System.out.println(number);
        Thread.sleep(5000);
        Driver.getDriver().findElement(By.xpath("//input[@type='number']")).sendKeys(number+ Keys.ENTER);
        Thread.sleep(2000);
        Driver.getDriver().navigate().refresh();
        //WebElement checkName = Driver.getDriver().findElement(By.xpath("(//tbody[@class='grid-body']/tr/td[4])[1]"));
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//tbody[@class='grid-body']/tr/td[4]"));
        List<String> listNames = new ArrayList<>();
        Thread.sleep(3000);
        for(WebElement each:list) {
            listNames.add(each.getText());
        }
        System.out.println(listNames);
        Assert.assertTrue(listNames.contains("Ramazan Ak"),"name was added, PASSED");



        //NOTE: model kismmini yapmadim, bos gorunuyor

    }
    @Test
    public void cancel() throws InterruptedException {
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Odometer']")).click();
        Thread.sleep(3000);
        WebElement createVehicleOdometer = Driver.getDriver().findElement(By.xpath("//a[@title='Create Vehicle Odometer']"));
        createVehicleOdometer.click();
        Thread.sleep(2000);
        WebElement cancelButton = Driver.getDriver().findElement(By.xpath("//a[@title='Cancel']"));
        cancelButton.click();
        String expected = "Vehicle Odometer";
        Thread.sleep(2000);
        String actual= Driver.getDriver().getTitle();
        System.out.println(actual);
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void edit() throws InterruptedException {
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Odometer']")).click();
        Thread.sleep(3000);
        Thread.sleep(2000);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//tbody[@class='grid-body']/tr[1]/td[7]"))).perform();
        //Driver.getDriver().findElement(By.xpath("//tbody/tr[6]/td[7]/div/div/ul/li/ul/li[2]")).click();
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("//a[@href='/entity/update/Extend_Entity_VehiclesOdometer/item/998']")).click();

    }

}
