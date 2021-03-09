package ru.quest.lect3;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.quest.lect3.tests.TestBase;

public class ContactCreationTests extends TestBase {

    @Test
    public void creatingNewUser() throws Exception { //Главный список действий
        createNewUser();
        inputFirstMiddleLastName(new InputNames("krutoy", "perec", "vashe"));
        inputNickname("Bukovi");
        inputTitle("Piwu Titlu");
        inputCompany("Kompaniu Piwu");
        inputAddress("4to eto za mesto");
        homeMobileWorkFaxNumber(new InputNumbers("11111", "22222", "33333", "44444"));
        inputEmails(new InputEmails("sfjsdjfsf", "dfiojgfiodsjf", "fdhsfhsdf"));
        inputHomepage("sdgsdfghdfhfdsfg");
        inputBdayAday(new InputDates("14", "April", "1984", "24", "May", "1994"));
        InputSecondary(new InputSecondarys("ulica pishkina", "dom kolotushkina", "4toto eshe"));
        confirm();
        homepage();
        logout();
    }
}