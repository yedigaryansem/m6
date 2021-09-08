package com.cucumber.testng.hooks;

import com.cucumber.testng.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHooks {

    @Before
    private void setupDriver(){
        DriverManager.setDriver();
    }

    @After
    private void quitDriver(){
        DriverManager.quitDriver();
    }
}
