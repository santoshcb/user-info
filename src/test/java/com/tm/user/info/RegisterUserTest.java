package com.tm.user.info;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class RegisterUserTest extends Util {

    private final static String DATAPROVIDER_NAME = "UserInfo";
    private final static String CSV_FILENAME = "UserInfoTestData.csv";
    public String CHROME_PATH = ".\\src\\test\\resources\\chromedriver.exe";
    UserPage page = new UserPage();


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

        System.setProperty("webdriver.chrome.driver", CHROME_PATH);
        WebDriver driver = new ChromeDriver();
        driver.get(Util.getProperty("URL"));
        driver.manage().window().maximize();
        sleep(3);
        clickElement(driver, page.register);
        clickElement(driver, page.cwc_clickHere);
        enterText(driver, page.firstName, user.getFirstName());
        enterText(driver, page.middleInitialName, user.getMiddleInitial());
        enterText(driver, page.lastName, user.getLastName());
        enterText(driver, page.validEmail, user.getEmail());
        enterText(driver, page.confirmEmail, user.getEmail());
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
        sleep(5);
    }
}
