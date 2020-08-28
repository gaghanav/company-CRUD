package com.enigmacamp.valentino.controllers;

import com.enigmacamp.valentino.DTO.EmployeeDTO;
import com.enigmacamp.valentino.entitys.Employee;
import com.enigmacamp.valentino.entitys.Position;
import com.enigmacamp.valentino.services.EmployeeService;
import com.enigmacamp.valentino.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    PositionService positionService;

    @GetMapping("/index")
    public Page<Employee> index(@RequestParam Integer page, @RequestParam Integer size){
        return employeeService.getListForPagination(PageRequest.of(page-1, size));
    }

    @GetMapping("/{id}")
    public EmployeeDTO addEdit(@PathVariable Integer id){
        EmployeeDTO employeeDTO= new EmployeeDTO();
        employeeDTO.setPositionList(positionService.getList());
        if(id!=0){
            employeeDTO.setEmployee(employeeService.getById(id));
        }
        return employeeDTO;
    }

    @PostMapping
    public ResponseEntity<Employee> insert(@RequestBody Employee employee) {
        System.out.println(employee.getTransientPositionId());
        for (Position p: positionService.getList()
             ) {
            if(p.getId().equals(employee.getTransientPositionId()))employee.setPosition(p);
        }
        return new  ResponseEntity<Employee>(employeeService.insert(employee),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.update(employee), HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity<Employee> delete(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.delete(employee), HttpStatus.ACCEPTED);
    }
}
