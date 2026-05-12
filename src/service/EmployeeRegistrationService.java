package service;

import model.Employee;
import persistence.Repository;

public class EmployeeRegistrationService {
    /*
    Crie um método público chamado register, que receba os dados para a criação de um novo
    revendedor no repositório, incluindo o id do empregado responsável por ele. Caso o
    Employee responsável seja um revendedor, ele precisará ser promovido a consultor*/

    private final Repository<String, Employee> repository;

    public EmployeeRegistrationService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    //NÃO ENTENDI O MÉTODO REGISTER
    public void register(Employee employee) {

    }
}
