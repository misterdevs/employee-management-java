import java.util.List;

import entities.person.Employee;
import repositories.RepositoryEmployee;
import ui.Main;

public class App {
    public static void main(String[] args) throws Exception {
        List<Employee> employees = new RepositoryEmployee().getEmployees();
        Main menu = new Main(employees);

        menu.main();
    }
}
