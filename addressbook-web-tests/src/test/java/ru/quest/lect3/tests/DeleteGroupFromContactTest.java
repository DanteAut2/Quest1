package ru.quest.lect3.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.quest.lect3.appmanager.TestBase;
import ru.quest.lect3.model.ContactData;
import ru.quest.lect3.model.Contacts;
import ru.quest.lect3.model.GroupData;
import ru.quest.lect3.model.Groups;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class DeleteGroupFromContactTest extends TestBase {

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

    public void testContactRemoveFromGroup() {

        ContactData contact = selectContact();
        GroupData groupContactToRemovedFrom = selectGroup(contact);
        Groups before = contact.getGroups();
        app.goTo().homePage();
        app.contact().selectGroupFromList(groupContactToRemovedFrom.getId());
        app.contact().removeContactFromGroup(contact, groupContactToRemovedFrom);

        ContactData contactsAfter = selectContactById(contact);
        Groups after = contactsAfter.getGroups();
        assertThat(after, equalTo(before.without(groupContactToRemovedFrom)));
    }

    private ContactData selectContactById(ContactData contact) {
        Contacts contactsById = app.db().contacts();
        return contactsById.iterator().next().withId(contact.getId());
    }


    private GroupData selectGroup(ContactData removeContact) {

        ContactData contact = selectContactById(removeContact);
        Groups removedContact = contact.getGroups();
        return removedContact.iterator().next();

    }

    private ContactData selectContact() {
        Contacts allContacts = app.db().contacts();
        for (ContactData contact : allContacts) {
            if (contact.getGroups().size() > 0) {
                return contact;
            }
        }

        ContactData addContact = app.db().contacts().iterator().next();
        app.contact().addContactToGroup(addContact, app.db().groups().iterator().next());
        return addContact;
    }
}
