package uiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class CashboxUserPage {

    public static WebDriver driver;

    @Test
    public static void logInToPage(String loginSubdomainName, String loginNameParam, String loginPassParam) {


        WebElement inHeaderLoginButton = driver.findElement(By.cssSelector(".inheaderlogin"));
        inHeaderLoginButton.click();

        WebElement loginSubdomain = driver.findElement(By.id("login-subdomain"));
        loginSubdomain.sendKeys(loginSubdomainName);

        WebElement loginSubdomainButton = driver.findElement(By.id("gologin"));
        loginSubdomainButton.click();

        WebElement loginUsername = driver.findElement(By.id("loginusername"));
        loginUsername.sendKeys(loginNameParam);

        WebElement loginPassword = driver.findElement(By.id("loginpassword"));
        loginPassword.sendKeys(loginPassParam);

        WebElement radioButtonBG = driver.findElement(By.cssSelector(".login-language-input-radio.selenium-language-radio-button-BG"));
        if (!radioButtonBG.isSelected()) {
            radioButtonBG.click();
        }

        WebElement loginSubmitButton = driver.findElement(By.id("loginsubmit"));
        loginSubmitButton.click();

        WebElement tabsHome = driver.findElement(By.id("tabs_home"));
        Assert.assertTrue(tabsHome.isDisplayed());
    }

    @Test
    public static void goToCashboxPage() {

        WebElement cashboxHeaderButton = driver.findElement(By.id("tabs_cashbox"));
        cashboxHeaderButton.click();

        WebElement addNewIncomeButton = driver.findElement(By.cssSelector(".btn-cashbox-add.btn-green"));
        addNewIncomeButton.click();
    }

    @Test
    public static void assertationCashboxPageIsOpenned(){
        WebElement h2 = driver.findElement(By.id("headline2"));
        Assert.assertTrue(h2.isDisplayed());
    }

    @Test
    public static void clickNewIncomeButton() {

        WebElement radioButtonIncome = driver.findElement(By.cssSelector("input[value^=\"0\"]"));
        if (!radioButtonIncome.isSelected()) {
            radioButtonIncome.click();
        }
    }

    @Test
    public static void fillNewIncomeFields(String incomeValueParam, String incomeReasonParam) {

        WebElement incomeValue = driver.findElement(By.id("cashbox-movement-amount"));
        incomeValue.sendKeys(incomeValueParam);

        WebElement incomeReason = driver.findElement(By.id("cbTitle"));
        incomeReason.sendKeys(incomeReasonParam);

        WebElement submitButton = driver.findElement(By.name("submit"));
        submitButton.click();
    }

    @Test
    public static void clickInsertIncomeButton() {
        WebElement submitButton = driver.findElement(By.name("submit"));
        submitButton.click();
    }

    @Test
    public static void assertNewIncomeIsAddedOrDeleted() {
        WebElement okmsg = driver.findElement(By.id("okmsg"));
        Assert.assertTrue(okmsg.isDisplayed());
    }

    @Test
    public static void deleteNewEntries(){
        WebElement deleteAllCheckbox = driver.findElement(By.id("handle_all"));
        if (!deleteAllCheckbox.isSelected()){
            deleteAllCheckbox.click();
        }

        WebElement cashboxDelButton = driver.findElement(By.id("cshbx_delbtn"));
        cashboxDelButton.click();

        WebElement yesPopUpButton = driver.findElement(By.cssSelector(".selenium-modal-ok-btn"));
        yesPopUpButton.click();

    }

}