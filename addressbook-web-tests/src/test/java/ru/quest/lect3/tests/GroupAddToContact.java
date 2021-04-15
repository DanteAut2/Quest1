package ru.quest.lect3.tests;

import org.testng.annotations.BeforeMethod;
import ru.quest.lect3.appmanager.TestBase;
import ru.quest.lect3.model.GroupData;

import java.io.IOException;

public class GroupAddToContact extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws IOException {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
    }
}
