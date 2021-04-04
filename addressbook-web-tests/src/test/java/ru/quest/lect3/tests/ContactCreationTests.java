package ru.quest.lect3.tests;

import org.testng.annotations.Test;
import ru.quest.lect3.appmanager.TestBase;
import ru.quest.lect3.model.ContactData;
import ru.quest.lect3.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void creatingNewUser() throws Exception {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        app.contact().createNewUser();
        File photo = new File("src/test/resources/stru.png");
        ContactData contact = new ContactData().withFirstName("dsfsd").withMiddleName("gfdsfsd").withLastName("fsdfsdd").withNickname("dsgdsg").withTitle("gsdfghsd").withCompany("sdfgsdf").withAddress("fsdfs").withFirstEmail("gfdsf").withSecondEmail("gdsjkfs").withThirdEmail("fjsdfj").withbDayDay("11").withbDayMonth("May").withbDayYear("1996").withaDayDay("12").withaDayMonth("June").withaDayYear("1994").withHomeNumber("45345").withMobileNumber("5436534").withWorkNumber("63463").withFaxNumber("345734").withSecondAddress("hfshs").withSecondAddressHomeNumber("6435634").withNotes("gdgsd").withHomepage("gdsdfgs").withGroup("test1").withPhoto(photo);
        app.contact().create(contact, true);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    @Test
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/stru.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}