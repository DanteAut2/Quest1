package ru.quest.lect3.model;

public class InputEmails {
    private final String firstEmail;
    private final String secondEmail;
    private final String thirdEmail;

    public InputEmails(String firstEmail, String secondEmail, String thirdEmail) {
        this.firstEmail = firstEmail;
        this.secondEmail = secondEmail;
        this.thirdEmail = thirdEmail;
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
}
