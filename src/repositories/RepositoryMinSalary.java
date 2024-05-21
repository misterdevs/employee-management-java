package repositories;

import java.util.ArrayList;
import java.util.List;

import entities.salary.MinSalary;

public class RepositoryMinSalary {
    public List<MinSalary> getMinSalaries() {
        List<MinSalary> minSalaryList = new ArrayList<MinSalary>() {
            {
                add(new MinSalary("Garut", 1961085));
                add(new MinSalary("Bandung", 3742276));
                add(new MinSalary("Jakarta", 4453935));
                add(new MinSalary("Bekasi", 4782935));
                add(new MinSalary("Bogor", 4330249));
            }
        };
        return minSalaryList;
    }

}
