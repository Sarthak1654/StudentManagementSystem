import java.io.*;
import java.util.*;

class FileHandler {

    static final String FILE_NAME = "students.txt";

    // Save students to file
    public static void saveToFile(List<Student> students) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));
        for (Student s : students) {
            bw.write(s.toString());
            bw.newLine();
        }
        bw.close();
    }

    // Load students from file
    public static List<Student> loadFromFile() throws IOException {
        List<Student> students = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) return students;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            students.add(new Student(
                Integer.parseInt(data[0]),
                data[1],
                Double.parseDouble(data[2])
            ));
        }

        br.close();
        return students;
    }
}
