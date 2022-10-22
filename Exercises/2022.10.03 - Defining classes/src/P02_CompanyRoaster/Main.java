package P02_CompanyRoaster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employeesCount = Integer.parseInt(scanner.nextLine());

        List<Employee> employees = new ArrayList<>();
        List<Department> departments = new ArrayList<>();

        for (int i = 0; i < employeesCount; i++) {
            String[] employeeData = scanner.nextLine().split("\\s+");
            String currName = employeeData[0];
            double currSalary = Double.parseDouble(employeeData[1]);
            String currPosition = employeeData[2];
            String currEmplDepartment = employeeData[3];

            Employee employee = null;

            switch (employeeData.length) {
                case 4:
                    employee = new Employee(currName, currSalary, currPosition, currEmplDepartment);
                    break;

                case 5:
                    if (employeeData[4].contains("@")) {
                        String currEmplEmail = employeeData[4];
                        employee = new Employee(currName, currSalary, currPosition, currEmplDepartment, currEmplEmail);
                    } else {
                        int currEmplAge = Integer.parseInt(employeeData[4]);
                        employee = new Employee(currName,currSalary, currPosition, currEmplDepartment, currEmplAge);
                    }
                    break;

                case 6:
                    String currEmail = employeeData[4];
                    int currAge = Integer.parseInt(employeeData[5]);
                    employee = new Employee(currName, currSalary, currPosition, currEmplDepartment, currEmail, currAge);
                    break;
            }

            boolean departmentExists = departments.stream()
                    .anyMatch(department -> department.getName().equals(currEmplDepartment));
            if (!departmentExists) {
                Department department = new Department(currEmplDepartment);
                departments.add(department);
            }

            Department currDepartment = departments.stream().filter(dep -> dep.getName().equals(currEmplDepartment))
                    .findFirst()
                    .get();

            currDepartment.getEmployees().add(employee);
        }

        Department highestPaidDepartment = departments
                .stream()
                .max((first, second) -> Double.compare(first.getAverageSalary(), second.getAverageSalary()))
                .get();

        System.out.printf("Highest Average Salary: %s%n", highestPaidDepartment.getName());
        highestPaidDepartment.getEmployees()
                .stream()
                .sorted((first, second) -> Double.compare(second.getSalary(), first.getSalary()))
                .forEach(System.out::println);

    }
}
