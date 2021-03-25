package ru.quest.lect3.model;

public class ContactData {
    private int id;
    private final String firstName;
    private final String middleName;
    private final String thirdName;
    private final String firstEmail;
    private final String secondEmail;
    private final String thirdEmail;
    private final String bDayDay;
    private final String bDayMonth;
    private final String bDayYear;
    private final String aDayDay;
    private final String aDayMonth;
    private final String aDayYear;
    private final String homeNumber;
    private final String mobileNumber;
    private final String workNumber;
    private final String faxNumber;
    private final String secondAddress;
    private final String secondAddressHomeNumber;
    private final String notes;
    private final String nickname;
    private final String title;
    private final String homepage;
    private final String company;
    private final String address;
    private String group;




    public ContactData(int id, String firstName, String middleName, String thirdName, String firstEmail, String secondEmail, String thirdEmail, String bDayDay, String bDayMonth, String bDayYear, String aDayDay, String aDayMonth, String aDayYear, String homeNumber, String mobileNumber, String workNumber, String faxNumber, String secondAddress, String secondAddressHomeNumber, String notes, String nickname, String title, String homepage, String company, String address, String group) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.thirdName = thirdName;
        this.firstEmail = firstEmail;
        this.secondEmail = secondEmail;
        this.thirdEmail = thirdEmail;
        this.bDayDay = bDayDay;
        this.bDayMonth = bDayMonth;
        this.bDayYear = bDayYear;
        this.aDayDay = aDayDay;
        this.aDayMonth = aDayMonth;
        this.aDayYear = aDayYear;
        this.homeNumber = homeNumber;
        this.mobileNumber = mobileNumber;
        this.workNumber = workNumber;
        this.faxNumber = faxNumber;
        this.secondAddress = secondAddress;
        this.secondAddressHomeNumber = secondAddressHomeNumber;
        this.notes = notes;
        this.nickname = nickname;
        this.title = title;
        this.homepage = homepage;
        this.company = company;
        this.address = address;
        this.group = group;
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

    public void setId(int id) {
        this.id = id;
    }

    public ContactData(String firstName, String middleName, String thirdName, String firstEmail, String secondEmail, String thirdEmail, String bDayDay, String bDayMonth, String bDayYear, String aDayDay, String aDayMonth, String aDayYear, String homeNumber, String mobileNumber, String workNumber, String faxNumber, String secondAddress, String secondAddressHomeNumber, String notes, String nickname, String title, String homepage, String company, String address, String group) {
        this.id = 0;
        this.firstName = firstName;
        this.middleName = middleName;
        this.thirdName = thirdName;
        this.firstEmail = firstEmail;
        this.secondEmail = secondEmail;
        this.thirdEmail = thirdEmail;
        this.bDayDay = bDayDay;
        this.bDayMonth = bDayMonth;
        this.bDayYear = bDayYear;
        this.aDayDay = aDayDay;
        this.aDayMonth = aDayMonth;
        this.aDayYear = aDayYear;
        this.homeNumber = homeNumber;
        this.mobileNumber = mobileNumber;
        this.workNumber = workNumber;
        this.faxNumber = faxNumber;
        this.secondAddress = secondAddress;
        this.secondAddressHomeNumber = secondAddressHomeNumber;
        this.notes = notes;
        this.nickname = nickname;
        this.title = title;
        this.homepage = homepage;
        this.company = company;
        this.address = address;
        this.group = group;
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

