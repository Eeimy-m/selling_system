package service;

import exception.EntityAlreadyExistsException;
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
        Employee employee = repository.findById(id).orElseThrow(IllegalStateException::new);
        return buildString(employee, "");
    }

    public String buildString(Employee employee, String spaces) {
        System.out.println(employee.getClass());
        StringBuilder builder = new StringBuilder();
        builder.append(spaces).append(employee).append("\n");

        if(employee instanceof Consultant consultant) {
            for(Employee reseller : consultant.getEmployees()) {
                builder.append(buildString(reseller, spaces + "        "));
            }
        }

        return builder.toString();
    }
}
