package com.apptad.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.apptad.demo.model.Employee;

@Repository
public class EmployeeRepository {
	@Autowired

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	public String insert(Employee employeeModel) {
		String sql = "INSERT INTO Employee(empId, fname ,lname , address, contact,emailId) VALUES (:empId, :fname ,:lname , :address, :contact,:emailId )";
		MapSqlParameterSource paramap = new MapSqlParameterSource();
		paramap.addValue("empId",employeeModel.getEmpId());
		paramap.addValue("fname",employeeModel.getFname());
		System.out.println(employeeModel.getFname());
		paramap.addValue("lname",employeeModel.getLname());
		System.out.println(employeeModel.getLname());
		
		paramap.addValue("address",employeeModel.getAddress());
		paramap.addValue("contact",employeeModel.getContact());
		paramap.addValue("emailId",employeeModel.getEmailId());
		int i=namedParameterJdbcTemplate.update(sql, paramap);
		 if(i==1)
			 return "Record Inserted";
		 else
			 return "Record cannot be inserted";
	}
	
	}

