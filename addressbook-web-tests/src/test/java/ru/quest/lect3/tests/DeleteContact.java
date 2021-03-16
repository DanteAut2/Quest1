package ru.quest.lect3.tests;

import org.testng.annotations.Test;
import ru.quest.lect3.appmanager.TestBase;
import ru.quest.lect3.model.ContactData;

public class DeleteContact extends TestBase {


    @Test
    public void testDeleteContact() throws Exception {

        app.contactHelper.homepageTopBar();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("asdfas", "gdfagfa", "dsgdgf", "gdfgsd", "gdsgdsg", "gsddfgsd", "15","April","1984","12", "May","1974", "4563456", "24564"," 345634", "236456" ," dsfggdf" ,"gsdfgsdf", " dsgsd", "sdrgsdfg","gdsgdf","sdgdsg", "sdfgsdfg", "gsdfgsdf", "test1"), true);
        }
        app.contactHelper.choseFirstCheckBox();
        app.contactHelper.delete();
        app.contactHelper.allertAccept();
        app.contactHelper.logout();
    }
}
