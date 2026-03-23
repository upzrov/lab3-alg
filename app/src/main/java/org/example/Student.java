package org.example;

public class Student {

    String surname;
    String name;
    int year;
    int studentId; // tree key
    boolean servedInArmy;

    Student(
        String surname,
        String name,
        int year,
        int studentId,
        boolean servedInArmy
    ) {
        this.surname = surname;
        this.name = name;
        this.year = year;
        this.studentId = studentId;
        this.servedInArmy = servedInArmy;
    }

    @Override
    public String toString() {
        return String.format(
            "%-15s %-10s %-5d %-15d %-10s",
            surname,
            name,
            year,
            studentId,
            servedInArmy ? "Так" : "Ні"
        );
    }
}
