package ru.quest.lect3.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.quest.lect3.appmanager.TestBase;
import ru.quest.lect3.model.ContactData;
import ru.quest.lect3.model.Contacts;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContact extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws IOException {
        app.contact().homepageTopBar();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData().withFirstName("dsfsd").withMiddleName("gfdsfsd").withLastName("fsdfsdd")
                    .withNickname("dsgdsg").withTitle("gsdfghsd").withCompany("sdfgsdf").withAddress("fsdfs").withFirstEmail("gfdsf")
                    .withSecondEmail("gdsjkfs").withThirdEmail("fjsdfj").withbDayDay("11").withbDayMonth("May").withbDayYear("1996")
                    .withaDayDay("12").withaDayMonth("June").withaDayYear("1994").withHomeNumber("45345").withMobileNumber("5436534")
                    .withWorkNumber("63463").withFaxNumber("345734").withSecondAddress("hfshs").withSecondAddressHomeNumber("6435634")
                    .withNotes("gdgsd").withHomepage("gdsdfgs").withGroup("test1"), true);
        }
    }

    @Test
    public void testDeleteContact() throws Exception {

        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(deletedContact)));
    }
}
