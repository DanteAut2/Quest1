package ru.quest.lect3.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.quest.lect3.appmanager.TestBase;
import ru.quest.lect3.model.*;

public class ContactCreationTests extends TestBase {

    @Test
    public void creatingNewUser() throws Exception {
        int before = app.getContactHelper().getContactCount();
        app.contactHelper.createNewUser();
        app.contactHelper.inputAllContactInfo(new ContactData("asdfas", "gdfagfa", "dsgdgf", "gdfgsd", "gdsgdsg", "gsddfgsd", "15","April","1984","12", "May","1974", "4563456", "24564"," 345634", "236456" ," dsfggdf" ,"gsdfgsdf", " dsgsd", "sdrgsdfg","gdsgdf","sdgdsg", "sdfgsdfg", "gsdfgsdf", "test1"), true);
        app.contactHelper.confirm();
        app.contactHelper.homepage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
        app.contactHelper.logout();
    }
}