package ru.quest.lect3.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.quest.lect3.appmanager.TestBase;
import ru.quest.lect3.model.GroupData;

import java.util.List;

public class GroupModificationTests extends TestBase {


    @Test
    public void testGroupModification () {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();

        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", null, null));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

    }
}
