package org.example;

public class Student {

    String Surname;
    String Name;
    int Year;
    int Stud_ID; // tree key
    boolean ArmyService;

    Student(
        String Surname,
        String Name,
        int Year,
        int Stud_ID,
        boolean ArmyService
    ) {
        this.Surname = Surname;
        this.Name = Name;
        this.Year = Year;
        this.Stud_ID = Stud_ID;
        this.ArmyService = ArmyService;
    }

    @Override
    public String toString() {
        return String.format(
            "%-15s %-10s %-5d %-15d %-10s",
            Surname,
            Name,
            Year,
            Stud_ID,
            ArmyService ? "Так" : "Ні"
        );
    }
}
