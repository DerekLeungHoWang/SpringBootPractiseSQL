package com.h2.demo.repository;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.h2.demo.model.Employee;


@Repository
public class EmployeeRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private final String GET_ALL = "SELECT*FROM employees";
	private final String INSERT_EMPLOYEE = "INSERT INTO employees(FIRST_NAME,LAST_NAME, ADDRESS) values(?,?,?)";
	private final String UPDATE_EMPLOYEE = "UPDATE employees set FIRST_NAME = ? , LAST_NAME = ? , ADDRESS = ? WHERE id = ?";
	private final String DELETE_EMPLOYEE = "DELETE employees WHERE id = ?";
	
	private RowMapper<Employee> rowMapper = (ResultSet rs, int rowNum)->{
		Employee emp = new Employee();
		emp.setId(rs.getInt(1));
		emp.setFirstName(rs.getString(2));
		emp.setLastName(rs.getString(3));
		emp.setAddress(rs.getString(4));
		emp.setJoiningDate(rs.getString(5));
		
		return emp;
	};

	public List<Employee> findAll() {
		 return jdbcTemplate.query(GET_ALL, rowMapper);
	}
	
	public boolean addEmployee(Employee e) {
		if(jdbcTemplate.update(INSERT_EMPLOYEE, e.getFirstName(),e.getLastName(),e.getAddress())>0) {
			return true;
		}else {
			return false;
		}
		
	}

	public boolean updateEmployee(Employee e) {
		if(jdbcTemplate.update(UPDATE_EMPLOYEE, e.getFirstName(),e.getLastName(),e.getAddress(), e.getId())>0) {
			return true;
		}else {
			return false;
		}
	}

	public boolean deleteEmployee(int id) {
		if(jdbcTemplate.update(DELETE_EMPLOYEE, id)>0) {
			return true;
		}else {
			return false;
		}
	}

}
