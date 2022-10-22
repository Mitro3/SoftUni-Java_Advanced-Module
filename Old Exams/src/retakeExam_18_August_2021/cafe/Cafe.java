package retakeExam_18_August_2021.cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        Employee employee = getEmployee(name);

        if (employee != null) {
            employees.remove(employee);
            return true;
        }

        return false;
    }

    public Employee getEmployee(String name) {
        Employee employee = null;
        employee = employees.stream().filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);

        return employee;
    }

    public Employee getOldestEmployee() {
        Employee employee = null;
        employee = employees.stream().max(Comparator.comparing(e -> e.getAge())).orElse(null);
        return employee;
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Cafe ").append(name).append(":");
        for (Employee employee : employees) {
            sb.append(System.lineSeparator());
            sb.append(employee);
        }

        return sb.toString();
    }
}
