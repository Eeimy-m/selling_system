package model;

import exception.EntityAlreadyExistsException;
import persistence.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class InMemoryEmployeeRepository implements Repository<String, Employee> {
    private final static Map<String, Employee> repo = new HashMap<>();

    @Override
    public void save(Employee employee) {
        if(repo.containsKey(employee.getId()))
            throw new EntityAlreadyExistsException("Employee already exists in the application");
        repo.put(employee.getId(), employee);
    }

    @Override
    public void update(Employee employee) {
        if(!repo.containsKey(employee.getId()))
            throw new NoSuchElementException("Employee does not exist in the application");
        repo.put(employee.getId(), employee);
    }

    @Override
    public Optional<Employee> findById(String id) {
        if(!repo.containsKey(id))
            throw new NoSuchElementException("Employee does not exist in the application");
        return Optional.ofNullable(repo.get(id));
    }
}
