package org.example;

import java.util.ArrayList;
import java.util.List;

public class Executive extends Manager {
    List<Programmer> programmersInTeam = new ArrayList<>();

    public Executive(String secondName, String firstName, List<Programmer> team) {
        super(secondName, firstName);
        programmersInTeam.addAll(team);
    }

    private void checkWork() {
        if (programmersInTeam.size() > 0) {
            for (Programmer i : programmersInTeam) {
                i.getReport();
            }
        }
    }

    @Override
    protected void setSalary() {
        salary = (int) Math.min(maxSalary, Math.pow(1.1, grade) * salary);
    }

    @Override
    public void countGrade() {
        super.countGrade();
        grade += (programmersInTeam.size() * 31) % 101;
    }
}
