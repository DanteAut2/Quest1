package ru.quest.lect3.tests;

import org.testng.annotations.BeforeMethod;
import ru.quest.lect3.appmanager.TestBase;
import ru.quest.lect3.model.GroupData;

import java.io.IOException;

public class ContactAddToGroupTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws IOException {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
    }
}
