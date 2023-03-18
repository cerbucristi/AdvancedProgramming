import java.util.*;
import java.util.stream.Collectors;

public class GreedyAlgorithmSolution {
    private Problem problem;

    public GreedyAlgorithmSolution(Problem problem) {
        this.problem = problem;
    }

    public Map<Student, Project> allocateProjects() {
        Map<Student, Project> studentProjectMap = new HashMap<>();
        Set<Project> allocatedProjects = new HashSet<>();
        List<Student> students = problem.getStudents();
        //sort list of students by the number of projects required
        students.sort(Comparator.comparingInt(student -> student.getProjectPreferences().size()));
        for (Student student : students) {
            for (Project project : student.getProjectPreferences()) {
                if (!allocatedProjects.contains(project) && !studentProjectMap.containsKey(student)) {
                    studentProjectMap.put(student, project);
                    allocatedProjects.add(project);
                }
            }
        }

        return studentProjectMap;
    }


    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }
}
