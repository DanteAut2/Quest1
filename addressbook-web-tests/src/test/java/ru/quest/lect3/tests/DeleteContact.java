package ru.quest.lect3.tests;

import org.testng.annotations.Test;

public class DeleteContact extends TestBase {


    @Test
    public void testDeleteContact() throws Exception {

        app.contactHelper.homepageTopBar();
        app.contactHelper.choseFirstCheckBox();
        app.contactHelper.delete();
        app.contactHelper.allertAccept();
        app.contactHelper.logout();
    }
}
