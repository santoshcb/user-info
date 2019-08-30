package com.tm.user.info;

import org.apache.commons.lang.time.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Util {
    /**
     * Get property value from properties file
     *
     * @param key
     * @return property value
     */
    public static String getProperty(String key) {
        String value = null;
        Properties properties = new Properties();
        File file = new File("userinfo.properties");
        try {
            FileInputStream fileInput = new FileInputStream(file);
            properties.load(fileInput);
            value = properties.getProperty(key);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to get property !!");
        }
        return value;

    }

    /**
     * Wait for seconds
     *
     * @param seconds
     */
    public static void sleep(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Enter text in the text field
     *
     * @param driver
     * @param element
     * @param text
     */
    public void enterText(WebDriver driver, By element, String text) {

        driver.findElement(element).sendKeys(text);

    }

    public static void selectDropDownByName(WebDriver driver, By locator, String visibleText) {
        Select options = new Select(driver.findElement(locator));
        options.selectByVisibleText(visibleText);
    }

    public static void selectDropDownByIndex(WebDriver driver, By locator, int index) {
        Select options = new Select(driver.findElement(locator));
        options.selectByIndex(index);
    }

    /**
     * Click Element
     *
     * @param driver
     * @param element
     */
    public void clickElement(WebDriver driver, By element) {
        sleep(3);
        driver.findElement(element).click();
    }

    public String getText(WebDriver driver, By element) {
        sleep(3);
        return driver.findElement(element).getText();
    }

    /***
     * Converts map object to an temp array and returns its size .
     *
     * @param map Map object
     * @param key key of the map object
     * @return int of array size .
     */
    public static int getArraySize(Map<String, Object> map, String key) {
        if (key == null)
            return map.size();
        int count = 0;
        boolean valueFound = false;
        key = key.toLowerCase();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key2 = entry.getKey();
            String value2 = (String) entry.getValue();
            if (value2 == null || value2.length() == 0)
                continue;

            key2 = key2.toLowerCase();
            if (key2.startsWith(key + ".")) {
                valueFound = true;
                String subst = key2.substring((key + ".").length());
                String[] ss = subst.split("\\.");
                try {
                    int value = Integer.parseInt(ss[0]);
                    count = (value > count ? value : count);
                } catch (Exception e) {
                    //todo.. logging of exception or warning
                }
            }
        }
        return (valueFound ? count + 1 : count);
    }

    /**
     * Parses an input stream and returns a String[][] object
     *
     * @param is
     * @return
     * @throws IOException
     */
    public static String[][] read(InputStream is, String delim) throws IOException {

        String[][] result = null;
        List<String[]> list = new ArrayList<String[]>();
        String inputLine; // String that holds current file line

        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8")); // KEEPME
        while ((inputLine = reader.readLine()) != null) {
            try {
                String[] item = null;
                if (delim == null)
                    item = parseLine(inputLine, UtilConstants.DELIM_CHAR);
                else
                    item = parseLine(inputLine, delim);
                if (item != null)
                    list.add(item);
            } catch (Exception e) {
                //todo.. logging of exception or warning
            }
        }
        reader.close();

        if (list.size() > 0) {
            result = new String[list.size()][];
            list.toArray(result);
        }
        return result;
    }

    /***
     * Parses line with the provided delimiter
     *
     * @param line  input of the line to be parsed
     * @param delim delimiter to be parsed
     * @return string array of line after parsed
     */
    public static String[] parseLine(String line, String delim) {
        if (line == null || line.trim().length() == 0) {
            return null;
        }
        List<String> tokenList = new ArrayList<String>();
        String[] result = null;
        String[] tokens = line.split(delim);
        int count = 0;
        while (count < tokens.length) {
            if (tokens[count] == null || tokens[count].length() == 0) {
                tokenList.add("");
                count++;
                continue;
            }

            if (tokens[count].startsWith(UtilConstants.DOUBLE_QUOTE)) {
                StringBuffer sbToken = new StringBuffer(tokens[count].substring(1));
                while (count < tokens.length && !tokens[count].endsWith(UtilConstants.DOUBLE_QUOTE)) {
                    count++;
                    sbToken.append(UtilConstants.DELIM_CHAR).append(tokens[count]);
                }
                sbToken.deleteCharAt(sbToken.length() - 1);
                tokenList.add(sbToken.toString());
            } else {
                tokenList.add(tokens[count]);
            }
            count++;
        }

        if (tokenList.size() > 0) {
            result = new String[tokenList.size()];
            tokenList.toArray(result);
        }
        return result;

    }

    public static void selectAnyValueFromDropdown(WebDriver driver, By element) {
        Util util = new Util();
        util.clickElement(driver, element);
        Util.sleep(3);
        driver.findElement(element).sendKeys(Keys.ARROW_DOWN);
        Util.sleep(3);
        driver.findElement(element).sendKeys(Keys.ENTER);
    }

    public String getYesterday() {
        Date date = DateUtils.addDays(new Date(), -1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(date));
        String str = sdf.format(date);
        String s[] = str.split("-");
        return s[2];
    }

}
