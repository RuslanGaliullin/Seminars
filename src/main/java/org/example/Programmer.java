package org.example;

public class Programmer extends Employee implements IsGradable {
    private Integer linesOfCode;
    protected Integer grade;

    public Programmer(String secondName, String firstName, Integer lines) {
        super(secondName, firstName);
        grade = 1;
        linesOfCode = lines;
        maxSalary = 500000;
        salary = 60000;
    }

    @Override
    protected String talk() {
        return "i am a Programmer.";
    }

    @Override
    protected void setSalary() {
        salary = (int) Math.min(maxSalary, Math.pow(1.1, grade) * salary);
    }

    private void writeLines(Integer lines) {
        linesOfCode += lines;
    }

    @Override
    protected String getReport() {
        return "I have written " + linesOfCode + " lines of code";
    }

    @Override
    int getSalary() {
        return salary;
    }

    @Override
    public void countGrade() {
        grade = (linesOfCode % 1000 + linesOfCode % 13) % 10;
    }
}
