package repositories;

import java.util.ArrayList;
import java.util.List;

import controller.ControllerSalary;
import entities.person.Analyst;
import entities.person.Employee;
import entities.person.Programmer;
import entities.person.ProjectLeader;

public class RepositoryEmployee {
        private ControllerSalary controllerSalary;

        public RepositoryEmployee() {
                this.controllerSalary = new ControllerSalary();
        }

        public List<Employee> getEmployees() {
                List<Employee> employeeList = new ArrayList<Employee>() {
                        {
                                add(new Employee("Emp-001", "Susi", "Bandung", 27, "Admin",
                                                controllerSalary.findMinSalaryByCity("jakarta")));
                                add(new Employee("Emp-002", "Anto", "Bandung", 35, "Office Boy",
                                                controllerSalary.findMinSalaryByCity("bandung")));
                                add(new Employee("Emp-002", "Anto", "Bandung", 35, "Office Boy",
                                                controllerSalary.findMinSalaryByCity("bandung")));
                                add(new Employee("Emp-003", "Riman", "Jakarta", 28, "Human Resource Dev",
                                                controllerSalary.findMinSalaryByCity("bandung")));

                                add(new Programmer("Prog-001", "Budi", "Bandung", 25, "Back-End Dev",
                                                controllerSalary.findMinSalaryByCity("jakarta"), "Java", 2));
                                add(new Programmer("Prog-002", "Ani", "Bandung", 30, "Front-End Dev",
                                                controllerSalary.findMinSalaryByCity("bandung"), "React JS", 6));
                                add(new Programmer("Prog-003", "Ujang", "Jakarta", 28, "Full-Stack Dev",
                                                controllerSalary.findMinSalaryByCity("bandung"), "Kotlin", 4));

                                add(new ProjectLeader("PL-001", "Ahmad", "Bandung", 25, "Project Leader",
                                                controllerSalary.findMinSalaryByCity("garut"), 2));
                                add(new ProjectLeader("PL-002", "Dani", "Bandung", 30, "Scrum Master",
                                                controllerSalary.findMinSalaryByCity("bekasi"), 1));
                                add(new ProjectLeader("PL-003", "Cecep", "Jakarta", 28, "Project Owner",
                                                controllerSalary.findMinSalaryByCity("bogor"), 4));

                                add(new Analyst("AL-001", "Indah", "Garut", 25, "Analyst",
                                                controllerSalary.findMinSalaryByCity("jakarta")));
                                add(new Analyst("AL-002", "Puspa", "Bandung", 30, "Analyst",
                                                controllerSalary.findMinSalaryByCity("bekasi")));
                                add(new Analyst("AL-003", "Sari", "Jakarta", 28, "Analyst",
                                                controllerSalary.findMinSalaryByCity("bogor")));
                        }
                };
                return employeeList;
        }

}
