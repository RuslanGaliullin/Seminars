package org.example;

public class Main {
    public static int fib(int n) {
        int a = 0, b = 1, zap;
        if (n <= 2)
            return 1;
        while (n != 0) {
            zap = a;
            a = b;
            b = a + zap;
            --n;
        }
        return a;
    }

    public static int fact(int n) {
        int a = 1;
        for (int i = 1; i <= n; ++i) {
            a *= i;
        }
        return a;
    } // Забыл что надо было факториал или фибоначи, поэтому написал оба

    public static void main(String[] args) {
        Employee[] workers = {new Manager("a", "b", 100), new Programmer("a", "b", 2000), new Secretary("a", "b")};
        for (Employee worker : workers) {
            System.out.println(worker.talk());
            System.out.println("My salary was " + worker.getSalary());
            if (worker instanceof IsGradable) {
                ((IsGradable) worker).countGrade();
                worker.setSalary();

            }
            System.out.println("My salary is " + worker.getSalary());
            System.out.println();
        }
        System.out.println(fib(4));
        System.out.println(fact(4));
    }

}