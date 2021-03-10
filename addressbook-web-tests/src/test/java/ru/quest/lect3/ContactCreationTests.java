package ru.quest.lect3;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactCreationTests {
    private WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        gotoAddressBook();
        login("admin", "secret");
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        createNewUser();
        firstMiddleLastNames(new ContactData("Krutoy", "Perec", "Piwet"));
        nickname();
        title("Piwu Titlu");
        company("Kompaniu Piwu");
        firstAddress("4to eto za mesto");
        phoneNumbers("11111", "22222", "33333", "44444");
        eMails("sdfgsdfg@gdfg.ru", "dfjfdgddg@gdjf.ru", "jddfgjisdjfg@gdjfkjg.com");
        homepage("sdgsdfghdfhfdsfg");
        dates("1980", "May", "17", "1978", "August", "16");
        secondary("nu o4 bolshoy dvorec", "49", "vtoroi takoi");
        submitCreation();
        home();
        logout();
    }

    private void logout() {
        wd.findElement(By.linkText("Logout")).click();
    }

    private void home() {
        wd.findElement(By.linkText("home page")).click();
    }

    private void submitCreation() {
        wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    private void secondary(String notesParameter, String numberSecondaryParameter, String secondaryAddress) {
        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys(secondaryAddress);
        wd.findElement(By.name("phone2")).click();
        wd.findElement(By.name("phone2")).clear();
        wd.findElement(By.name("phone2")).sendKeys(numberSecondaryParameter);
        wd.findElement(By.name("notes")).clear();
        wd.findElement(By.name("notes")).sendKeys(notesParameter);
    }

    private void dates(String aYearParameter, String aMonthParameter, String aDayParameter, String bYearParameter, String bMonthParameter, String bDayParameter) {
        wd.findElement(By.name("bday")).click();
        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(bDayParameter);
        wd.findElement(By.name("bday")).click();
        wd.findElement(By.name("bmonth")).click();
        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(bMonthParameter);
        wd.findElement(By.name("bmonth")).click();
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys(bYearParameter);
        wd.findElement(By.name("aday")).click();
        new Select(wd.findElement(By.name("aday"))).selectByVisibleText(aDayParameter);
        wd.findElement(By.name("aday")).click();
        wd.findElement(By.name("amonth")).click();
        new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(aMonthParameter);
        wd.findElement(By.name("amonth")).click();
        wd.findElement(By.name("ayear")).click();
        wd.findElement(By.name("ayear")).clear();
        wd.findElement(By.name("ayear")).sendKeys(aYearParameter);
    }

    private void homepage(String homepageParameter) {
        wd.findElement(By.name("homepage")).click();
        wd.findElement(By.name("homepage")).clear();
        wd.findElement(By.name("homepage")).sendKeys(homepageParameter);
    }

    private void eMails(String firstEmail, String secondEmail, String thirdEmail) {
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(firstEmail);
        wd.findElement(By.name("email2")).clear();
        wd.findElement(By.name("email2")).sendKeys(secondEmail);
        wd.findElement(By.name("email3")).clear();
        wd.findElement(By.name("email3")).sendKeys(thirdEmail);
    }

    private void phoneNumbers(String phoneHome, String phoneMobile, String phoneWork, String phoneFax) {
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(phoneHome);
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(phoneMobile);
        wd.findElement(By.name("work")).click();
        wd.findElement(By.name("work")).clear();
        wd.findElement(By.name("work")).sendKeys(phoneWork);
        wd.findElement(By.name("fax")).click();
        wd.findElement(By.name("fax")).clear();
        wd.findElement(By.name("fax")).sendKeys(phoneFax);
    }

    private void firstAddress(String firstAddressParameter) {
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(firstAddressParameter);
    }

    private void company(String companyParameter) {
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(companyParameter);
    }

    private void title(String titleParameter) {
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).clear();
        wd.findElement(By.name("title")).sendKeys(titleParameter);
    }

    private void nickname() {
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(nicknameParameter());
    }

    private String nicknameParameter() {
        return "Bukovi";
    }

    private void firstMiddleLastNames(ContactData contactData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddleName());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
    }

    private void createNewUser() {
        wd.findElement(By.linkText("add new")).click();
    }

    private void login(String user, String password) {
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(user);
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    private void gotoAddressBook() {
        wd.get("http://localhost/addressbook/edit.php");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        wd.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}