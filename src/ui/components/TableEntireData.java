package ui.components;

import java.util.List;

import entities.person.Employee;
import entities.person.Programmer;
import entities.person.ProjectLeader;
import interfaces.IEmployeeWithAllowance;
import utilities.Utility;

public class TableEntireData {
    private Utility utility;
    public String displayFormat = "| %-3s | %-13s | %-20s | %-10s | %-5s | %-20s | %-10s | %-20s | %-10s | %-15s | %-15s | %-15s |%n";
    public String displayBorder = "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------%n";
    public String displayBorderHeader = "=================================================================================================================================================================================================%n";

    public TableEntireData() {
        this.utility = new Utility();

    }

    public void printHeader(String menuName) {
        System.out.format(displayBorderHeader);
        System.out.format("| %-189s |%n", menuName.toUpperCase());
        System.out.format(displayBorderHeader);
        System.out.printf(displayFormat, "No", "Employee ID", "Name", "Address", "Age", "Job Desc", "Placement",
                "Programming Language", "Experience", "Total Project", "Allowance", "Salary");
        System.out.format(displayBorderHeader);
    }

    public void printBody(List<Employee> employees) {
        if (employees.size() > 0) {
            employees.sort((a, b) -> a.getId().compareTo(b.getId()));
            for (int i = 0; i < employees.size(); i++) {
                Employee employee = employees.get(i);
                System.out.format(displayFormat, i + 1, employee.getId(), employee.getName(), employee.getAddress(),
                        employee.getAge(), employee.getJobDesc(), employee.getPlacement().getCity(),
                        (employee instanceof Programmer) ? ((Programmer) employee).getProgLanguage() : "-",
                        (employee instanceof Programmer) ? ((Programmer) employee).getExperience() : "-",
                        (employee instanceof ProjectLeader) ? ((ProjectLeader) employee).getTotalProject() : "-",
                        (employee instanceof IEmployeeWithAllowance)
                                ? utility.rupiahFormatter(((IEmployeeWithAllowance) employee).getAllowance())
                                : "-",
                        utility.rupiahFormatter(employee.getSalary()));
                System.out.format(displayBorder);
            }
        } else {
            System.out.format("| %-189s |%n", "Tidak ada data");
            System.out.format(displayBorder);
        }

    }
}
