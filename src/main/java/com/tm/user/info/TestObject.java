package com.tm.user.info;

import org.apache.commons.lang3.StringUtils;

public class TestObject {
    public static final String TEST_CASE_ID = "TestObject.TestCaseId";
    public static final String TEST_TITLE = "TestObject.TestTitle";

    private String testCaseId = "";
    private String testMethod = "";
    private String testTitle = "";
    private String testSteps = "";
    private String testData = "";

    public String getTestData() {
        return testData;
    }

    public void setTestData(String testData) {
        this.testData = testData;
    }

    public String getTestCaseId() {
        return testCaseId;
    }

    public String getTestMethod() {
        return testMethod;
    }

    public String getTestTitle() {
        return testTitle;
    }

    public void setTestCaseId(String testCaseId) {
        this.testCaseId = testCaseId;
    }

    public void setTestMethod(String testMethod) {
        this.testMethod = testMethod;
    }


    public void setTestTitle(String testTitle) {
        this.testTitle = testTitle;
    }

    public String getTestSteps() {
        return testSteps;
    }

    public void setTestSteps(String testSteps) {
        this.testSteps = testSteps;
    }

    public String toString() {
        StringBuffer ret = new StringBuffer();
        ret.append("[TestCaseId=" + testCaseId);
        if (StringUtils.isNotEmpty(testMethod)) {
            ret.append("|TestMethod=" + testMethod);
        }
        if (StringUtils.isNotEmpty(testTitle)) {
            ret.append("|TestTitle=" + testTitle);
        }
        ret.append("]");
        return ret.toString();
    }

}
