package com.tm.user.info;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestUtil extends Util{

    UserPage page = new UserPage();
    public String CHROME_PATH = ".\\src\\test\\resources\\chromedriver.exe";

    public WebDriver navigateToSearchPage(){
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
        return driver;
    }
}
