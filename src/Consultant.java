import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class Consultant extends Employee {
    private final List<Employee> employees = new ArrayList<>();

    public Consultant(String id, String name, LocalDate brithDate, double solidValue) {
        super(id, name, brithDate, solidValue);
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

//    public Set<Employee> getEmployees() {
//        return
//    }
}
