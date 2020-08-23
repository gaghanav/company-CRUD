package com.enigmacamp.valentino.services.Impl;

import com.enigmacamp.valentino.DAO.EmployeeDAO;
import com.enigmacamp.valentino.Exceptions.EmployeeIdNumberAlreadyExist;
import com.enigmacamp.valentino.Exceptions.EmployeeNotFoundException;
import com.enigmacamp.valentino.entitys.Employee;
import com.enigmacamp.valentino.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public Page<Employee> getListForPagination(Pageable pageable) {
        return employeeDAO.getAllByIsDeleteIsLessThan(1, pageable);
    }

    @Override
    public Employee getById(Integer id) {
        if(employeeDAO.findById(id).isPresent()){
            return employeeDAO.findById(id).get();
        }
        else throw new EmployeeNotFoundException();
    }

    @Override
    public Employee insert(Employee employee) {
        employee.setIsDelete(0);
        if(employeeDAO.existsEmployeeByIdNumber(employee.getIdNumber())) {
            throw new EmployeeIdNumberAlreadyExist(employee.getIdNumber());
        }
        else return employeeDAO.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        if(employee.getId()!=null){
            return employeeDAO.save(employee);
        }
        else throw new EmployeeNotFoundException();
    }

    @Override
    public Employee delete(Employee employee) {
        employee.setIsDelete(1);
        return update(employee);
    }
}
