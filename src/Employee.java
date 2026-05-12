import java.time.LocalDate;

public class Employee {
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
