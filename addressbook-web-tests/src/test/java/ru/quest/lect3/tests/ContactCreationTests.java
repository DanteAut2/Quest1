package ru.quest.lect3.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.quest.lect3.appmanager.TestBase;
import ru.quest.lect3.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void creatingNewUser() throws Exception {
        app.goTo().homePage();
        Set<ContactData> before = app.contact().all();
        app.contact().createNewUser();
        ContactData contact = new ContactData().withFirstName("dsfsd").withMiddleName("gfdsfsd").withThirdName("fsdfsdd").withNickname("dsgdsg").withTitle("gsdfghsd").withCompany("sdfgsdf").withAddress("fsdfs").withFirstEmail("gfdsf").withSecondEmail("gdsjkfs").withThirdEmail("fjsdfj").withbDayDay("11").withbDayMonth("May").withbDayYear("1996").withaDayDay("12").withaDayMonth("June").withaDayYear("1994").withHomeNumber("45345").withMobileNumber("5436534").withWorkNumber("63463").withFaxNumber("345734").withSecondAddress("hfshs").withSecondAddressHomeNumber("6435634").withNotes("gdgsd").withHomepage("gdsdfgs").withGroup("test1");
        app.contact().inputAllContactInfo(contact, true);
        app.contact().confirm();
        app.contact().homepage();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);

    }
}