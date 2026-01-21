import java.util.ArrayList;
import java.util.Collections;

public class Course {
  private String courseName;
  private ArrayList<String> students;
  private int numberOfStudents;

  public Course(String courseName) {
    this.courseName = courseName;
    students = new ArrayList<>();
    numberOfStudents = 0;
  }

  public void addStudent(String student) {
    students.add(student);
    numberOfStudents++;
  }

  public String[] getStudents() {
    return students.toArray(new String[students.size()]);
  }

  public int getNumberOfStudents() {
    return numberOfStudents;
  }

  public String getCourseName() {
    return courseName;
  }

  public void dropStudent(String student) {
    Collections.sort(students);
    if (students.contains(student)) {
      students.remove(students.indexOf(student));
    }
    numberOfStudents--;
  }
}
