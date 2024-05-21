package entities.person;

import entities.salary.MinSalary;
import interfaces.IEmployeeWithAllowance;
import utilities.Utility;

public class Analyst extends Employee implements IEmployeeWithAllowance {
    private int allowance;

    // auto-generate id config
    private Utility utility;
    private String idPattern = "AL-000";

    public Analyst(String id, String name, String address, int age, String jobDesc, MinSalary placement) {
        super(name, address, age, jobDesc, placement);
        setId(id);
        this.utility = new Utility();
        calculateSalary();
        calculateAllowance();
    }

    public Analyst(String name, String address, int age, String jobDesc,
            MinSalary placement) {
        super(name, address, age, jobDesc, placement);
        this.utility = new Utility();
        calculateSalary();
        calculateAllowance();
    }

    public int getAllowance() {
        return allowance;
    }

    public void calculateAllowance() {
        int ratePercentage = 5;
        this.allowance = getSalary() * ratePercentage / 100;
    }

    @Override
    public void generateId(int idNumber) {
        setId(utility.createIdPattern(this.idPattern, idNumber++));
    }

    @Override
    public void calculateSalary() {
        int ratePercentage = 160;
        setSalary(getPlacement().getSalary() * ratePercentage / 100);
    }

    @Override
    public String toString() {
        return "[" + getId() + "," + getName() + "," + getAddress() + "," + getAge() + "," + getJobDesc() + ","
                + getPlacement() + "," + this.allowance + "," + getSalary() + "]";

    }

}
