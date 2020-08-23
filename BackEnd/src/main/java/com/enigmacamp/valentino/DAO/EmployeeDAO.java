package com.enigmacamp.valentino.DAO;

import com.enigmacamp.valentino.entitys.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
    public Page<Employee> getAllByIsDeleteIsLessThan(Integer number, Pageable pageable);
    public boolean existsEmployeeByIdNumber(Integer number);
}
