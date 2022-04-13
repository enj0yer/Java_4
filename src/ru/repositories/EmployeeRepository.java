package ru.repositories;

import org.springframework.data.repository.CrudRepository;

import ru.repositories.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
