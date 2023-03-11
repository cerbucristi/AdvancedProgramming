public class Company implements Node, Comparable<Company> {

    private String strCompanyName;

    public Company(String strCompanyName) {
        this.strCompanyName = strCompanyName;
    }

    @Override
    public String getName() {
        return this.strCompanyName;
    }

    @Override
    public int compareTo(Company anotherCompany) {
        return this.strCompanyName.compareTo(anotherCompany.strCompanyName);
    }

    @Override
    public String toString() {
        return "Company{" +
                "strCompanyName='" + strCompanyName + '\'' +
                '}';
    }

    public String getStrCompanyName() {
        return strCompanyName;
    }

    public void setStrCompanyName(String strCompanyName) {
        this.strCompanyName = strCompanyName;
    }
}
