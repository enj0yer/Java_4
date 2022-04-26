package ru.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;


public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
    @Query("select * from Employee where id_department = (:id)")
    Iterable<Employee> findEmployeesWithDepartment(@Param("id") int id_department);
    @Query("select id_employee as id_employee, Employee.name as name, Department.name as department_name from Employee left join Department on Employee.id_department = Department.id_department")
    Iterable<Employee> findEmployeesWithNamedDepartments();
}
