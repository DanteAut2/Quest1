package ru.quest.lect3.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.quest.lect3.appmanager.HelperBase;
import ru.quest.lect3.model.*;

import java.util.concurrent.TimeUnit;

public class ContactHelper extends HelperBase {
    private WebDriver wd;

    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    private void login(String login, String password) { //Логин на сайте
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(login);
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void logout() {
        wd.findElement(By.linkText("Logout")).click();
    }

    public void homepage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public void confirm() {
        wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    public void InputSecondary(InputSecondarys inputSecondarys) { //Ввод полей Secondary
        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys(inputSecondarys.getSecondAddress());
        wd.findElement(By.name("phone2")).click();
        wd.findElement(By.name("phone2")).clear();
        wd.findElement(By.name("phone2")).sendKeys(inputSecondarys.getSecondAddressHomeNumber());
        wd.findElement(By.name("notes")).clear();
        wd.findElement(By.name("notes")).sendKeys(inputSecondarys.getNotes());
    }

    public void inputBdayAday(InputDates inputDates) { //Ввод Дат
        wd.findElement(By.name("bday")).click();
        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(inputDates.getbDayDay());
        wd.findElement(By.name("bday")).click();
        wd.findElement(By.name("bmonth")).click();
        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(inputDates.getbDayMonth());
        wd.findElement(By.name("bmonth")).click();
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys(inputDates.getbDayYear());
        wd.findElement(By.name("aday")).click();
        new Select(wd.findElement(By.name("aday"))).selectByVisibleText(inputDates.getaDayDay());
        wd.findElement(By.name("aday")).click();
        wd.findElement(By.name("amonth")).click();
        new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(inputDates.getaDayMonth());
        wd.findElement(By.name("amonth")).click();
        wd.findElement(By.name("ayear")).click();
        wd.findElement(By.name("ayear")).clear();
        wd.findElement(By.name("ayear")).sendKeys(inputDates.getaDayYear());
    }

    public void inputHomepage(String homepage) {
        wd.findElement(By.name("homepage")).click();
        wd.findElement(By.name("homepage")).clear();
        wd.findElement(By.name("homepage")).sendKeys(homepage);
    }

    public void inputEmails(InputEmails inputEmails) {
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(inputEmails.getFirstEmail());
        wd.findElement(By.name("email2")).clear();
        wd.findElement(By.name("email2")).sendKeys(inputEmails.getSecondEmail());
        wd.findElement(By.name("email3")).clear();
        wd.findElement(By.name("email3")).sendKeys(inputEmails.getThirdEmail());
    }

    public void homeMobileWorkFaxNumber(InputNumbers inputNumbers) { //Ввод ввод номеров телефонов
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(inputNumbers.getHomeNumber());
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(inputNumbers.getMobileNumber());
        wd.findElement(By.name("work")).click();
        wd.findElement(By.name("work")).clear();
        wd.findElement(By.name("work")).sendKeys(inputNumbers.getWorkNumber());
        wd.findElement(By.name("fax")).click();
        wd.findElement(By.name("fax")).clear();
        wd.findElement(By.name("fax")).sendKeys(inputNumbers.getFaxNumber());
    }

    public void inputAddress(String address) {
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(address);
    }

    public void inputCompany(String company) {
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(company);
    }

    public void inputTitle(String title) {
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).clear();
        wd.findElement(By.name("title")).sendKeys(title);
    }

    public void inputNickname(String nickname) {
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(nickname);
    }

    public void inputFirstMiddleLastName(InputNames inputNames) { //Ввод ФИО
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(inputNames.getFirstName());
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(inputNames.getMiddleName());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(inputNames.getThirdName());
    }

    public void createNewUser() {
        wd.findElement(By.linkText("add new")).click();
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

    public void allertAccept() {
        wd.switchTo().alert().accept();
    }

    public void delete() {
        wd.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    public void choseFirstCheckBox() {
        wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input")).click();
    }

    public void homepageTopBar() {
        wd.get("http://localhost/addressbook/");
    }
}
