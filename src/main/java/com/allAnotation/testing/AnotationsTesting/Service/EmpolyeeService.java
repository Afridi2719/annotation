package com.allAnotation.testing.AnotationsTesting.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.allAnotation.testing.AnotationsTesting.Entity.EmployeeDetails;
import com.allAnotation.testing.AnotationsTesting.Exception.ProductNotFoundException;
import com.allAnotation.testing.AnotationsTesting.Repository.EmployeeRepository;

import ch.qos.logback.core.model.processor.ProcessorException;

@Service
public class EmpolyeeService {

	public EmployeeRepository employeeRepository;
	
	public EmpolyeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public EmployeeDetails getEmpById(String empid){
		EmployeeDetails res = employeeRepository.findByEmpId(empid);
		if (res!=null) {
			return res;
		}
		throw new ProductNotFoundException("Employee not found by Employee id : "+empid);
	}
	
	public EmployeeDetails updateEmployeeDetails(EmployeeDetails data,String empId) {
		if(data.getEmpId().equals(empId)) {
			EmployeeDetails res = this.employeeRepository.findByEmpId(empId);
			if(res != null) {
				res.setName(data.getName());
				return employeeRepository.save(res);
			}
		}
		throw new ProductNotFoundException("EmpId is not exist");
	}

	public EmployeeDetails AddEmployeeDetails(EmployeeDetails data) {
		EmployeeDetails res = this.employeeRepository.findByEmpId(data.getEmpId());
		if(res==null) {	
			return employeeRepository.save(data);
		}
		throw new ProductNotFoundException("EmpId is alredy exist");
	}

	public List<EmployeeDetails> getEmployeeDetails() {
		// TODO Auto-generated method stub
		return (List<EmployeeDetails>) this.employeeRepository.findAll();
	}
	
	public String deleteEmployeeDetails(String empId) {
		EmployeeDetails res = this.employeeRepository.findByEmpId(empId);
		if(res!=null) {
			this.employeeRepository.deleteById(res.getId());;
			return "Success";
		}
		throw new ProductNotFoundException("Employee not found by Employee id : "+empId); 
	}
	
	public List<EmployeeDetails> collectByName(String value) {
		return this.employeeRepository.collectByName(value);
		 
	}
}
