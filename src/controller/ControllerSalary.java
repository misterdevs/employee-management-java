package controller;

import java.util.List;
import java.util.stream.Collectors;

import entities.salary.MinSalary;
import repositories.RepositoryMinSalary;

public class ControllerSalary {
    private List<MinSalary> minSalaries;

    public ControllerSalary() {
        this.minSalaries = new RepositoryMinSalary().getMinSalaries();
    }

    public List<MinSalary> findMinSalariesByCity(String city) {
        return minSalaries.stream().filter(s -> s.getCity().toLowerCase().contains(city.toLowerCase()))
                .collect(Collectors.toList());
    }

    public MinSalary findMinSalaryByCity(String city) {
        return minSalaries.stream().filter(s -> s.getCity().toLowerCase().contains(city.toLowerCase()))
                .findFirst().orElse(null);
    }

    public Boolean isValidPlacement(String city) {
        return findMinSalaryByCity(city) != null;
    }

}
