package org.example;

public class Manager extends org.example.Employee implements IsGradable {
    private Integer numOfDeadlines;
    protected int grade;

    public Manager(String secondName, String firstName) {
        super(secondName, firstName);
        maxSalary = 120000;
        salary = 60000;
        grade = 1;
    }

    public Manager(String secondName, String firstName, Integer numOfDeadlines) {
        super(secondName, firstName);
        maxSalary = 120000;
        salary = 60000;
        this.numOfDeadlines = numOfDeadlines;
    }

    @Override
    protected String talk() {
        return "I am a Manager.";
    }

    protected void setSalary() {
        salary = (int) Math.min(maxSalary, Math.pow(1.1, grade) * salary);
    }

    @Override
    protected String getReport() {
        return "We have to do " + numOfDeadlines + " projects";
    }

    @Override
    int getSalary() {
        return salary;
    }

    public void countGrade() {
        grade = (numOfDeadlines * 31 + numOfDeadlines % 13) % 10;
    }
}
