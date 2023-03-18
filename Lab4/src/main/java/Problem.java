import java.util.List;
import java.util.stream.Collectors;

public class Problem {

    private List<Student> students;

    public double getAverageNumberOfProjects () {
        double average = 0;

        for(Student student : students) {
            average += student.getProjectPreferences().size();
        }

        return average / students.size();
    }
    public Problem(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Problem : \n" + students.stream().map(Student::getStudentProprieties).collect(Collectors.toList());
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
