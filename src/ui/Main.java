package ui;

import java.util.List;

import controller.ControllerEmployee;
import controller.ControllerSalary;
import entities.person.Employee;
import entities.salary.MinSalary;
import ui.components.TableEmployees;
import ui.components.TableEntireData;
import ui.components.TablePayroll;
import utilities.UtilityInput;
import utilities.UtilityMenu;

public class Main {
    private UtilityMenu menu;
    private UtilityInput input;
    private ControllerEmployee controllerEmployee;
    private ControllerSalary controllerSalary;
    private TableEmployees tableEmployees;
    private TableEntireData tableEntireData;
    private List<Employee> employees;
    String chosenMenu;

    public Main(List<Employee> employees) {
        this.employees = employees;
        this.menu = new UtilityMenu();
        this.input = new UtilityInput();
        this.controllerEmployee = new ControllerEmployee(this.employees);
        this.controllerSalary = new ControllerSalary();
        this.tableEmployees = new TableEmployees();
        this.tableEntireData = new TableEntireData();

    }

    public void main() {
        String[] mainMenuArray = { "Add Employee", "Update Employee", "Data Employee", "Data Payroll",
                "Delete Employee", "Find Employee" };
        menu.createMenu(this::handleMainMenu, "EMPLOYEE MANAGEMENT APP by MRDevs", mainMenuArray, 0, "Exit");
        System.out.println("==========================================");
        System.out.println("APPLICATION HAS BEEN CLOSED");
        System.out.println("==========================================");

        input.close();
    }

    public void handleMainMenu(String chosenMenu) {
        TablePayroll tablePayroll = new TablePayroll();
        menu.resetDisplay();
        switch (Integer.valueOf(chosenMenu)) {
            case 1:
                String[] addMenuArray = { "General", "Programmer", "Project Leader", "Analyst" };
                menu.createMenu(s -> handleCreateEmployeMenu(s), "Add Employee Category",
                        addMenuArray, 99,
                        "Back to Main Menu");
                break;
            case 2:
                tableEmployees.printHeader("Update Employee");
                tableEmployees.printBody(employees);
                if (menu.confirmation("Ingin memperbaharui Employee?")) {
                    String id = input.validate("Masukkan Employee ID", "Employee ID tidak ditemukan",
                            s -> controllerEmployee.isValidEmployeeId(s));

                    String[] updateMenuArray = { "Update Employee Name", "Update Employee Address",
                            "Update Employee Age",
                            "Update Employee Job Desc", "Update Employee Placement", "Update All Data", "Check Data" };
                    menu.createMenu(s -> handleUpdateEmployeeMenu(s, id), "Update Employee Choices",
                            updateMenuArray, 99,
                            "Back to Main Menu");
                }
                break;
            case 3:
                tableEmployees.printHeader("Data Employee");
                tableEmployees.printBody(employees);
                menu.enterToContinue();
                break;
            case 4:
                tablePayroll.printHeader("Data Payroll");
                tablePayroll.printBody(employees);
                menu.enterToContinue();
                break;
            case 5:
                handleDeleteEmployeeMenu();
                break;
            case 6:
                String[] findMenuArray = { "Find Employee by Placement" };
                menu.createMenu(this::handleFindEmployeeMenu, "Find Employee", findMenuArray, 99, "Back to Main Menu");
                break;
            default:
                break;
        }

    }

    public void handleFindEmployeeMenu(String chosenMenu) {
        switch (Integer.valueOf(chosenMenu)) {
            case 1:
                String city = input.validate("Masukkan Placement", "Placement tidak valid", s -> input.isWord(s));
                tableEmployees.printHeader("Find Employee");
                tableEmployees.printBody(controllerEmployee.findEmployeeByPlacementCity(city));
                menu.enterToContinue();
                break;
            default:
                break;
        }

    }

    public void handleCreateEmployeMenu(String chosenMenu) {
        int chosenMenuInt = Integer.valueOf(chosenMenu);
        String progLanguage = null;
        int experience = 0;
        int totalProject = 0;

        if (chosenMenuInt != 99) {
            menu.resetDisplay();
            String name = input.validate("Masukkan Employee Name", "Name tidak valid!", s -> input.isWord(s));
            String address = input.validate("Masukkan Employee Address", "Address tidak valid!", s -> input.isWord(s));
            int age = Integer
                    .valueOf(input.validate("Masukkan Employee Age", "Age tidak valid!", s -> input.isNumber(s)));
            String jobDesc = input.validate("Masukkan Employee Job Desc", "Job Desc tidak valid!",
                    s -> input.isWord(s));
            MinSalary placement = controllerSalary.findMinSalaryByCity(input.validate("Masukkan Employee Placement",
                    "Placement tidak valid!", s -> controllerSalary.isValidPlacement(s)));
            if (chosenMenuInt == 2) {
                progLanguage = input.validate("Masukkan Programming Language", "Programming Language tidak valid!",
                        s -> input.isWord(s));
                experience = Integer.valueOf(input.validate("Masukkan Lama Experience", "Lama Experience tidak valid!",
                        s -> input.isNumber(s)));
            }
            if (chosenMenuInt == 3) {
                totalProject = Integer.valueOf(input.validate("Masukkan Total Project", "Total Project tidak valid!",
                        s -> input.isNumber(s)));
            }

            controllerEmployee.createEmployee(chosenMenuInt, name, address, age, jobDesc, placement, progLanguage,
                    experience, totalProject);
            System.out.println("Employee berhasil ditambahkan");
            menu.enterToContinue();
        }

    }

    public void handleUpdateEmployeeMenu(String chosenMenu, String id) {
        Employee employee = controllerEmployee.findEmployeeById(id);
        int chosenMenuInt = Integer.valueOf(chosenMenu);
        Boolean all = chosenMenuInt == 6;
        menu.resetDisplay();
        tableEntireData.printHeader("Update Employee " + employee.getId());
        tableEntireData.printBody(controllerEmployee.findEmployeesById(employee.getId()));

        if (chosenMenuInt == 1 || all)
            employee.setName(input.validate("Masukkan Employee Name", "Name tidak valid!",
                    s -> input.isWord(s)));
        if (chosenMenuInt == 2 || all)
            employee.setAddress(input.validate("Masukkan Employee Address", "Address tidak valid!",
                    s -> input.isWord(s)));
        if (chosenMenuInt == 3 || all)
            employee.setAge(Integer.valueOf(input.validate("Masukkan Employee Age", "Age tidak valid!",
                    s -> input.isNumber(s))));
        if (chosenMenuInt == 4 || all)
            employee.setJobDesc(input.validate("Masukkan Employee Job Desc", "Job Desc tidak valid!",
                    s -> input.isWord(s)));

        if (chosenMenuInt == 5 || all)
            employee.setPlacement(controllerSalary
                    .findMinSalaryByCity(input.validate("Masukkan Employee Placement", "Placement tidak valid!",
                            s -> controllerSalary.isValidPlacement(s))));

        if (chosenMenuInt == 7)
            menu.enterToContinue();

        controllerEmployee.updateEmployee(employee);
        if (chosenMenuInt != 99 && chosenMenuInt != 7) {
            System.out.println("Employee berhasil diperbaharui");
            menu.enterToContinue();
        }

    }

    public void handleDeleteEmployeeMenu() {
        tableEmployees.printHeader("Delete Employee");
        tableEmployees.printBody(employees);
        if (menu.confirmation("Ingin menghapus Employee?")) {
            String id = input.validate("Masukkan Employee ID", "Employee ID tidak ditemukan",
                    s -> controllerEmployee.isValidEmployeeId(s));
            controllerEmployee.deleteEmployee(id);
            System.out.println("Employee berhasil dihapus");
            menu.enterToContinue();
        }
    }

    public String print() {
        return chosenMenu;
    }

}
