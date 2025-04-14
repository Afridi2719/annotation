package com.allAnotation.testing.AnotationsTesting.Entity;


import java.util.Objects;

import org.hibernate.validator.constraints.NotEmpty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EmployeeDetails")
public class EmployeeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@NotNull(message = "empolyee id can't be null")
	@NotEmpty(message = "empolyee id can't be empty")
	@Column(name = "emp_id")
	private String empId;
	
	
	public EmployeeDetails(int id, String name, String empId) {
		super();
		this.id = id;
		this.name = name;
		this.empId = empId;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmpId() {
		return empId;
	}


	public void setEmpId(String empId) {
		this.empId = empId;
	}


	@Override
	public String toString() {
		return "EmployeeDetails [id=" + id + ", name=" + name + ", empId=" + empId + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(empId, id, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDetails other = (EmployeeDetails) obj;
		return Objects.equals(empId, other.empId) && id == other.id && Objects.equals(name, other.name);
	}


	public EmployeeDetails() {
		super();
	}

}
