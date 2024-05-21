package entities.person;

import entities.salary.MinSalary;
import interfaces.IEmployee;
import interfaces.IMember;
import utilities.Utility;

public class Employee extends Person implements IMember, IEmployee {
    private String id;
    private String jobDesc;
    private int salary;
    private MinSalary placement;

    // auto-generate id config
    private Utility utility;
    private String idPattern = "Emp-000";

    public Employee(String id, String name, String address, int age, String jobDesc, MinSalary placement) {
        super(name, address, age);
        this.id = id;
        this.jobDesc = jobDesc;
        this.placement = placement;
        this.utility = new Utility();
        calculateSalary();
    }

    public Employee(String name, String address, int age, String jobDesc,
            MinSalary placement) {
        super(name, address, age);
        this.jobDesc = jobDesc;
        this.placement = placement;
        this.utility = new Utility();
        calculateSalary();
    }

    public String getId() {
        return id;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public int getSalary() {
        return salary;
    }

    public MinSalary getPlacement() {
        return placement;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setPlacement(MinSalary placement) {
        this.placement = placement;
    }

    public void calculateSalary() {
        int ratePercentage = 100;
        this.salary = this.placement.getSalary() * ratePercentage / 100;
    }

    public void generateId(int idNumber) {
        this.id = utility.createIdPattern(this.idPattern, idNumber++);
    }

    @Override
    public String toString() {
        return "[" + this.id + "," + getName() + "," + getAddress() + "," + getAge() + "," + this.jobDesc + ","
                + this.placement + "," + this.salary + "]";
    }

}
