package ru.quest.lect3.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.quest.lect3.appmanager.TestBase;
import ru.quest.lect3.model.ContactData;

import java.util.List;

public class DeleteContact extends TestBase {


    @Test
    public void testDeleteContact() throws Exception {

        app.contactHelper.homepageTopBar();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("asdfas", "gdfagfa", "dsgdgf", "gdfgsd", "gdsgdsg", "gsddfgsd", "15","April","1984","12", "May","1974", "4563456", "24564"," 345634", "236456" ," dsfggdf" ,"gsdfgsdf", " dsgsd", "sdrgsdfg","gdsgdf","sdgdsg", "sdfgsdfg", "gsdfgsdf", "test1"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.contactHelper.choseCheckBox(before.size() - 1);
        app.contactHelper.delete();
        app.contactHelper.allertAccept();
        app.contactHelper.homepageTopBar();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);
        app.contactHelper.logout();
    }
}
