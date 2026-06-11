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

    public void register(String id, String name, LocalDate birthDate, double solidValue, String consultantInChargeId) {
        if(id == null) throw new IllegalArgumentException("ID is null");
        if(id.isBlank()) throw new IllegalArgumentException("ID is blank");

        Employee employeeInCharge = repository.findById(consultantInChargeId).orElseThrow(IllegalStateException::new);
        Consultant consultant = (employeeInCharge instanceof Reseller reseller)
                ? new Consultant(reseller)
                : (Consultant) employeeInCharge;

        Reseller newReseller = new Reseller(id, name, birthDate, solidValue, consultant);
        consultant.addEmployee(newReseller);

        repository.save(newReseller);
        repository.update(consultant);
    }
}
