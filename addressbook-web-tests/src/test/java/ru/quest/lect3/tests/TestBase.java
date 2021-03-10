package ru.quest.lect3.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.quest.lect3.appmanager.ApplicationManager;
import ru.quest.lect3.model.*;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
