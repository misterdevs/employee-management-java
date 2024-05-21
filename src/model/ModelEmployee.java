package model;

import java.util.List;

import entities.person.Employee;

public class ModelEmployee {
    private List<Employee> employees;

    public ModelEmployee(List<Employee> employees) {
        this.employees = employees;
    }

    public void createEmployee(Employee employee) {
        employees.add(employee);
    }

    public void updateEmployee(Employee oldEmployee, Employee employee) {
        employees.set(employees.indexOf(oldEmployee), employee);
    }

    public void deleteEmployee(Employee employee) {
        employees.remove(employees.indexOf(employee));
    }

}
