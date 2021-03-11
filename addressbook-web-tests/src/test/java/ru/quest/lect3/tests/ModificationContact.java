package ru.quest.lect3.tests;

import org.testng.annotations.Test;
import ru.quest.lect3.appmanager.TestBase;
import ru.quest.lect3.model.ContactData;

public class ModificationContact extends TestBase {

    @Test
    public void testContactModification() {
        app.contactHelper.homepageTopBar();
        app.contactHelper.choseFirstCheckBox();
        app.contactHelper.editContacktButton();
        app.contactHelper.inputAllContactInfo(new ContactData("asdfas", "gdfagfa", "dsgdgf", "gdfgsd", "gdsgdsg", "gsddfgsd", "15","April","1984","12", "May","1974", "4563456", "24564"," 345634", "236456" ," dsfggdf" ,"gsdfgsdf", " dsgsd", "sdrgsdfg","gdsgdf","sdgdsg", "sdfgsdfg", "gsdfgsdf"));
        app.contactHelper.updateNewInfo();
    }
}
