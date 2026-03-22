package org.example;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.add(new Student("Дмитренко", "Юрій", 3, 100, false));
        tree.add(new Student("Бойко", "Арсеній", 5, 50, true));
        tree.add(new Student("Івашко", "Іван", 1, 30, false));
        tree.add(new Student("Сич", "Станіслав", 2, 70, false));
        tree.add(new Student("Безушко", "Марія", 4, 150, false));
        tree.add(new Student("Домашенко", "Кирило", 5, 120, true));
        tree.add(new Student("Рекул", "Каріна", 2, 130, false));
        tree.add(new Student("Барановський", "Артем", 5, 180, true));
        System.out.println(tree);

        System.out.println(
            "\nПошук студентів 5-го курсу, які служили в армії:"
        );
        ArrayList<Student> found = tree.find(5, true);
        if (found.isEmpty()) {
            System.out.println("Студентів за заданим критерієм не знайдено.");
        } else {
            System.out.println(
                String.format(
                    "%-15s %-10s %-5s %-15s %-10s",
                    "Прізвище",
                    "Ім'я",
                    "Курс",
                    "Студентський",
                    "Армія"
                )
            );
            System.out.println(
                "------------------------------------------------------"
            );
            for (Student s : found) {
                System.out.println(s.toString());
            }
        }

        System.out.println("\n");
        tree.removeByCriteria(5, true);
        System.out.println("Вміст дерева після видалення знайдених вузлів:");
        System.out.println(tree);
    }
}
