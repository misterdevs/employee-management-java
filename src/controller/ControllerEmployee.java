package controller;

import java.util.List;
import java.util.stream.Collectors;

import entities.person.Analyst;
import entities.person.Employee;
import entities.person.Programmer;
import entities.person.ProjectLeader;
import entities.salary.MinSalary;
import interfaces.IEmployeeWithAllowance;
import model.ModelEmployee;

public class ControllerEmployee {
    private List<Employee> employees;
    private ModelEmployee modelEmployee;
    private int employeeId = 4;
    private int programmerId = 4;
    private int projectLeaderId = 4;
    private int analystId = 4;

    public ControllerEmployee(List<Employee> employees) {
        this.employees = employees;
        this.modelEmployee = new ModelEmployee(employees);
    }

    public void createEmployee(int chosenMenu, String name, String address, int age, String jobDesc,
            MinSalary placement, String progLanguage, int experience, int totalProject) {
        switch (chosenMenu) {
            case 1:
                Employee employee = new Employee(name, address, age, jobDesc, placement);
                employee.generateId(employeeId++);
                modelEmployee.createEmployee(employee);
                break;
            case 2:
                Programmer programmer = new Programmer(name, address, age, jobDesc, placement, progLanguage,
                        experience);
                programmer.generateId(programmerId++);
                modelEmployee.createEmployee(programmer);
                break;
            case 3:
                ProjectLeader projectLeader = new ProjectLeader(name, address, age, jobDesc, placement, totalProject);
                projectLeader.generateId(projectLeaderId++);
                modelEmployee.createEmployee(projectLeader);
                break;
            case 4:
                Analyst analyst = new Analyst(name, address, age, jobDesc, placement);
                analyst.generateId(analystId++);
                modelEmployee.createEmployee(analyst);
                break;
            default:
                break;
        }
    }

    public void updateEmployee(Employee employee) {
        employee.calculateSalary();
        if (employee instanceof IEmployeeWithAllowance) {
            ((IEmployeeWithAllowance) employee).calculateAllowance();
        }
        modelEmployee.updateEmployee(findEmployeeById(employee.getId()), employee);
    }

    public void deleteEmployee(String id) {
        modelEmployee.deleteEmployee(findEmployeeById(id));
    }

    public List<Employee> findEmployeeByPlacementCity(String city) {
        return employees.stream().filter(employee -> employee.getPlacement().getCity().toLowerCase().contains(city))
                .collect(Collectors.toList());
    }

    public Employee findEmployeeById(String id) {
        return employees.stream().filter(employee -> employee.getId().equalsIgnoreCase(id))
                .findFirst().orElse(null);
    }

    public List<Employee> findEmployeesById(String id) {
        return employees.stream().filter(employee -> employee.getId().equalsIgnoreCase(id))
                .collect(Collectors.toList());
    }

    public Boolean isValidEmployeeId(String id) {
        return findEmployeeById(id) != null;
    }

    public int getTotalSalary() {
        return calculateAllAllowance() + calculateAllSalary();
    }

    public int calculateAllAllowance() {
        return employees.stream().filter(employee -> employee instanceof IEmployeeWithAllowance)
                .map(employee -> (IEmployeeWithAllowance) employee).reduce(0,
                        (a, b) -> a + b.getAllowance(), Integer::sum);
    }

    public int calculateAllSalary() {
        return employees.stream().reduce(0, (a, b) -> a + b.getSalary(), Integer::sum);
    }

}
