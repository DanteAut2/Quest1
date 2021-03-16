package ru.quest.lect3.tests;

import org.testng.annotations.Test;
import ru.quest.lect3.appmanager.TestBase;

public class DeleteGroup extends TestBase {

    @Test
    public void testDeleteGroup() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        app.logout();
    }

}