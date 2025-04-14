package com.allAnotation.testing.AnotationsTesting.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.allAnotation.testing.AnotationsTesting.Entity.EmployeeDetails;
import com.allAnotation.testing.AnotationsTesting.Exception.ProductNotFoundException;
import com.allAnotation.testing.AnotationsTesting.Service.EmpolyeeService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/test")
public class TestController {
	
	private EmpolyeeService empolyeeService;
	
	public TestController(EmpolyeeService empolyeeService) {
		this.empolyeeService = empolyeeService;
	}
	
	@GetMapping("/projectName")
	public ResponseEntity<String> getProjectName(){
		String res = "TestingProject";
		return ResponseEntity.ok(res);
	}
	
	@GetMapping("/getEmployeeDetails")
	public ResponseEntity<?>  getEmployeeDetails(){
		List<EmployeeDetails> res = this.empolyeeService.getEmployeeDetails();
		return ResponseEntity.ok(res);
	}
	
	@GetMapping("/getEmpById/{empId}")
	public ResponseEntity<?> getEmpById(@PathVariable("empId") String empId){
		EmployeeDetails res = empolyeeService.getEmpById(empId);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	@PostMapping("/saveDetails")
	public ResponseEntity<?> AddDetails(@Valid @RequestBody EmployeeDetails data){
		EmployeeDetails res = empolyeeService.AddEmployeeDetails(data);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	@PutMapping("/updateDetails/{id}")
	public ResponseEntity<?> updateEmployeeDetails(@Valid @RequestBody EmployeeDetails data,@PathVariable("id") String empId){
		EmployeeDetails response = empolyeeService.updateEmployeeDetails(data,empId);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmpDetails/{empId}")
	public ResponseEntity<?> deleteEmployeeDetails(@PathVariable("empId") String empId){
		String response = empolyeeService.deleteEmployeeDetails(empId);
		return  new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/collectByName")
	public ResponseEntity<?> collectByName(@RequestParam String value){
		List<EmployeeDetails> response = this.empolyeeService.collectByName(value);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
