package pages;

import HelpFullPages.Message;
import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.TestOfAutoExReg;

import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PageOfAutoExReg extends SeleniumBase {
    TestOfAutoExReg testOfAutoExReg;
    WebDriver driver;

    public PageOfAutoExReg(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(linkText = "Signup / Login")
    WebElement login;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")
    WebElement newName;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
    WebElement newEmail;

    @FindBy(className = "login-form")
    WebElement loginConfirmPage;

    @FindBy(id = "id_gender1")
    WebElement mr;

    @FindBy(id = "password")
    WebElement pass;

    @FindBy(id = "days")
    WebElement day;

    @FindBy(id = "months")
    WebElement month;

    @FindBy(id = "years")
    WebElement year;

    @FindBy(id = "newsletter")
    WebElement newsLetter;

    @FindBy(id = "optin")
    WebElement specialOffer;

    @FindBy(id = "first_name")
    WebElement name;

    @FindBy(id = "last_name")
    WebElement lastName;

    @FindBy(id = "company")
    WebElement ACA;

    @FindBy(id = "country")
    WebElement country;

    @FindBy(id = "state")
    WebElement marz;

    @FindBy(id = "city")
    WebElement qaxaq;

    @FindBy(id = "address1")
    WebElement street;

    @FindBy(id = "zipcode")
    WebElement zip;

    @FindBy(id = "mobile_number")
    WebElement phoneNumber;

    @FindBy(css = "button.btn.btn-default")
    WebElement create;

    @FindBy(linkText = "Continue")
    WebElement continueForDelete;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
    WebElement deleteAccount;

    @FindBy(xpath = "//*[@id=\"deleteModal\"]/div/div/div[2]/form/button")
    WebElement finalDelete;

    ////////

    public void urlDisp() {
        String url = driver.getCurrentUrl();
        String expectUrl = setBaseUrl();
        String actualUrl = String.valueOf(url);
        assertEquals(expectUrl, actualUrl, "URL is not displayed " + expectUrl + " Dosent displayed  " + actualUrl);
        //
        String driverCurrentUrl = driver.getCurrentUrl();
        if (setBaseUrl().contains(driverCurrentUrl)) {
            System.out.println("Your WebSite is loaded perfectly ");
        } else {
            System.out.println("De Chtpec Website@");
        }

    }

    @Test
    public void testTitle() {

        String title = driver.getTitle();
        String expectedText = "Automation Exercise";
        String actualText = String.valueOf(title);
        System.out.println("Expected Title: " + expectedText);
        //
        // String expectedText = "Automation Exercise";
        System.out.println("Actual Title: " + driver.getTitle());
        assertEquals(expectedText, actualText, "Texts doesn't matching -> " + expectedText + " doesn't matching " + actualText);

    }

    public void loginSign() {
        login.click();
        String title = driver.getTitle();
        String expectedText = "Automation Exercise - Signup / Login";
        String actualText = String.valueOf(title);
        System.out.println("Login Title is down line");
        System.out.println("Expected Title: " + expectedText);
        //

        System.out.println("Actual Title: " + driver.getTitle());
        assertEquals(expectedText, actualText, "Texts doesn't matching -> " + expectedText + " doesn't matching " + actualText);

    }

    public void createAccount() {

        WebElement newUser = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));
        if (newUser.getText().contains("New User Signup!")) {
            System.out.println("New User is on ");
            newName.click();
            newName.clear();
            newName.sendKeys("Tigran");
        }
        String suffixEmail = "@costaRica.com";
        //
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println("Randomised Email Prefix ->:  " + generatedString);
        newEmail.click();
        newEmail.clear();
        newEmail.sendKeys(generatedString + suffixEmail);
        newEmail.submit();
    }

    public void setLoginConfirmPage() {
        if (loginConfirmPage.getText().contains("Enter Account Information")) {
            boolean conf = true;

            String expectedText = String.valueOf(loginConfirmPage);
            assertEquals(expectedText, loginConfirmPage, "Texts doesn't matching -> " + expectedText + " doesn't matching " + loginConfirmPage);
            if (conf == true) {
                System.out.println(conf + "" + String.valueOf(loginConfirmPage));
            }
        }
    }

    public void setMr() {

        String title = driver.getTitle();
        String expectedText = "Automation Exercise - Signup";
        String actualText = String.valueOf(title);
        System.out.println("Login Title is down line");
        System.out.println("Expected Title: " + expectedText);

        System.out.println("Actual Title: " + driver.getTitle());
        assertEquals(expectedText, actualText, "Texts doesn't matching -> " + expectedText + " doesn't matching " + actualText);

        mr.click();

    }

    public void setPass() {
        pass.sendKeys("123.Qwerty");
    }

    public void dateOfBirth() {
        Select dayA = new Select(driver.findElement(By.id("days")));
        dayA.selectByVisibleText("7");
        Select monthA = new Select(driver.findElement(By.id("months")));
        monthA.selectByVisibleText("June");
        Select yearA = new Select(driver.findElement(By.id("years")));
        yearA.selectByVisibleText("1993");


    }


    public void checkbox() {
        newsLetter.click();
        specialOffer.click();
    }

    public void nameLastName() {
        name.sendKeys("Tigran");
        lastName.sendKeys("Ba");
        ACA.sendKeys("ACA");
    }

    public void setAddress() {
        street.sendKeys("Hakob Hakobyan 3");
        Select select = new Select(country);
        select.selectByVisibleText("United States");
        marz.sendKeys("California part of Armenia");
        qaxaq.sendKeys("Abovyan");
        zip.sendKeys("1234");
        phoneNumber.sendKeys("+1-555-777-999");

    }


    public void setCreate() {
        create.submit();
        continueForDelete.click();
    }

    public void ridOfAccount() {
        deleteAccount.click();
    }

    public void finalydelete() {
        finalDelete.click();
    }

    public void messageForGevorg(){
        Message message = new Message();

        System.out.println(message);
    }
}
