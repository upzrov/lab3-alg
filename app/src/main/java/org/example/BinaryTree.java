package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    class Node {

        Student data;
        Node right;
        Node left;

        Node(Student data) {
            this.data = data;
        }
    }

    private Node root;

    public BinaryTree() {
        root = null;
    }

    public void add(Student student) {
        root = insert(root, student);
    }

    private Node insert(Node current, Student student) {
        if (current == null) {
            return new Node(student);
        } else {
            if (student.studentId < current.data.studentId) {
                current.left = insert(current.left, student);
            } else if (student.studentId > current.data.studentId) {
                current.right = insert(current.right, student);
            }
        }
        return current;
    }

    public ArrayList<Student> find(int year, boolean armyService) {
        ArrayList<Student> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        search(root, year, armyService, list);
        return list;
    }

    private void search(
        Node current,
        int year,
        boolean armyService,
        ArrayList<Student> list
    ) {
        if (current == null) {
            return;
        }
        search(current.left, year, armyService, list);

        if (
            current.data.year == year &&
            current.data.servedInArmy == armyService
        ) {
            list.add(current.data);
        }

        search(current.right, year, armyService, list);
    }

    public void removeByCriteria(int year, boolean armyService) {
        ArrayList<Student> toDelete = find(year, armyService);

        if (toDelete.isEmpty()) {
            System.out.println("Вузлів для видалення не знайдено.");
            return;
        }

        for (Student s : toDelete) {
            root = deleteNode(root, s.studentId);
        }
    }

    private Node deleteNode(Node current, int id) {
        if (current == null) return null;

        if (id < current.data.studentId) {
            current.left = deleteNode(current.left, id);
        } else if (id > current.data.studentId) {
            current.right = deleteNode(current.right, id);
        } else {
            // Node found
            if (current.right == null && current.left == null) {
                return null;
            } else if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            } else {
                current.right = replaceNode(current, current.right);
            }
        }
        return current;
    }

    private Node replaceNode(Node deleteNode, Node current) {
        if (current.left != null) {
            current.left = replaceNode(deleteNode, current.left);
        } else {
            deleteNode.data = current.data;
            current = current.right;
        }
        return current;
    }

    @Override
    public String toString() {
        if (root == null) {
            return "Дерево порожнє!";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(
            String.format(
                "%-15s %-10s %-5s %-15s %-10s\n",
                "Прізвище",
                "Ім'я",
                "Курс",
                "Студентський",
                "Армія"
            )
        );
        sb.append("------------------------------------------------------\n");

        // BFS traversal for string representation
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            sb.append(current.data.toString()).append("\n");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return sb.toString();
    }
}
