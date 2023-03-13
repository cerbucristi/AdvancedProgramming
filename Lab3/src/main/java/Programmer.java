import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Programmer extends Person{

    private List<String> programmingLanguages;
    private boolean knowsAgile;

    public Programmer(String strPersonName, LocalDate birthDate, List<String> programmingLanguages, boolean knowsAgile) {
        super(strPersonName, birthDate);
        this.programmingLanguages = programmingLanguages;
        this.knowsAgile = knowsAgile;
    }

    @Override
    public String getOccupation() {
        return "Programmer";
    }

    public List<String> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(List<String> programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    public boolean isKnowsAgile() {
        return knowsAgile;
    }

    public void setKnowsAgile(boolean knowsAgile) {
        this.knowsAgile = knowsAgile;
    }
}
