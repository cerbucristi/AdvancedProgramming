public class Student implements Comparable<Student>{
    private String studentName;

    public Student(String studentName) {
        this.studentName = studentName;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
