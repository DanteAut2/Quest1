package ru.quest.lect3.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.quest.lect3.appmanager.TestBase;
import ru.quest.lect3.model.GroupData;

public class GroupModificationTests extends TestBase {


    @Test
    public void testGroupModification () {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
        }
        app.getGroupHelper().selectGroup(before - 1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", null, null));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);

    }
}
