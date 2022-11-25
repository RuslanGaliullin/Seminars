package org.example;

public abstract class Employee {
    protected int salary;
    protected int maxSalary;
    protected String secondName;
    protected String firstName;
    final String company = "RusTrust.inc";

    protected abstract String talk();

    protected abstract void setSalary();

    protected abstract String getReport();

    abstract int getSalary();

    public Employee(String secondName, String firstName) {
        this.secondName = secondName;
        this.firstName = firstName;
    }
}
