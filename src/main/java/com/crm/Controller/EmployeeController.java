package com.crm.Controller;

import com.crm.Service.EmployeeService;
import com.crm.entity.Employee;
import com.crm.payload.EmployeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //http://localhost:8080/api/v1/employee/add
    @PostMapping("/add1")
    public ResponseEntity<EmployeeDto> addEmployee(
            @RequestBody EmployeeDto dto

    ) {
        EmployeeDto employeeDto=employeeService.addEmployee(dto);


        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }
@DeleteMapping
public ResponseEntity<String> deleteEmployee(
        @RequestParam Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<EmployeeDto>UpdateEmployee(
            @RequestParam Long id,
            @RequestBody EmployeeDto dto) {
       EmployeeDto employeeDto= employeeService.updateEmployee(id, dto);
        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity< List<EmployeeDto>> getEmployees(
    ) {
        List<EmployeeDto> employeesDto = employeeService.getEmployee();
        return new ResponseEntity<>(employeesDto, HttpStatus.OK);



    }
}
