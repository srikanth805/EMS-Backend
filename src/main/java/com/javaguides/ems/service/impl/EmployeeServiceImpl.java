package com.javaguides.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.javaguides.ems.dto.EmployeeDto;
import com.javaguides.ems.entity.Employee;
import com.javaguides.ems.exception.ResourceNotFoundException;
import com.javaguides.ems.mapper.EmployeeMapper;
import com.javaguides.ems.repository.EmployeeRepository;
import com.javaguides.ems.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeRepository employeeRepository;
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee=employeeRepository.save(employee);
		// TODO Auto-generated method stub
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}
	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
	    // 1️⃣ Fetch Employee entity from database using the repository
	    Employee employee = employeeRepository.findById(employeeId)
	        // 2️⃣ If employee with given ID is not found, throw custom exception
	        .orElseThrow(() -> 
	            new ResourceNotFoundException("Employee not found with given id: " + employeeId));

	    // 3️⃣ Map the Employee entity to EmployeeDto and return it
	    return EmployeeMapper.mapToEmployeeDto(employee);
	}
	@Override
	public List<EmployeeDto>  getAllEmployees()
	{
		List<Employee> employees=employeeRepository.findAll();
		return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}
	@Override
	public EmployeeDto updateEmployee(Long employeeId,EmployeeDto updatedEmployee)
	{
		Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->
		new ResourceNotFoundException("Employee is not exist with the given id: "+employeeId));
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		Employee updatedEmployeeObj=employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}
	@Override
	public void deleteEmployee(Long employeeId)
	{
		Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->
		new ResourceNotFoundException("Employee is not exist with the given id: "+employeeId));
		employeeRepository.deleteById(employeeId);
		
	}


}
