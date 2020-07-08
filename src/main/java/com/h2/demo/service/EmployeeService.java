package com.h2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2.demo.model.Employee;
import com.h2.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	public String addEmployee(Employee emp) {
		String response;
		if(employeeRepository.addEmployee(emp))
			response = "Successfully Added";
		else response = "Something went wrong, not added , please try again";
				
		return response;
	}

	public String updateEmployee(Employee emp) {
		String response;
		if(employeeRepository.updateEmployee(emp))
			response = "Successfully updated";
		else response = "Something went wrong, not udpated , please try again";
				
		return response;
	}

	public String deleteEmployee(int id) {
		String response;
		if(employeeRepository.deleteEmployee(id))
			response = "Successfully deleted";
		else response = "Something went wrong, not deleted , please try again";
				
		return response;
	}
	
	
	
}
