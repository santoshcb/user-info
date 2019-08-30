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
    public By myApplications = By.linkText("My Applications");
    public By launch = By.linkText("Launch");
    public By productType = By.xpath("//select[@id='productTypeSelectBox']");
    public By createNewTicket = By.id("createTicketModalBtn");
    public By headline = By.xpath("//textarea[@id='cHeadline']");
    public By productClass = By.xpath("//select[@id='cClass']");
    public By issueType = By.xpath("//select[@id='cUitIssueType']");
    public By subIssueType = By.xpath("//select[@id='cUitSubIssueType']");
    public By issueSource = By.xpath("//select[@id='cUitIssueSource']");
    public By issueDescription = By.id("cIssueDescription");
    public By observerName = By.xpath("//input[@id='cObserversName']");
    public By observerPhone = By.xpath("//input[@id='cObserversPhone']");
    public By observerEmail = By.xpath("//input[@id='cObserversEmail']");
    public By systemVersion = By.xpath("//input[@id='cSystemVersion']");
    public By dateIcon = By.xpath("//form[@id='createTicketForm']//i[@class='icon-calendar']");
    public By date = By.xpath("//td[contains(text(),'27')]");
    public By timeHour = By.xpath("//select[@id='cTimeProblem_HH']");
    public By timeMinute = By.xpath("//select[@id='cTimeProblem_MM']");
    public By am_pm = By.xpath("//select[@id='cTimeProblem_AAA']");
    public By timezone = By.xpath("//select[@id='cTimeZone']");
    public By tracableItem = By.xpath("//input[@id='cTraceableItemIdentifier']");
    public By division = By.xpath("//option[contains(text(),'AL - 3B North')]");
    public By priority = By.xpath("//select[@id='cPriority']");
    public By seveirity = By.xpath("//select[@id='cSeverity']");
    public By steps = By.xpath("//textarea[@id='cStepsToReproduceIssue']");
    public By notes = By.xpath("//textarea[@id='cNotesToSubmitter']");
    public By addAttachment = By.xpath("//button[@id='caddAttachment']");
    public By createTicketButton = By.xpath("//button[@id='createTicketButton']");
    public By yardCategory = By.id("cYardCategory");
    public By yardName = By.id("cYardName");
    public By nextToWork = By.id("cNexttoWork");
    public By affectedPage = By.id("cAffectedPage");
    public By additionalNotes = By.id("cAdditionalNotes");
    public By comments = By.id("cComments");
    public By customerName = By.xpath("//div[@class='span12 compname mobile-compname']");
    public By changeUserDrop = By.xpath("//span[@class='user-name']");
    public By switchCust = By.xpath("//a[contains(text(),'Switch Customer')]");
    public By switchC = By.xpath("//select[@id='switchProfile']");
    public By changeCustomer = By.id("changeCustomer");
    public By assignedOrg = By.id("cAssignedOrganization");



}
