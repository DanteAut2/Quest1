package ru.quest.lect3.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.quest.lect3.appmanager.TestBase;
import ru.quest.lect3.model.ContactData;

public class ModificationContact extends TestBase {

    @Test
    public void testContactModification() {
        app.contactHelper.homepageTopBar();
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("asdfas", "gdfagfa", "dsgdgf", "gdfgsd", "gdsgdsg", "gsddfgsd", "15","April","1984","12", "May","1974", "4563456", "24564"," 345634", "236456" ," dsfggdf" ,"gsdfgsdf", " dsgsd", "sdrgsdfg","gdsgdf","sdgdsg", "sdfgsdfg", "gsdfgsdf", "test1"), true);
        }
        app.contactHelper.choseCheckBox(before - 1);
        app.contactHelper.editContacktButton();
        app.contactHelper.inputAllContactInfo(new ContactData("asdfas", "gdfagfa", "dsgdgf", "gdfgsd", "gdsgdsg", "gsddfgsd", "15","April","1984","12", "May","1974", "4563456", "24564"," 345634", "236456" ," dsfggdf" ,"gsdfgsdf", " dsgsd", "sdrgsdfg","gdsgdf","sdgdsg", "sdfgsdfg", "gsdfgsdf", null), false);
        app.contactHelper.updateNewInfo();
        app.contactHelper.homepageTopBar();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
    }
}
