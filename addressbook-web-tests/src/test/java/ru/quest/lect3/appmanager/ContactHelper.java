package ru.quest.lect3.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.quest.lect3.model.ContactData;
import ru.quest.lect3.model.Contacts;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void homepage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public void confirm() {
        wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }


    public void createNewUser() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void inputAllContactInfo(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getThirdName());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomeNumber());
        type(By.name("mobile"), contactData.getMobileNumber());
        type(By.name("work"), contactData.getWorkNumber());
        type(By.name("fax"), contactData.getFaxNumber());
        type(By.name("email"), contactData.getFirstEmail());
        type(By.name("email2"), contactData.getSecondEmail());
        type(By.name("email3"), contactData.getThirdEmail());
        type(By.name("homepage"), contactData.getHomepage());
        type(By.name("bday"), contactData.getbDayDay());
        type(By.name("bmonth"), contactData.getbDayMonth());
        type(By.name("byear"), contactData.getbDayYear());
        type(By.name("aday"), contactData.getaDayDay());
        type(By.name("amonth"), contactData.getaDayMonth());
        type(By.name("ayear"), contactData.getaDayYear());
        type(By.name("address2"), contactData.getSecondAddress());
        type(By.name("phone2"), contactData.getSecondAddressHomeNumber());
        type(By.name("notes"), contactData.getNotes());
        attach(By.name("photo"), contactData.getPhoto());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
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

    public void choseCheckBox(int indexContact) {
        wd.findElements(By.name("selected[]")).get(indexContact).click();
    }

    public void choseCheckBoxById(int id) {
        wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
    }

    public void homepageTopBar() {
        wd.get("http://localhost/addressbook/");
    }

    public void editContacktButtonById(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s'", id))).click();
    }

    public void updateNewInfo() {
        click(By.name("update"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void create(ContactData contact, boolean b) {
        createNewUser();
        inputAllContactInfo(contact, b);
        confirm();
        contactCache = null;
        homepage();
    }

    public void modify(ContactData contact) {
        choseCheckBoxById(contact.getId());
        editContacktButtonById(contact.getId());
        inputAllContactInfo(contact, false);
        updateNewInfo();
        contactCache = null;
        homepageTopBar();
    }

    public void delete(ContactData contact) {
        choseCheckBoxById(contact.getId());
        delete();
        allertAccept();
        contactCache = null;
        homepageTopBar();
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath(".//*[@id='maintable']/tbody/tr"));
        elements.remove(0);
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String firstName = cells.get(2).getText();
            String lastName = cells.get(1).getText();

            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
        }
        return contacts;
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath(".//*[@id='maintable']/tbody/tr"));
        elements.remove(0);
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String firstName = cells.get(2).getText();
            String lastName = cells.get(1).getText();
            String allPhones = cells.get(5).getText();
            String address = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contactCache.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName).withAllPhones(allPhones).withAddress(address).withAllEmails(allEmails));
        }
        return new Contacts(contactCache);
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String secondHome = wd.findElement(By.name("phone2")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String firstEmail = wd.findElement(By.name("email")).getAttribute("value");
        String secondEmail = wd.findElement(By.name("email2")).getAttribute("value");
        String thirdEmail = wd.findElement(By.name("email3")).getAttribute("value");

        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname).withHomeNumber(home).withMobileNumber(mobile).withWorkNumber(work).withSecondAddressHomeNumber(secondHome).withAddress(address).withFirstEmail(firstEmail).withSecondEmail(secondEmail).withThirdEmail(thirdEmail);
    }

    private void initContactModificationById(int id) {
//        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
//        WebElement row = checkbox.findElement(By.xpath("./../.."));
//        List<WebElement> cells = row.findElements(By.tagName("td"));
//        cells.get(7).findElement(By.tagName("a")).click();


        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s'", id))).click();
    }
}
