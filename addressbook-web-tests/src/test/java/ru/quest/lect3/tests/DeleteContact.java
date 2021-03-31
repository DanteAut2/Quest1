package ru.quest.lect3.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.quest.lect3.appmanager.TestBase;
import ru.quest.lect3.model.ContactData;

import java.util.List;

public class DeleteContact extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.contact().homepageTopBar();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData().withFirstName("dsfsd").withMiddleName("gfdsfsd").withThirdName("fsdfsdd").withNickname("dsgdsg").withTitle("gsdfghsd").withCompany("sdfgsdf").withAddress("fsdfs").withFirstEmail("gfdsf").withSecondEmail("gdsjkfs").withThirdEmail("fjsdfj").withbDayDay("11").withbDayMonth("May").withbDayYear("1996").withaDayDay("12").withaDayMonth("June").withaDayYear("1994").withHomeNumber("45345").withMobileNumber("5436534").withWorkNumber("63463").withFaxNumber("345734").withSecondAddress("hfshs").withSecondAddressHomeNumber("6435634").withNotes("gdgsd").withHomepage("gdsdfgs").withGroup("test1"), true);
        }
    }

    @Test
    public void testDeleteContact() throws Exception {

        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().delete(index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);


    }

}
