package entities.person;

import entities.salary.MinSalary;
import interfaces.IEmployeeWithAllowance;
import utilities.Utility;

public class ProjectLeader extends Employee implements IEmployeeWithAllowance {
    private int totalProject;
    private int allowance;

    // auto-generate id config
    private Utility utility;
    private String idPattern = "PL-000";

    public ProjectLeader(String id, String name, String address, int age, String jobDesc, MinSalary placement,
            int totalProject) {
        super(name, address, age, jobDesc, placement);
        this.totalProject = totalProject;
        setId(id);
        this.utility = new Utility();
        calculateSalary();
        calculateAllowance();
    }

    public ProjectLeader(String name, String address, int age, String jobDesc,
            MinSalary placement,
            int totalProject) {
        super(name, address, age, jobDesc, placement);
        this.totalProject = totalProject;
        this.utility = new Utility();
        calculateSalary();
        calculateAllowance();
    }

    public int getTotalProject() {
        return totalProject;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setTotalProject(int totalProject) {
        this.totalProject = totalProject;
    }

    public void calculateAllowance() {
        int ratePercentage = this.totalProject >= 2 ? 15 : 5;
        this.allowance = getSalary() * ratePercentage / 100;
    }

    @Override
    public void generateId(int idNumber) {
        setId(utility.createIdPattern(this.idPattern, idNumber++));

    }

    @Override
    public void calculateSalary() {
        int ratePercentage = 200;
        setSalary(getPlacement().getSalary() * ratePercentage / 100);

    }

    @Override
    public String toString() {
        return "[" + getId() + "," + getName() + "," + getAddress() + "," + getAge() + "," + getJobDesc() + ","
                + getPlacement() + "," + this.totalProject + "," + this.allowance + "," + getSalary() + "]";

    }

}
