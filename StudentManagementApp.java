import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Student {
    private final int rollNumber;
    private String name;
    private String grade;

    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
    }

    public int getRollNumber() { return rollNumber; }
    public String getName() { return name; }
    public String getGrade() { return grade; }
    public void setName(String name) { this.name = name; }
    public void setGrade(String grade) { this.grade = grade; }

    @Override
    public String toString() {
        return "Roll No: " + rollNumber + " | Name: " + name + " | Grade: " + grade;
    }
}

class StudentManagementSystem {
    private final List<Student> students = new ArrayList<>();

    public boolean rollExists(int rollNumber) {
        return findByRoll(rollNumber) != null;
    }

    public void addStudent(Student newStudent) {
        if (rollExists(newStudent.getRollNumber())) {
            System.out.println("A student with roll " + newStudent.getRollNumber() + " already exists.");
            return;
        }
        students.add(newStudent);
        System.out.println("Student added successfully!");
    }

    public void removeStudent(int rollNumber) {
        boolean removed = false;
        for (Iterator<Student> it = students.iterator(); it.hasNext();) {
            Student s = it.next();
            if (s.getRollNumber() == rollNumber) {
                it.remove();
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student with Roll No " + rollNumber + " not found.");
        }
    }

    public Student findByRoll(int rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) return s;
        }
        return null;
    }

    public void searchStudent(int rollNumber) {
        Student s = findByRoll(rollNumber);
        if (s == null) {
            System.out.println("Student with Roll No " + rollNumber + " not found.");
        } else {
            System.out.println("Student found: " + s);
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\nStudent List (" + students.size() + "):");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void editStudent(int rollNumber, String newName, String newGrade) {
        Student s = findByRoll(rollNumber);
        if (s == null) {
            System.out.println("Student with Roll No " + rollNumber + " not found.");
            return;
        }
        s.setName(newName);
        s.setGrade(newGrade);
        System.out.println("Student details updated successfully!");
    }
}

public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Edit Student");
            System.out.println("6. Exit");

            int choice = readInt(scanner, "Enter your choice: ");

            switch (choice) {
                case 1 -> {
                    int roll = readPositiveInt(scanner, "Enter Roll Number: ");
                    String name = readNonEmpty(scanner, "Enter Name: ");
                    String grade = readNonEmpty(scanner, "Enter Grade: ");
                    sms.addStudent(new Student(roll, name, grade));
                }
                case 2 -> {
                    int rollToRemove = readPositiveInt(scanner, "Enter Roll Number to remove: ");
                    sms.removeStudent(rollToRemove);
                }
                case 3 -> {
                    int rollToSearch = readPositiveInt(scanner, "Enter Roll Number to search: ");
                    sms.searchStudent(rollToSearch);
                }
                case 4 -> sms.displayAllStudents();
                case 5 -> {
                    int rollToEdit = readPositiveInt(scanner, "Enter Roll Number to edit: ");
                    String newName = readNonEmpty(scanner, "Enter New Name: ");
                    String newGrade = readNonEmpty(scanner, "Enter New Grade: ");
                    sms.editStudent(rollToEdit, newName, newGrade);
                }
                case 6 -> {
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // ---- Input helpers (fix nextInt/nextLine issues & add validation) ----
    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static int readPositiveInt(Scanner sc, String prompt) {
        while (true) {
            int value = readInt(sc, prompt);
            if (value > 0) return value;
            System.out.println("Value must be positive.");
        }
    }

    private static String readNonEmpty(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String text = sc.nextLine().trim();
            if (!text.isEmpty()) return text;
            System.out.println("This field cannot be empty.");
        }
    }
}