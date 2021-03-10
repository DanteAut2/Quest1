package ru.quest.lect3.tests;

import org.testng.annotations.Test;
import ru.quest.lect3.appmanager.TestBase;
import ru.quest.lect3.model.*;

public class ContactCreationTests extends TestBase {

    @Test
    public void creatingNewUser() throws Exception { //Главный список действий
        app.contactHelper.createNewUser();
        app.contactHelper.inputFirstMiddleLastName(new InputNames("krutoy", "perec", "vashe"));
        app.contactHelper.inputNickname("Bukovi");
        app.contactHelper.inputTitle("Piwu Titlu");
        app.contactHelper.inputCompany("Kompaniu Piwu");
        app.contactHelper.inputAddress("4to eto za mesto");
        app.contactHelper.homeMobileWorkFaxNumber(new InputNumbers("11111", "22222", "33333", "44444"));
        app.contactHelper.inputEmails(new InputEmails("sfjsdjfsf", "dfiojgfiodsjf", "fdhsfhsdf"));
        app.contactHelper.inputHomepage("sdgsdfghdfhfdsfg");
        app.contactHelper.inputBdayAday(new InputDates("14", "April", "1984", "24", "May", "1994"));
        app.contactHelper.InputSecondary(new InputSecondarys("ulica pishkina", "dom kolotushkina", "4toto eshe"));
        app.contactHelper.confirm();
        app.contactHelper.homepage();
        app.contactHelper.logout();
    }
}