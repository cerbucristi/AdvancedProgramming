import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Designer extends Person {

    private List<String> designSoftware;
    private int yearsOfUIUXExperience;

    public Designer(String strPersonName, LocalDate birthDate, List<String> designSoftware, int yearsOfUIUXExperience) {
        super(strPersonName, birthDate);
        this.designSoftware = designSoftware;
        this.yearsOfUIUXExperience = yearsOfUIUXExperience;
    }

    @Override
    public String getOccupation() {
        return "Designer";
    }

    public List<String> getDesignSoftware() {
        return designSoftware;
    }

    public void setDesignSoftware(List<String> designSoftware) {
        this.designSoftware = designSoftware;
    }

    public int getYearsOfUIUXExperience() {
        return yearsOfUIUXExperience;
    }

    public void setYearsOfUIUXExperience(int yearsOfUIUXExperience) {
        this.yearsOfUIUXExperience = yearsOfUIUXExperience;
    }
}
