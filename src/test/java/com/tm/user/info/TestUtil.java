package com.tm.user.info;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestUtil extends Util {

    UserPage page = new UserPage();
    public String CHROME_PATH = ".\\src\\test\\resources\\chromedriver.exe";


    public WebDriver login() {
        System.setProperty("webdriver.chrome.driver", CHROME_PATH);
        WebDriver driver = new ChromeDriver();
        driver.get(Util.getProperty("URL"));
        driver.manage().window().maximize();
        sleep(5);

        enterText(driver, page.userName, Util.getProperty("USER"));
        enterText(driver, page.password, Util.getProperty("PASSWORD"));
        clickElement(driver, page.login);
        return driver;
    }

    public WebDriver navigateToSearchPage() {
        WebDriver driver = login();
        driver.get("https://stage.customer.getransportation.com/cwcportal/web/cwcportal/search");
        sleep(10);
        return driver;
    }

    public WebDriver verifyCustomer(WebDriver driver, String customerName) {
        if (!driver.findElement(page.customerName).getText().contains(customerName)) {
            clickElement(driver, page.changeUserDrop);
            clickElement(driver, page.switchCust);
            clickElement(driver, page.switchC);
            enterText(driver, page.switchC, customerName);
            driver.findElement(page.switchC).sendKeys(Keys.ENTER);
            clickElement(driver, page.changeCustomer);
            sleep(10);
        }
        return driver;
    }

    public WebDriver enterDefaultValuesForProductTypes(WebDriver driver, String productType) {
        enterText(driver, page.headline, "PDS-New ticket for testing");
        selectAnyValueFromDropdown(driver, page.productClass);
        selectAnyValueFromDropdown(driver, page.issueType);
        selectAnyValueFromDropdown(driver, page.subIssueType);
        selectAnyValueFromDropdown(driver, page.issueSource);

        //for other tickets
        if (productType.equals("y")) {
            selectAnyValueFromDropdown(driver, page.yardCategory);
            selectAnyValueFromDropdown(driver, page.yardName);
        }
        enterText(driver, page.issueDescription, "PDS Testing description");
        enterText(driver, page.observerName, "Ganesh_Testing");
        enterText(driver, page.observerPhone, "1234567890");
        enterText(driver, page.observerEmail, "testing@gmail.com");
        enterText(driver, page.systemVersion, "1");
        clickElement(driver, page.dateIcon);
        clickElement(driver, By.xpath("//td[@class='day'][contains(text(),'" + getYesterday() + "')]"));
        selectAnyValueFromDropdown(driver, page.timeHour);
        selectAnyValueFromDropdown(driver, page.timeMinute);
        selectAnyValueFromDropdown(driver, page.am_pm);
        clickElement(driver, page.timezone);
        enterText(driver, page.timezone, "c");
        driver.findElement(page.timezone).sendKeys(Keys.ENTER);
        enterText(driver, page.tracableItem, "Testing");
        selectAnyValueFromDropdown(driver, page.division);
        clickElement(driver, page.division);
        selectAnyValueFromDropdown(driver, page.priority);
        selectAnyValueFromDropdown(driver, page.seveirity);
        enterText(driver, page.steps, "Testing steps");
        //enterText(driver, page.notes, "Testing notes");
        return driver;
    }

    public void submitTicket(String productType) {
        WebDriver driver = login();
        verifyCustomer(driver, "Norfolk Southern Corp");
        clickElement(driver, page.myApplications);
        clickElement(driver, page.launch);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        sleep(40);
        ExpectedConditions.visibilityOfElementLocated(page.productType);
        clickElement(driver, page.productType);
        enterText(driver, page.productType, productType);
        driver.findElement(page.productType).sendKeys(Keys.ENTER);
        sleep(20);
        clickElement(driver, page.createNewTicket);
        sleep(20);
        enterDefaultValuesForProductTypes(driver, productType);
        clickElement(driver, page.createTicketButton);
        sleep(20);
    }

    public void submitSAT_Ticket() {
        WebDriver driver = login();
        verifyCustomer(driver, "Norfolk Southern Corp");
        clickElement(driver, page.myApplications);
        clickElement(driver, page.launch);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        sleep(40);
        ExpectedConditions.visibilityOfElementLocated(page.productType);
        clickElement(driver, page.productType);
        enterText(driver, page.productType, "sat");
        driver.findElement(page.productType).sendKeys(Keys.ENTER);
        sleep(20);
        clickElement(driver, page.createNewTicket);
        sleep(20);
        enterText(driver, page.headline, "PDS-New ticket for testing");
        selectAnyValueFromDropdown(driver, page.issueType);
        selectAnyValueFromDropdown(driver, page.affectedPage);
        enterText(driver, page.issueDescription, "PDS Testing description");
        enterText(driver, page.additionalNotes, "PDS Testing Additional notes");
        clickElement(driver, page.dateIcon);
        clickElement(driver, By.xpath("//td[@class='day'][contains(text(),'" + getYesterday() + "')]"));
        selectAnyValueFromDropdown(driver, page.timeHour);
        selectAnyValueFromDropdown(driver, page.timeMinute);
        selectAnyValueFromDropdown(driver, page.am_pm);
        clickElement(driver, page.timezone);
        selectAnyValueFromDropdown(driver, page.priority);
        selectAnyValueFromDropdown(driver, page.seveirity);
        enterText(driver, page.comments, "Testing comments");
        clickElement(driver, page.createTicketButton);
        sleep(20);
    }

    public void submit_SAMP_Ticket() {

        WebDriver driver = login();

        verifyCustomer(driver, "Aurizon Operarations Limited");
        clickElement(driver, page.myApplications);
        clickElement(driver, page.launch);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        sleep(40);
        ExpectedConditions.visibilityOfElementLocated(page.productType);
        clickElement(driver, page.productType);
        enterText(driver, page.productType, "SAMP");
        driver.findElement(page.productType).sendKeys(Keys.ENTER);
        sleep(20);
        clickElement(driver, page.createNewTicket);
        sleep(20);
        enterText(driver, page.headline, "PDS-New ticket for testing");
        selectAnyValueFromDropdown(driver, page.productClass);
        selectAnyValueFromDropdown(driver, page.assignedOrg);
        selectAnyValueFromDropdown(driver, page.issueType);
        selectAnyValueFromDropdown(driver, page.issueSource);
        enterText(driver, page.issueDescription, "Testing issue description");
        enterText(driver, page.observerName, "Ganesh_Testing");
        enterText(driver, page.observerPhone, "1234567890");
        enterText(driver, page.observerEmail, "testing@gmail.com");
        enterText(driver, page.systemVersion, "1");
        clickElement(driver, page.dateIcon);
        clickElement(driver, By.xpath("//td[@class='day'][contains(text(),'" + getYesterday() + "')]"));
        selectAnyValueFromDropdown(driver, page.timeHour);
        selectAnyValueFromDropdown(driver, page.timeMinute);
        selectAnyValueFromDropdown(driver, page.am_pm);
        clickElement(driver, page.timezone);
        selectAnyValueFromDropdown(driver, page.priority);
        selectAnyValueFromDropdown(driver, page.seveirity);
        enterText(driver, page.steps, "Testing steps");
        enterText(driver, page.notes, "Testing notes");
        clickElement(driver, page.createTicketButton);
        sleep(20);

    }
}
