package ru.quest.lect3.tests;

import org.testng.annotations.Test;
import ru.quest.lect3.model.ContactData;
import ru.quest.lect3.model.Contacts;
import ru.quest.lect3.model.GroupData;
import ru.quest.lect3.model.Groups;

import java.sql.*;

public class DbConnectionTest {

    @Test
    public void testDbConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");
            Statement stGroups = conn.createStatement();
            ResultSet rsGroups = stGroups.executeQuery("select group_id,group_name,group_header,group_footer from group_list");
            Groups groups = new Groups();
            while (rsGroups.next()) {
                groups.add(new GroupData().withId(rsGroups.getInt("group_id")).withName(rsGroups.getString("group_name")).withHeader(rsGroups.getString("group_header")).withFooter(rsGroups.getString("group_footer")));
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");
            Statement stContacts = conn.createStatement();
            ResultSet rsContacts = stContacts.executeQuery("select user_id,firstname,lastname from users");
            Contacts contacts = new Contacts();
            while (rsContacts.next()) {
                contacts.add(new ContactData().withId(rsContacts.getInt("user_id")).withFirstName(rsContacts.getString("firstname")).withLastName(rsContacts.getString("lastname")));
            }
            rsContacts.close();
            rsGroups.close();
            stGroups.close();
            stContacts.close();
            conn.close();
            System.out.println(groups);
            System.out.println(contacts);
            // Do something with the Connection

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
