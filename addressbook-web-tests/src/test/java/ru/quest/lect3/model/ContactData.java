package ru.quest.lect3.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "addressbook")
public class ContactData {

    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;
    @Expose
    @Column(name = "firstname")
    private String firstName;
    @Expose
    @Transient
    private String middleName;
    @Expose
    @Column(name = "lastname")
    private String thirdName;
    @Expose
    @Transient
    private String firstEmail;
    @Expose
    @Transient
    private String secondEmail;
    @Expose
    @Transient
    private String thirdEmail;
    @Expose
    @Transient
    private String bDayDay;
    @Transient
    private String bDayMonth;
    @Transient
    private String bDayYear;
    @Transient
    private String aDayDay;
    @Transient
    private String aDayMonth;
    @Transient
    private String aDayYear;
    @Expose
    @Column(name = "home")
    @Type(type = "text")
    private String homeNumber;
    @Expose
    @Column(name = "mobile")
    @Type(type = "text")
    private String mobileNumber;
    @Expose
    @Column(name = "work")
    @Type(type = "text")
    private String workNumber;
    @Expose
    @Transient
    private String faxNumber;
    @Expose
    @Transient
    private String secondAddress;
    @Expose
    @Transient
    private String secondAddressHomeNumber;
    @Expose
    @Transient
    private String notes;
    @Expose
    @Transient
    private String nickname;
    @Expose
    @Transient
    private String title;
    @Expose
    @Transient
    private String homepage;
    @Expose
    @Transient
    private String company;
    @Transient
    private String allPhones;
    @Transient
    private String allEmails;
    @Expose
    @Transient
    private String address;

    @Column(name = "photo")
    @Type(type = "text")
    private String photo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();

    public File getPhoto() {
        if (photo != null) {
            return new File(photo);
        } else {
            return null;
        }
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }


    public String getAllEmails() {
        return allEmails;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return thirdName != null ? thirdName.equals(that.thirdName) : that.thirdName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (thirdName != null ? thirdName.hashCode() : 0);
        return result;
    }


    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;

    }

    public ContactData withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;

    }

    public ContactData withLastName(String thirdName) {
        this.thirdName = thirdName;
        return this;

    }

    public ContactData withFirstEmail(String firstEmail) {
        this.firstEmail = firstEmail;
        return this;

    }

    public ContactData withSecondEmail(String secondEmail) {
        this.secondEmail = secondEmail;
        return this;

    }

    public ContactData withThirdEmail(String thirdEmail) {
        this.thirdEmail = thirdEmail;
        return this;

    }

    public ContactData withbDayDay(String bDayDay) {
        this.bDayDay = bDayDay;
        return this;

    }

    public ContactData withbDayMonth(String bDayMonth) {
        this.bDayMonth = bDayMonth;
        return this;

    }

    public ContactData withbDayYear(String bDayYear) {
        this.bDayYear = bDayYear;
        return this;

    }

    public ContactData withaDayDay(String aDayDay) {
        this.aDayDay = aDayDay;
        return this;

    }

    public ContactData withaDayMonth(String aDayMonth) {
        this.aDayMonth = aDayMonth;
        return this;

    }

    public ContactData withaDayYear(String aDayYear) {
        this.aDayYear = aDayYear;
        return this;

    }

    public ContactData withHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
        return this;

    }

    public ContactData withMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;

    }

    public ContactData withWorkNumber(String workNumber) {
        this.workNumber = workNumber;
        return this;

    }

    public ContactData withFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
        return this;

    }

    public ContactData withSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
        return this;

    }

    public ContactData withSecondAddressHomeNumber(String secondAddressHomeNumber) {
        this.secondAddressHomeNumber = secondAddressHomeNumber;
        return this;

    }

    public ContactData withNotes(String notes) {
        this.notes = notes;
        return this;

    }

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;

    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;

    }

    public ContactData withHomepage(String homepage) {
        this.homepage = homepage;
        return this;

    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;

    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;

    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", thirdName='" + thirdName + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public String getFirstEmail() {
        return firstEmail;
    }

    public String getSecondEmail() {
        return secondEmail;
    }

    public String getThirdEmail() {
        return thirdEmail;
    }

    public String getbDayDay() {
        return bDayDay;
    }

    public String getbDayMonth() {
        return bDayMonth;
    }

    public String getbDayYear() {
        return bDayYear;
    }

    public String getaDayDay() {
        return aDayDay;
    }

    public String getaDayMonth() {
        return aDayMonth;
    }

    public String getaDayYear() {
        return aDayYear;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public String getSecondAddressHomeNumber() {
        return secondAddressHomeNumber;
    }

    public String getNotes() {
        return notes;
    }

    public String getNickname() {
        return nickname;
    }

    public int getId() {
        return id;
    }

    public Groups getGroups() {
        return new Groups(groups);
    }

    public ContactData inGroup(GroupData group) {
        groups.add(group);
        return this;
    }
}

