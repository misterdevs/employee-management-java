package ui.components;

import java.util.List;

import entities.person.Employee;

public class TableEmployees {
    public String displayFormat = "| %-3s | %-13s | %-20s | %-10s | %-5s | %-20s | %-10s  |%n";
    public String displayBorder = "--------------------------------------------------------------------------------------------------------%n";
    public String displayBorderHeader = "========================================================================================================%n";

    public TableEmployees() {

    }

    public void printHeader(String menuName) {
        System.out.format(displayBorderHeader);
        System.out.format("| %-100s |%n", menuName.toUpperCase());
        System.out.format(displayBorderHeader);
        System.out.printf(displayFormat, "No", "Employee ID", "Name", "Address", "Age", "Job Desc", "Placement");
        System.out.format(displayBorderHeader);
    }

    public void printBody(List<Employee> employees) {
        if (employees.size() > 0) {
            employees.sort((a, b) -> a.getId().compareTo(b.getId()));
            for (int i = 0; i < employees.size(); i++) {
                Employee employee = employees.get(i);
                System.out.format(displayFormat, i + 1, employee.getId(), employee.getName(), employee.getAddress(),
                        employee.getAge(), employee.getJobDesc(), employee.getPlacement().getCity());
                System.out.format(displayBorder);
            }
        } else {
            System.out.format("| %-100s |%n", "Tidak ada data");
            System.out.format(displayBorder);
        }

    }
}
