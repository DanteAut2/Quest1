package ru.quest.lect3;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

    public class ContactCreationTests {
        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @BeforeClass(alwaysRun = true)
        public void setUp() throws Exception {
            driver = new FirefoxDriver();
            baseUrl = "https://www.google.com/";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @Test
        public void testUntitledTestCase() throws Exception {
            driver.get("http://localhost/addressbook/edit.php");
            driver.findElement(By.name("user")).clear();
            driver.findElement(By.name("user")).sendKeys("admin");
            driver.findElement(By.name("pass")).clear();
            driver.findElement(By.name("pass")).sendKeys("secret");
            driver.findElement(By.xpath("//input[@value='Login']")).click();
            driver.findElement(By.linkText("add new")).click();
            driver.findElement(By.name("firstname")).click();
            driver.findElement(By.name("firstname")).clear();
            driver.findElement(By.name("firstname")).sendKeys("Krutoy");
            driver.findElement(By.name("middlename")).click();
            driver.findElement(By.name("middlename")).clear();
            driver.findElement(By.name("middlename")).sendKeys("Perec");
            driver.findElement(By.name("lastname")).click();
            driver.findElement(By.name("lastname")).clear();
            driver.findElement(By.name("lastname")).sendKeys("Piwet");
            driver.findElement(By.name("nickname")).click();
            driver.findElement(By.name("nickname")).clear();
            driver.findElement(By.name("nickname")).sendKeys("Bukovi");
            driver.findElement(By.name("title")).click();
            driver.findElement(By.name("title")).clear();
            driver.findElement(By.name("title")).sendKeys("Piwu Titlu");
            driver.findElement(By.name("company")).click();
            driver.findElement(By.name("company")).clear();
            driver.findElement(By.name("company")).sendKeys("Kompaniu Piwu");
            driver.findElement(By.name("address")).click();
            driver.findElement(By.name("address")).clear();
            driver.findElement(By.name("address")).sendKeys("4to eto za mesto");
            driver.findElement(By.name("home")).click();
            driver.findElement(By.name("home")).clear();
            driver.findElement(By.name("home")).sendKeys("11111");
            driver.findElement(By.name("mobile")).click();
            driver.findElement(By.name("mobile")).clear();
            driver.findElement(By.name("mobile")).sendKeys("22222");
            driver.findElement(By.name("work")).click();
            driver.findElement(By.name("work")).clear();
            driver.findElement(By.name("work")).sendKeys("33333");
            driver.findElement(By.name("fax")).click();
            driver.findElement(By.name("fax")).clear();
            driver.findElement(By.name("fax")).sendKeys("44444");
            driver.findElement(By.name("email")).click();
            driver.findElement(By.name("email")).clear();
            driver.findElement(By.name("email")).sendKeys("sdfgsdfg@gdfg.ru");
            driver.findElement(By.name("email2")).clear();
            driver.findElement(By.name("email2")).sendKeys("dfjfdgddg@gdjf.ru");
            driver.findElement(By.name("email3")).clear();
            driver.findElement(By.name("email3")).sendKeys("jddfgjisdjfg@gdjfkjg.com");
            driver.findElement(By.name("homepage")).click();
            driver.findElement(By.name("homepage")).clear();
            driver.findElement(By.name("homepage")).sendKeys("sdgsdfghdfhfdsfg");
            driver.findElement(By.name("bday")).click();
            new Select(driver.findElement(By.name("bday"))).selectByVisibleText("16");
            driver.findElement(By.name("bday")).click();
            driver.findElement(By.name("bmonth")).click();
            new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("August");
            driver.findElement(By.name("bmonth")).click();
            driver.findElement(By.name("byear")).click();
            driver.findElement(By.name("byear")).clear();
            driver.findElement(By.name("byear")).sendKeys("1978");
            driver.findElement(By.name("aday")).click();
            new Select(driver.findElement(By.name("aday"))).selectByVisibleText("17");
            driver.findElement(By.name("aday")).click();
            driver.findElement(By.name("amonth")).click();
            new Select(driver.findElement(By.name("amonth"))).selectByVisibleText("May");
            driver.findElement(By.name("amonth")).click();
            driver.findElement(By.name("ayear")).click();
            driver.findElement(By.name("ayear")).clear();
            driver.findElement(By.name("ayear")).sendKeys("1980");
            driver.findElement(By.name("address2")).click();
            driver.findElement(By.name("address2")).clear();
            driver.findElement(By.name("address2")).sendKeys("vtoroi takoi");
            driver.findElement(By.name("phone2")).click();
            driver.findElement(By.name("phone2")).clear();
            driver.findElement(By.name("phone2")).sendKeys("49");
            driver.findElement(By.name("notes")).clear();
            driver.findElement(By.name("notes")).sendKeys("nu o4 bolshoy dvorec");
            driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
            driver.findElement(By.linkText("home page")).click();
            driver.findElement(By.linkText("Logout")).click();
        }

        @AfterClass(alwaysRun = true)
        public void tearDown() throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }

        private boolean isElementPresent(By by) {
            try {
                driver.findElement(by);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }

        private boolean isAlertPresent() {
            try {
                driver.switchTo().alert();
                return true;
            } catch (NoAlertPresentException e) {
                return false;
            }
        }

        private String closeAlertAndGetItsText() {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                if (acceptNextAlert) {
                    alert.accept();
                } else {
                    alert.dismiss();
                }
                return alertText;
            } finally {
                acceptNextAlert = true;
            }
        }
    }
