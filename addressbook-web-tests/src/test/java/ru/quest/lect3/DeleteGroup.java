package ru.quest.lect3;

import org.testng.annotations.Test;

public class DeleteGroup extends TestBase {

    @Test
    public void testDeleteGroup() throws Exception {
        gotoGroupPage();
        selectGroup();
        deleteSelectedGroups();
        returnToGroupPage();
        logout();
    }

}
