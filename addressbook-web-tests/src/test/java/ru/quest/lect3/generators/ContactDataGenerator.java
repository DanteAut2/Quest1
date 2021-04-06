package ru.quest.lect3.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.quest.lect3.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        save(contacts, new File(file));
    }


    private static void save(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstName(), contact.getMiddleName(), contact.getThirdName(), contact.getNickname(), contact.getTitle(),
                    contact.getCompany(), contact.getAddress(), contact.getHomeNumber(), contact.getMobileNumber(), contact.getWorkNumber(), contact.getFaxNumber(), contact.getFirstEmail(), contact.getSecondEmail(),
                    contact.getThirdEmail(), contact.getHomepage(), contact.getSecondAddress(), contact.getSecondAddressHomeNumber(), contact.getNotes(), contact.getGroup()));
        }
        writer.close();
    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData().withFirstName(String.format("firstname %s", i)).withMiddleName(String.format("middlename %s", i)).withLastName(String.format("lastname %s", i)).withNickname(String.format("nickname %s", i)).withTitle(String.format("title %s", i))
            .withCompany(String.format("company %s", i)).withAddress(String.format("address %s", i)).withHomeNumber(String.format("88005553535 %s", i)).withMobileNumber(String.format("123123 %s", i)).withWorkNumber(String.format("3452335 %s", i)).withFaxNumber(String.format("4666666 %s", i))
            .withFirstEmail(String.format("email111 %s", i)).withSecondEmail(String.format("email222 %s", i)).withThirdEmail(String.format("email333 %s", i)).withHomepage(String.format("homepage %s", i)).withSecondEmail(String.format("secondemail %s", i))
            .withSecondAddress(String.format("secondaddress %s", i)).withSecondAddressHomeNumber(String.format("1245325 %s", i)).withNotes(String.format("notes %s", i)).withGroup(String.format("test%s", i)).withPhoto(new File(String.format("src/test/resources/stru.png"))));
        }
        return contacts;
    }
}
