package ru.quest.lect3.model;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private String firstName;
    private String middleName;
    private String thirdName;
    private String firstEmail;
    private String secondEmail;
    private String thirdEmail;
    private String bDayDay;
    private String bDayMonth;
    private String bDayYear;
    private String aDayDay;
    private String aDayMonth;
    private String aDayYear;
    private String homeNumber;
    private String mobileNumber;
    private String workNumber;
    private String faxNumber;
    private String secondAddress;
    private String secondAddressHomeNumber;
    private String notes;
    private String nickname;
    private String title;
    private String homepage;
    private String company;




    private String address;
    private String group;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return thirdName != null ? thirdName.equals(that.thirdName) : that.thirdName == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
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

    public ContactData withThirdName(String thirdName) {
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

    public ContactData withGroup(String group) {
        this.group = group;
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

    public String getTitle() { return title; }

    public String getHomepage() { return homepage; }

    public String getCompany() { return company; }

    public String getAddress() { return address; }

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

    public String getNickname() { return nickname; }

    public int getId() {
        return id;
    }

    public String getGroup() {
        return group;
    }

}

