package com.tm.user.info;

import org.openqa.selenium.By;

/**
 * Hello world!
 */
public class UserPage {

    public By userName = By.id("username");
    public By password = By.id("loginpassword");
    public By login = By.xpath("//button[@class='btn btn-info btn-large lgn-btn']");
    public By register = By.linkText("Register");
    public By cwc_clickHere = By.xpath("//a[@id='loginInfoNextButton']//button[@class='btn btn-small'][contains(text(),'Click')]");
    public By firstName = By.id("regFirstName");
    public By middleInitialName = By.id("regMiddleName");
    public By lastName = By.id("regLasttName");
    public By validEmail = By.id("regEmail");
    public By confirmEmail = By.id("regConfirmEmail");
    public By userId = By.id("regSsoid");

    public By setPassword = By.id("newPassword");
    public By confirmPassword = By.id("confirmPassword");
    public By challengeQuestion = By.id("regChallengeQuestion");
    public By challengeResponse = By.id("regChallengeResponse");
    public By telephoneNumber = By.id("regTelephone");
    public By fax = By.id("regFax");
    public By address1 = By.id("regAddressOne");
    public By address2 = By.id("regAddressTwo");
    public By city = By.id("regCity");
    public By state = By.id("regStateProvince");
    public By postalCode = By.id("regPostalCode");
    public By country = By.xpath("//input[@placeholder='Country']");
    public By next = By.id("sosAccountreg");
    public By businessType = By.id("businessType");
    public By geContact = By.id("geContact");
    public By companyName = By.id("companyName");
    public By supervisorName = By.id("supervisorName");
    public By supervisorTitle = By.id("supervisorTitle");
    public By supervisorPhone = By.id("supervisorPhone");
    public By reasonForRequest = By.id("reasonForRequest");
    public By department = By.id("department");
    public By secondNext = By.xpath("//div[@id='collapseTwo']//a[2]");
    public By request = By.xpath("//*[starts-with(@id,'a_')]");
    public By iAccept = By.id("regTermsAndConditionsCheckbox");
    public By submit = By.id("btnSubmit");
    public By searchPartsTextBox = By.id("exactEnteredItems");
    public By search = By.cssSelector("#exactSearchButton");
    public By searchedResult = By.id("search_geItem");
    public By searchPartsButton = By.linkText("Search Parts");
    public By partialNameSearch = By.id("partialItemNum");
    public By partialSearchButton = By.id("btn-partial-search");
    public By uploadTextBox = By.id("dummyfile");
    public By ok = By.linkText("OK");
    public By browse = By.id("file");
    public By upload = By.id("uploadBar");



}
