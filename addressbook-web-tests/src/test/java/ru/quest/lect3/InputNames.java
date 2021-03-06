package ru.quest.lect3;

public class InputNames {
    private final String firstName;
    private final String middleName;
    private final String thirdName;

    public InputNames(String firstName, String middleName, String thirdName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.thirdName = thirdName;
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
}
