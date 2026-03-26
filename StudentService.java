import java.util.*;

class StudentService {
    List<Student> students = new ArrayList<>();

    // Constructor (load data)
    StudentService() {
        try {
            students = FileHandler.loadFromFile();
        } catch (Exception e) {
            System.out.println("Error loading data");
        }
    }

    void addStudent(Student s) {
        students.add(s);
        save();
    }

    void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found");
            return;
        }
        for (Student s : students) {
            System.out.println("ID: " + s.id + " Name: " + s.name + " Marks: " + s.marks);
        }
    }

    void deleteStudent(int id) {
        students.removeIf(s -> s.id == id);
        save();
    }

    void searchStudent(int id) {
        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Found: " + s.name + " " + s.marks);
                return;
            }
        }
        System.out.println("Student not found");
    }

    void sortByMarks() {
        if (students.isEmpty()) {
            System.out.println("No students to sort");
            return;
        }

        students.sort((a, b) -> Double.compare(b.marks, a.marks));

        System.out.println("\n--- Students Sorted by Marks ---");
        viewStudents();
    }

    void save() {
        try {
            FileHandler.saveToFile(students);
        } catch (Exception e) {
            System.out.println("Error saving data");
        }
    }
}