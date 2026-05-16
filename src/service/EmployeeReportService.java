package service;

import model.Consultant;
import model.Employee;
import persistence.Repository;

import java.util.Optional;

public class EmployeeReportService {
    Repository<String, Employee> repository;

    public EmployeeReportService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    public String reportOf(String id) {
        Employee employee = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("The Employee wasn't found in system"));
        return buildString(employee, "");
    }

    public String buildString(Employee employee, String spaces) {
        StringBuilder builder = new StringBuilder();
        builder.append(employee.toString()).append("\n");

        if(employee instanceof Consultant consultant) {
            for(Employee reseller : consultant.getEmployees()) {
                builder.append(buildString(reseller, spaces + "        "));
            }
        }

        return builder.toString();
    }
}
