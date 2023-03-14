import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        List<Student> students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i) )
                .collect(Collectors.toList());
        Collections.shuffle(students);

        List<Project> projects = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Project("S" + i) )
                .collect(Collectors.toList());
        Collections.shuffle(projects);

        
        List<Student> studentList = students.stream().sorted(Student::compareTo).collect(Collectors.toList());
        System.out.println(studentList);

        Set<Project> projectSet = new TreeSet<>(projects);
        System.out.println(projectSet);
    }

}
