package com.crm.Service;

import com.crm.Repository.EmployeeRepository;
import com.crm.entity.Employee;
import com.crm.payload.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public EmployeeDto addEmployee(EmployeeDto dto ){
        Employee employee=mapToEntity(dto);
         Employee emp=employeeRepository.save(employee);
         EmployeeDto employeeDto=mapT0Dto(emp);
         employeeDto.setdate(new Date());
         return employeeDto;
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto dto) {
        Employee employee=mapToEntity(dto);
        employee.setId(id);
        Employee updatedEmployee=employeeRepository.save(employee);
       EmployeeDto employeeDto=mapToDto(updatedEmployee);
       return employeeDto;

    }

    private EmployeeDto mapToDto(Employee updatedEmployee) {
        EmployeeDto employeeDto=new EmployeeDto();
        employeeDto.setId(updatedEmployee.getId());
        employeeDto.setName(updatedEmployee.getName());
        employeeDto.setEmailId(updatedEmployee.getEmailId());
        employeeDto.setMobile(updatedEmployee.getMobile());
        return employeeDto;
    }

    public List<EmployeeDto> getEmployee() {
        List<Employee>employees=employeeRepository.findAll();
        List<EmployeeDto>dto=employees.stream().map(e->mapToDto(e)).collect(Collectors.toList());
        return dto;

    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
    EmployeeDto mapT0Dto(Employee employee){
        EmployeeDto Dto=new EmployeeDto();
        Dto.setId(employee.getId());
        Dto.setName(employee.getName());
        Dto.setEmailId(employee.getEmailId());
        Dto.setMobile(employee.getMobile());
        return Dto;
    }
    Employee mapToEntity(EmployeeDto dto){
        Employee emp=new Employee();
        emp.setId(dto.getId());
        emp.setName(dto.getName());
        emp.setEmailId(dto.getEmailId());
        emp.setMobile(dto.getMobile());
        return emp;
    }



}


