package com.enigmacamp.valentino.DTO;

import com.enigmacamp.valentino.entitys.Employee;
import com.enigmacamp.valentino.entitys.Position;

import java.util.List;

public class EmployeeDTO {

    private List<Position> positionList;
    private Employee employee;

    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
