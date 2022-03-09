package tests;

import base.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.PageOfAutoExReg;

import static org.testng.Assert.assertEquals;

public class TestOfAutoExReg extends SeleniumBase {


    PageOfAutoExReg pageOfAutoExReg;

    @Test(priority = 1)
    public void urlAndTitle() {
        pageOfAutoExReg = new PageOfAutoExReg(driver);
        driver.get(setBaseUrl());
        pageOfAutoExReg.urlDisp();
        pageOfAutoExReg.testTitle();


    }

    @Test(priority = 2)
    public void singnUp() {
        pageOfAutoExReg.loginSign();
        pageOfAutoExReg.createAccount();

    }

    @Test(priority = 3)
    public void accountInfo() {
        pageOfAutoExReg.setLoginConfirmPage();
        pageOfAutoExReg.setMr();
        pageOfAutoExReg.setPass();
        pageOfAutoExReg.dateOfBirth();
        pageOfAutoExReg.checkbox();
        pageOfAutoExReg.nameLastName();
        pageOfAutoExReg.setAddress();
        pageOfAutoExReg.setCreate();

    }

    @Test(priority = 4)
    public void accountCreatedForDeleting() {
        pageOfAutoExReg.ridOfAccount();
        pageOfAutoExReg.finalydelete();
        pageOfAutoExReg.messageForGevorg();
    }
}
