package ru.quest.lect3.appmanager;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBase {

    protected static ApplicationManager app;

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }
}
