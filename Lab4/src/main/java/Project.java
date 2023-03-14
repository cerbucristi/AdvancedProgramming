public class Project implements Comparable<Project>{
    private String projectName;

    public Project(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public int compareTo(Project o) {
        return this.projectName.compareTo(o.projectName);
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                '}';
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
