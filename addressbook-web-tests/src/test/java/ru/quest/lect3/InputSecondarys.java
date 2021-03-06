package ru.quest.lect3;

public class InputSecondarys {
    private final String secondAddress;
    private final String secondAddressHomeNumber;
    private final String notes;

    public InputSecondarys(String secondAddress, String secondAddressHomeNumber, String notes) {
        this.secondAddress = secondAddress;
        this.secondAddressHomeNumber = secondAddressHomeNumber;
        this.notes = notes;
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
}
