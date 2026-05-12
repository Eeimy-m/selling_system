import java.time.LocalDate;
import java.util.Objects;

public abstract sealed class Employee permits Reseller, Consultant{
    private String id;
    private String name;
    private LocalDate brithDate;
    private double solidValue;

    public Employee(String id, String name, LocalDate brithDate, double solidValue) {
        this.id = id;
        this.name = name;
        this.brithDate = brithDate;
        this.solidValue = solidValue;
    }

    public abstract double getComission();


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", brithDate=" + brithDate +
                ", solidValue=" + solidValue +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBrithDate() {
        return brithDate;
    }

    public double getSolidValue() {
        return solidValue;
    }
}
