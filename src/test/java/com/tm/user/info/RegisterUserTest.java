package com.tm.user.info;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class RegisterUserTest extends Util {

    private final static String DATAPROVIDER_NAME = "UserInfo";
    private final static String CSV_FILENAME = "UserInfoTestData.csv";
    public String CHROME_PATH = ".\\src\\test\\resources\\chromedriver.exe";
    UserPage page = new UserPage();
    WebDriver driver;
    Faker faker = new Faker();

    @DataProvider(name = DATAPROVIDER_NAME)
    public static Iterator<Object[]> testDataFromCSV(Method method) {
        Iterator<Object[]> objectsFromCsv = null;
        try {
            LinkedHashMap<String, Class<?>> entityClazzMap = new LinkedHashMap<String, Class<?>>();
            LinkedHashMap<String, String> methodFilter = new LinkedHashMap<String, String>();
            methodFilter.put(TestObject.TEST_TITLE, method.getName());
            entityClazzMap.put("TestObject", TestObject.class);
            entityClazzMap.put("User", User.class);
            objectsFromCsv = CsvUtil.getObjectsFromCsv(RegisterUserTest.class, entityClazzMap, "./src/test/java/com/tm/user/info/" + CSV_FILENAME, null,
                    methodFilter);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return objectsFromCsv;
    }

    @Test(groups = {"registerUser"}, dataProvider = DATAPROVIDER_NAME)
    public void registerUser(TestObject testObject, User user) {

        String firstName = faker.firstName();
        String lastName = faker.lastName();
        String email = firstName + lastName.toLowerCase() + "@gmail.com";
        String userId = firstName + "_" + lastName + "_test";

        System.out.println("FirstName: " + firstName);
        System.out.println("LastName: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("UserId: " + userId);


        System.setProperty("webdriver.chrome.driver", CHROME_PATH);
        WebDriver driver = new ChromeDriver();
        driver.get(Util.getProperty("URL"));
        driver.manage().window().maximize();
        sleep(5);
        clickElement(driver, page.register);
        clickElement(driver, page.cwc_clickHere);
        enterText(driver, page.firstName, firstName);
        enterText(driver, page.middleInitialName, user.getMiddleInitial());
        enterText(driver, page.lastName, lastName);
        enterText(driver, page.validEmail, email);
        enterText(driver, page.confirmEmail, email);
        enterText(driver, page.userId, userId);
        enterText(driver, page.setPassword, user.getPassword());
        enterText(driver, page.confirmPassword, user.getPassword());

        Util.selectDropDownByName(driver, page.challengeQuestion, user.getChallengeQuestion());
        enterText(driver, page.challengeResponse, user.getChallengeResponse());
        enterText(driver, page.telephoneNumber, user.getTelephone());
        enterText(driver, page.fax, user.getFax());
        enterText(driver, page.address1, user.getAddress1());
        enterText(driver, page.address2, user.getAddress2());
        enterText(driver, page.city, user.getCity());
        enterText(driver, page.state, user.getState());
        enterText(driver, page.postalCode, user.getPostalCode());
        enterText(driver, page.country, user.getCountry());
        driver.findElement(page.country).sendKeys(Keys.ENTER);
        sleep(20);
        clickElement(driver, page.next);
        Util.selectDropDownByIndex(driver, page.businessType, 2);
        enterText(driver, page.geContact, user.getGeContact());
        enterText(driver, page.companyName, user.getCompanyName());
        enterText(driver, page.supervisorName, user.getSupervisorName());
        enterText(driver, page.supervisorTitle, user.getSupervisorTitle());
        enterText(driver, page.supervisorPhone, user.getSupervisorPhone());
        enterText(driver, page.reasonForRequest, user.getReasonForRequest());
        Util.selectDropDownByName(driver, page.department, user.getDepartment());
        clickElement(driver, page.secondNext);
        sleep(20);
        try {
            List<WebElement> element = driver.findElements(page.request);
            for (WebElement e : element) {
                e.click();
            }
        } catch (ElementNotVisibleException ex) {

        }
        clickElement(driver, page.iAccept);
        clickElement(driver, page.submit);
        sleep(20);
        driver.close();

    }

    @Test(groups = {"searchParts"}, dataProvider = DATAPROVIDER_NAME)
    public void searchParts(TestObject testObject, User user) {

        System.setProperty("webdriver.chrome.driver", CHROME_PATH);
        WebDriver driver = new ChromeDriver();
        driver.get(Util.getProperty("URL"));
        driver.manage().window().maximize();
        sleep(5);

        enterText(driver, page.userName, Util.getProperty("USER"));
        enterText(driver, page.password, Util.getProperty("PASSWORD"));
        clickElement(driver, page.login);
        driver.get("https://stage.customer.getransportation.com/cwcportal/web/cwcportal/search");
        sleep(10);
        enterText(driver, page.searchPartsTextBox, testObject.getTestData());
        sleep(5);
        clickElement(driver, page.searchPartsTextBox);

        clickElement(driver, page.search);
        sleep(5);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,1000)");
//        sleep(3);
//        Assert.assertEquals(getText(driver, page.searchedResult), testObject.getTestData(), "Search failed!!");
        driver.close();
    }

}
