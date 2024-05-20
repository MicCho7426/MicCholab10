package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = readStudentsFromFile("students.json");

        Student highestAverageStudent = null;
        double highestAverage = 0.0;

        for (Student student : students) {
            double averageGrade = student.calculateAverageGrade();
            System.out.println(student.getName() + " (" + student.getMajor() + "): Average grade = " + averageGrade);

            if (averageGrade > highestAverage) {
                highestAverage = averageGrade;
                highestAverageStudent = student;
            }
        }

        if (highestAverageStudent != null) {
            System.out.println("Student with the highest average grade: " + highestAverageStudent.getName() + " (" + highestAverageStudent.getMajor() + ") with an average of " + highestAverage);
        }
    }

    private static List<Student> readStudentsFromFile(String resourceName) {
        try (Reader reader = new InputStreamReader(Main.class.getClassLoader().getResourceAsStream(resourceName), "UTF-8")) {
            Gson gson = new Gson();
            Type studentListType = new TypeToken<List<Student>>(){}.getType();
            return gson.fromJson(reader, studentListType);
        } catch (Exception e) {
            System.err.println("Error reading from resource file: " + e.getMessage());
            return null;
        }
    }
}
