package ru.quest.lect3.tests;

import org.testng.annotations.Test;
import ru.quest.lect3.tests.TestBase;

public class DeleteContact extends TestBase {


    @Test
    public void testDeleteContact() throws Exception {

        homepageTopBar();
        choseFirstCheckBox();
        delete();
        allertAccept();
        logout();
    }
}
