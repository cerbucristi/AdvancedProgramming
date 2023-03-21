import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Student implements Node, Comparable<Student>{
    private String studentName;
    private List<Project> projectPreferences;

    public Student(String studentName, List<Project> projectPreferences) {
        this.studentName = studentName;
        this.projectPreferences = projectPreferences;
    }

    public Student(String studentName) {
        this.studentName = studentName;
        projectPreferences = new ArrayList<>();
    }

    public void addProject (Project project) {
        projectPreferences.add(project);
    }

    @Override
    public String getName() {
        return studentName;
    }

    @Override
    public int compareTo(Student o) {
        return this.studentName.compareTo(o.studentName);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                '}';
    }


    public String getStudentProprieties () {
        return studentName + " -> " + projectPreferences.stream().map(Project::getProjectName).collect(Collectors.toList()) + "\n";
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Project> getProjectPreferences() {
        return projectPreferences;
    }

    public void setProjectPreferences(List<Project> projectPreferences) {
        this.projectPreferences = projectPreferences;
    }

}
