public class Person implements Node, Comparable<Person> {

    private String strPersonName;

    public Person(String strPersonName) {
        this.strPersonName = strPersonName;
    }

    @Override
    public String getName() {
        return this.strPersonName;
    }

    @Override
    public int compareTo(Person anotherPerson) {
        return this.strPersonName.compareTo(anotherPerson.strPersonName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "strPersonName='" + strPersonName + '\'' +
                '}';
    }

    public String getStrPersonName() {
        return strPersonName;
    }

    public void setStrPersonName(String strPersonName) {
        this.strPersonName = strPersonName;
    }


}
