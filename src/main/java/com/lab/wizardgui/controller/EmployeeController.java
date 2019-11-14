package com.lab.wizardgui.controller;

import com.lab.wizardgui.client.EmployeeClient;
import com.lab.wizardgui.domain.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lab/gui")
public class EmployeeController {

    @Autowired
    private EmployeeClient employeeClient;

    @GetMapping(value = "/employees")
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employees = employeeClient.getAllEmployees();
        return employees;
    }

    @GetMapping(value = "/employees/{id}")
    public EmployeeDto getEmployee(@PathVariable Long id) {
        EmployeeDto employeeDto = employeeClient.getEmployee(id);
        return employeeDto;
    }

    @PostMapping(value = "/employees")
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeClient.createNewEmployee(employeeDto);
    }

    @DeleteMapping(value = "/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeClient.deleteEmployee(id);
    }
}
