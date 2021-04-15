package ru.quest.lect3.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.quest.lect3.appmanager.TestBase;
import ru.quest.lect3.model.ContactData;
import ru.quest.lect3.model.Contacts;
import ru.quest.lect3.model.GroupData;
import ru.quest.lect3.model.Groups;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactAddToGroupTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws IOException {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
        app.goTo().homePage();
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactData().withFirstName("dsfsd").withMiddleName("gfdsfsd").withLastName("fsdfsdd")
                    .withNickname("dsgdsg").withTitle("gsdfghsd").withCompany("sdfgsdf").withAddress("fsdfs").withFirstEmail("gfdsf")
                    .withSecondEmail("gdsjkfs").withThirdEmail("fjsdfj").withbDayDay("11").withbDayMonth("May").withbDayYear("1996")
                    .withaDayDay("12").withaDayMonth("June").withaDayYear("1994").withHomeNumber("45345").withMobileNumber("5436534")
                    .withWorkNumber("63463").withFaxNumber("345734").withSecondAddress("hfshs").withSecondAddressHomeNumber("6435634")
                    .withNotes("gdgsd").withHomepage("gdsdfgs"), true);
        }
    }

    @Test
    public void testContactAddToGroup() throws IOException {
        app.goTo().homePage();
        ContactData addContact = selectContact();
        GroupData groupContactToBeAddedTo = selectGroup(addContact);
        Groups before = addContact.getGroups();
        app.goTo().homePage();
        app.contact().addContactToGroup(addContact, groupContactToBeAddedTo);
        app.goTo().homePage();
        ContactData addContactAfter = selectContactById(addContact);
        Groups after = addContactAfter.getGroups();
        assertThat(after, equalTo(before.withAdded(groupContactToBeAddedTo)));
    }

    private ContactData selectContactById(ContactData addContact) {
        Contacts contactsById = app.db().contacts();
        return contactsById.iterator().next().withId(addContact.getId());
    }

    private GroupData selectGroup(ContactData contact) {
        Groups allGroups = app.db().groups();
        Groups contactsInGroups = contact.getGroups();

        Collection<GroupData> contactGroups = new HashSet<>(contactsInGroups);
        Collection<GroupData> avaliableGroups = new HashSet<>(allGroups);
        avaliableGroups.removeAll(contactGroups);
        return avaliableGroups.iterator().next();
    }

    private ContactData selectContact() throws IOException {

        Contacts allContacts = app.db().contacts();
        Groups allGroups = app.db().groups();
        for (ContactData contact : allContacts) {
            if (contact.getGroups().size() < allGroups.size()) {
                return contact;
            }
        }
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("group created by test").withHeader("header for group from test"));
        return allContacts.iterator().next();
    }
}

