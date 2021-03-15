package ru.quest.lect3.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import sun.plugin2.util.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver wd;

    private SessionHelper sessioonHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    public ContactHelper contactHelper;
    private int browser;

    public ApplicationManager(int browser) {
        this.browser = browser;
    }


    public void init() {
        if (browser == BrowserType.MOZILLA) {
            wd = new FirefoxDriver();
        } else if (browser == BrowserType.DEFAULT) {
            wd = new ChromeDriver();
        } else if (browser == BrowserType.INTERNET_EXPLORER) {
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/index.php");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessioonHelper = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        sessioonHelper.login("admin", "secret");
    }


    public void stop() {
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


    public void logout() {
        wd.findElement(By.linkText("Logout")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
