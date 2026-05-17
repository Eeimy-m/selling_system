package model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public final class Consultant extends Employee {
    private final Set<Employee> employees = new HashSet<>();

    public Consultant(String id, String name, LocalDate brithDate, double solidValue, Consultant consultantInCharge) {
        super(id, name, brithDate, solidValue, consultantInCharge);
    }

    public Consultant(String id, String name, LocalDate brithDate, double solidValue) {
        super(id, name, brithDate, solidValue);
    }

    public Consultant(Reseller reseller) {
        super(reseller.getId(), reseller.getName(), reseller.getBrithDate(), reseller.getSolidValue(), reseller.getConsultant());
    }

    @Override
    public double getComission() {
        double subordinatesComission = employees.stream()
                .mapToDouble(Employee::getComission)
                .sum();

        return (this.getSolidValue() * 0.15) + (subordinatesComission * 0.30);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Set<Employee> getEmployees() {
        return employees;
    }
}
