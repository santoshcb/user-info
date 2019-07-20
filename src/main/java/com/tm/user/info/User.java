package com.tm.user.info;

import com.github.javafaker.Faker;

public class User {

    private String firstName = "";
    private String middleInitial = "";
    private String lastName = "";
    private String email = "";
    private String password = "";
    private String challengeQuestion = "";
    private String challengeResponse = "";
    private String telephone = "";
    private String fax = "";
    private String address1 = "";
    private String address2 = "";
    private String city = "";
    private String state = "";
    private String postalCode = "";
    private String country = "";
    private String businessType = "";
    private String geContact = "";
    private String companyName = "";
    private String supervisorName = "";
    private String supervisorTitle = "";
    private String supervisorPhone = "";
    private String reasonForRequest = "";
    private String department = "";

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getGeContact() {
        return geContact;
    }

    public void setGeContact(String geContact) {
        this.geContact = geContact;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getSupervisorTitle() {
        return supervisorTitle;
    }

    public void setSupervisorTitle(String supervisorTitle) {
        this.supervisorTitle = supervisorTitle;
    }

    public String getSupervisorPhone() {
        return supervisorPhone;
    }

    public void setSupervisorPhone(String supervisorPhone) {
        this.supervisorPhone = supervisorPhone;
    }

    public String getReasonForRequest() {
        return reasonForRequest;
    }

    public void setReasonForRequest(String reasonForRequest) {
        this.reasonForRequest = reasonForRequest;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChallengeQuestion() {
        return challengeQuestion;
    }

    public void setChallengeQuestion(String challengeQuestion) {
        this.challengeQuestion = challengeQuestion;
    }

    public String getChallengeResponse() {
        return challengeResponse;
    }

    public void setChallengeResponse(String challengeResponse) {
        this.challengeResponse = challengeResponse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static void main(String[] args) {
        Faker faker = new Faker();

        String name = faker.name();
        String firstName = faker.name();

        System.out.println("Name: "+name);
    }

}
