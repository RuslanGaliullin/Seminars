package org.example;

import java.util.ArrayList;
import java.util.List;

public class Secretary extends Employee {
    private List<String> unreadMessages = new ArrayList<>();

    public Secretary(String secondName, String firstName, List<String> unreadMessages) {
        super(secondName, firstName);
        this.unreadMessages = unreadMessages;
        maxSalary = 90000;
        salary = 60000;
    }

    public Secretary(String secondName, String firstName) {
        super(secondName, firstName);
        maxSalary = 90000;
        salary = 60000;
    }

    @Override
    protected String talk() {
        return "I am a Secretary.";
    }

    @Override
    protected void setSalary() {
    }

    public void addMessage(String message) {
        unreadMessages.add(message);
    }

    @Override
    protected String getReport() {
        return "you have " + unreadMessages.size() + " unread messages.";
    }

    @Override
    int getSalary() {
        return salary;
    }
}
