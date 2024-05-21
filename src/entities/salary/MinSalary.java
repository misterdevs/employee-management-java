package entities.salary;

public class MinSalary {
    private String city;
    private int salary;

    public MinSalary() {

    }

    public MinSalary(String city, int salary) {
        this.city = city;
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public int getSalary() {
        return salary;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString() {
        return "[" + this.city + "," + this.salary + "]";
    }
}
