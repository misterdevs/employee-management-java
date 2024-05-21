package ui.components;

import java.util.List;

import controller.ControllerEmployee;
import entities.person.Employee;
import interfaces.IEmployeeWithAllowance;
import utilities.Utility;

public class TablePayroll {
    private Utility utility;
    public String displayFormat = "| %-3s | %-13s | %-20s | %-20s | %-10s | %-15s | %-15s |%n";
    public String displayBorder = "----------------------------------------------------------------------------------------------------------------------%n";
    public String displayBorderHeader = "======================================================================================================================%n";

    public TablePayroll() {
        this.utility = new Utility();

    }

    public void printHeader(String menuName) {
        System.out.format(displayBorderHeader);
        System.out.format("| %-114s |%n", menuName.toUpperCase());
        System.out.format(displayBorderHeader);
        System.out.printf(displayFormat, "No", "Employee ID", "Name", "Job Desc", "Placement", "Allowance", "Salary");
        System.out.format(displayBorderHeader);
    }

    public void printBody(List<Employee> employees) {
        ControllerEmployee controllerEmployee = new ControllerEmployee(employees);
        if (employees.size() > 0) {
            employees.sort((a, b) -> a.getId().compareTo(b.getId()));
            for (int i = 0; i < employees.size(); i++) {
                Employee employee = employees.get(i);
                Boolean isWithAllowance = employee instanceof IEmployeeWithAllowance;

                System.out.format(displayFormat, i + 1, employee.getId(), employee.getName(), employee.getJobDesc(),
                        employee.getPlacement().getCity(),
                        isWithAllowance ? utility.rupiahFormatter(((IEmployeeWithAllowance) employee).getAllowance())
                                : "-",
                        utility.rupiahFormatter(employee.getSalary()));
                System.out.format(displayBorder);
            }
            System.out.format("| %-78s | %-33s |%n", "Total Salary",
                    utility.rupiahFormatter(controllerEmployee.getTotalSalary()));
            System.out.format(displayBorder);
        } else {
            System.out.format("| %-114s |%n", "Tidak ada data");
            System.out.format(displayBorder);
        }

    }
}
