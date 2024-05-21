package entities.person;

import entities.salary.MinSalary;
import interfaces.IEmployeeWithAllowance;
import utilities.Utility;

public class Programmer extends Employee implements IEmployeeWithAllowance {
    private String progLanguage;
    private int experience;
    private int allowance;

    // auto-generate id config
    private Utility utility;
    private String idPattern = "Prog-000";

    public Programmer(String id, String name, String address, int age, String jobDesc, MinSalary placement,
            String progLanguage, int experience) {
        super(name, address, age, jobDesc, placement);
        this.progLanguage = progLanguage;
        this.experience = experience;
        setId(id);
        this.utility = new Utility();
        calculateSalary();
        calculateAllowance();
    }

    public Programmer(String name, String address, int age, String jobDesc,
            MinSalary placement,
            String progLanguage, int experience) {
        super(name, address, age, jobDesc, placement);
        this.progLanguage = progLanguage;
        this.experience = experience;
        this.utility = new Utility();
        calculateSalary();
        calculateAllowance();
    }

    public String getProgLanguage() {
        return progLanguage;
    }

    public int getExperience() {
        return experience;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setProgLanguage(String progLanguage) {
        this.progLanguage = progLanguage;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void calculateAllowance() {
        int ratePercentage = this.experience >= 5 ? 20 : 10;
        this.allowance = getSalary() * ratePercentage / 100;
    }

    @Override
    public void generateId(int idNumber) {
        setId(utility.createIdPattern(this.idPattern, idNumber++));
    }

    @Override
    public void calculateSalary() {
        int ratePercentage = 150;
        setSalary(getPlacement().getSalary() * ratePercentage / 100);

    }

    @Override
    public String toString() {
        return "[" + getId() + "," + getName() + "," + getAddress() + "," + getAge() + "," + getJobDesc() + ","
                + getPlacement() + "," + this.progLanguage + "," + this.experience + "," + this.allowance + ","
                + getSalary() + "]";

    }

}
