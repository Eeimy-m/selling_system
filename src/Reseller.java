import java.time.LocalDate;

public final class Reseller extends Employee {

    public Reseller(String id, String name, LocalDate brithDate, double solidValue) {
        super(id, name, brithDate, solidValue);
    }

    public double getComission() {return 0;}
}
