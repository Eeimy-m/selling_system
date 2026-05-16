package service;

import model.Consultant;
import model.Employee;
import model.Reseller;
import persistence.Repository;

import java.time.LocalDate;

public class EmployeeRegistrationService {

    private final Repository<String, Employee> repository;

    public EmployeeRegistrationService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    public void register(String id, String name, LocalDate brithDate, double solidValue, String consultantInChargeId) {
        Employee employeeInCharge = repository.findById(consultantInChargeId).orElseThrow(IllegalStateException::new);
        Consultant consultant = (employeeInCharge instanceof Reseller reseller)
                ? new Consultant(reseller)
                : (Consultant) employeeInCharge;

        Reseller reseller = new Reseller(id, name, brithDate, solidValue, consultant);
        consultant.addEmployee(reseller);

        repository.save(reseller);
        repository.update(consultant);
    }
}
