package ru.quest.lect3.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.quest.lect3.model.ContactData;
import ru.quest.lect3.model.Contacts;
import ru.quest.lect3.model.GroupData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


    private final ApplicationManager app;
    private Contacts contactCache = null;

    public ContactHelper(ApplicationManager app) {
        super(app.wd);
        this.app = app; // сохраняем ссылку на менеджера в помощнике
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

    public void inputAllContactInfo(ContactData contactData, boolean creation) throws IOException {
        type(By.name(app.getProperty("web.locatorFirstName")), contactData.getFirstName());
        type(By.name(app.getProperty("web.locatorMiddleName")), contactData.getMiddleName());
        type(By.name(app.getProperty("web.locatorLastname")), contactData.getThirdName());
        type(By.name(app.getProperty("web.locatorNickname")), contactData.getNickname());
        type(By.name(app.getProperty("web.locatorTitle")), contactData.getTitle());
        type(By.name(app.getProperty("web.locatorCompany")), contactData.getCompany());
        type(By.name(app.getProperty("web.locatorAddress")), contactData.getAddress());
        type(By.name(app.getProperty("web.locatorHome")), contactData.getHomeNumber());
        type(By.name(app.getProperty("web.locatorMobile")), contactData.getMobileNumber());
        type(By.name(app.getProperty("web.locatorWork")), contactData.getWorkNumber());
        type(By.name(app.getProperty("web.locatorFax")), contactData.getFaxNumber());
        type(By.name(app.getProperty("web.locatorEmail")), contactData.getFirstEmail());
        type(By.name(app.getProperty("web.locatorEmail2")), contactData.getSecondEmail());
        type(By.name(app.getProperty("web.locatorEmail3")), contactData.getThirdEmail());
        type(By.name(app.getProperty("web.locatorHomepage")), contactData.getHomepage());
        type(By.name(app.getProperty("web.locatorAddress2")), contactData.getSecondAddress());
        type(By.name(app.getProperty("web.locatorPhone2")), contactData.getSecondAddressHomeNumber());
        type(By.name(app.getProperty("web.locatorNotes")), contactData.getNotes());
        attach(By.name("photo"), contactData.getPhoto());

        if (creation) {
            if (contactData.getGroups().size() > 0) {
                Assert.assertTrue(contactData.getGroups().size() == 1);
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
            }
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

    public void create(ContactData contact, boolean b) throws IOException {
        createNewUser();
        inputAllContactInfo(contact, b);
        confirm();
        contactCache = null;
        homepage();
    }

    public void modify(ContactData contact) throws IOException {
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
        String firstname = wd.findElement(By.name(app.getProperty("web.locatorFirstName"))).getAttribute("value");
        String lastname = wd.findElement(By.name(app.getProperty("web.locatorLastname"))).getAttribute("value");
        String home = wd.findElement(By.name(app.getProperty("web.locatorHome"))).getAttribute("value");
        String mobile = wd.findElement(By.name(app.getProperty("web.locatorMobile"))).getAttribute("value");
        String work = wd.findElement(By.name(app.getProperty("web.locatorWork"))).getAttribute("value");
        String secondHome = wd.findElement(By.name(app.getProperty("web.locatorPhone2"))).getAttribute("value");
        String address = wd.findElement(By.name(app.getProperty("web.locatorAddress"))).getAttribute("value");
        String firstEmail = wd.findElement(By.name(app.getProperty("web.locatorEmail"))).getAttribute("value");
        String secondEmail = wd.findElement(By.name(app.getProperty("web.locatorEmail2"))).getAttribute("value");
        String thirdEmail = wd.findElement(By.name(app.getProperty("web.locatorEmail3"))).getAttribute("value");

        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname).withHomeNumber(home).withMobileNumber(mobile).withWorkNumber(work).withSecondAddressHomeNumber(secondHome).withAddress(address).withFirstEmail(firstEmail).withSecondEmail(secondEmail).withThirdEmail(thirdEmail);
    }

    private void initContactModificationById(int id) {

        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s'", id))).click();
    }

    public void selectContactCheckbox(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectContactCheckboxById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void addContactToGroup(ContactData contactData, GroupData groupData) {

        selectContactCheckboxById(contactData.getId());
        selectGroupFromListToAdd(groupData.getId());
        addToGroupButton();
        goToGroupPageAfterAddingRemovingContact();
        contactCache = null;
    }

    private void addToGroupButton() {
        wd.findElement(By.name("add")).click();
    }

    public void goToGroupPageAfterAddingRemovingContact() {
        wd.findElement(By.partialLinkText("group page")).click();
        //wd.findElement(By.cssSelector(String.format("a[href='./?group=%s']", id))).click();
    }

    public void selectGroupFromListToAdd(int groupId) {
        new Select(wd.findElement(By.name("to_group"))).selectByValue(String.valueOf(groupId));
    }
}
