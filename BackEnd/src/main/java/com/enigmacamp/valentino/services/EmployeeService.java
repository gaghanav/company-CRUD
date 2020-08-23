package com.enigmacamp.valentino.services;

import com.enigmacamp.valentino.entitys.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    public Page<Employee> getListForPagination(Pageable pageable);
    public Employee getById(Integer id);
    public Employee insert(Employee employee);
    public Employee update(Employee employee);
    public Employee delete(Employee employee);
}
