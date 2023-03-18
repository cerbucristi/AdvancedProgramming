import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        List<Project> projects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project("P" + i) )
                .collect(Collectors.toList());
        Collections.shuffle(projects);

        List<Student> students = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student("S" + i) )
                .collect(Collectors.toList());
        Collections.shuffle(students);

        List<Student> studentList = students.stream().sorted(Student::compareTo).collect(Collectors.toList());
        System.out.println(studentList);

        Set<Project> projectSet = new TreeSet<>(projects);
        System.out.println(projectSet);


        students.get(0).setProjectPreferences(projects);
        students.get(1).setProjectPreferences(Arrays.asList(projects.get(0), projects.get(1)));
        students.get(2).setProjectPreferences(Collections.singletonList(projects.get(2)));

        Problem problem1 = new Problem(students);
        List<Student> preferenceNumberLower = problem1.getStudents().stream().filter(student -> student.getProjectPreferences().size() < problem1.getAverageNumberOfProjects()).collect(Collectors.toList());
        System.out.println(preferenceNumberLower);

        Faker faker = new Faker();

        String firstName = faker.name().firstName();

        List<Project> fakerProjects = IntStream.rangeClosed(0, 9)
                .mapToObj(i -> new Project(faker.app().name()))
                .collect(Collectors.toList());

        List<Student> fakerStudents = IntStream.rangeClosed(0, 9)
                .mapToObj(i -> new Student(faker.name().firstName()) )
                .collect(Collectors.toList());

        Random random = new Random();

        //generating random project lists for students
        fakerStudents.forEach(student -> {
            for(int i = 0; i < random.nextInt(fakerProjects.size()) + 1; i++) {
                student.addProject(fakerProjects.get(random.nextInt(fakerProjects.size())));
            }
        });

        Problem fakerProblem = new Problem(fakerStudents);

        System.out.println(fakerProblem);

        GreedyAlgorithmSolution algorithmSolution = new GreedyAlgorithmSolution(fakerProblem);
        algorithmSolution.allocateProjects().forEach((k,v) -> {
            System.out.println(k + " -> " + v + "\n");
        });
    }

}
