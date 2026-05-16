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

    /*Crie um
    método chamado reportOf(), que receba um id e retorne uma String contendo os dados e
    valor de comissão do funcionário referente ao id e todos os funcionários sob sua supervisão.
    Para melhor visualização da hierarquia da empresa, adote o formato do Apêndice A. */

    //1 - Acessar o objeto referente ao id
    //2 - Acessar os seus dados
    //3 - Acessar os resselers por quem é responsável
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
