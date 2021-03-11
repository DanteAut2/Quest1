package ru.quest.lect3.tests;

import org.testng.annotations.Test;
import ru.quest.lect3.appmanager.TestBase;
import ru.quest.lect3.model.InputNames;

public class ModificationContact extends TestBase {

    @Test
    public void testContactModification() {
        app.contactHelper.homepageTopBar();
        app.contactHelper.choseFirstCheckBox();
        app.contactHelper.editContacktButton();
        app.contactHelper.inputFirstMiddleLastName(new InputNames("lol", "kek", "cheburek"));
        app.contactHelper.updateNewInfo();
    }
}
