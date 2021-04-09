package com.sampleproject.employee.manager.Service;

import java.util.List;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampleproject.employee.manager.Repository.EmployeeRepository;
import com.sampleproject.employee.manager.exception.UserNotFoundException;
import com.sampleproject.employee.manager.model.Employee;

@Service
public class EmployeeService {
	
	
	private final EmployeeRepository employeeRepository;

	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		
		this.employeeRepository = employeeRepository;
	}
	
	public Employee addEmployee(Employee employee)
	{
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepository.save(employee);
	}
	
	public List<Employee> findAllEmployees()
	{
		return employeeRepository.findAll();
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
		
	}
	public Employee findEmployeeById(Long id)
	{
		return employeeRepository.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User By ID" + id +" was Not Found"));
	}
	public void deleteEmployee(Long id)
	{
		employeeRepository.deleteById(id);
	}

}
