package com.allAnotation.testing.AnotationsTesting.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.allAnotation.testing.AnotationsTesting.Entity.EmployeeDetails;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails,Integer>{

	EmployeeDetails findByEmpId(String empId);
	
//	@Query("DELETE FROM Employee_Details s WHERE s.emp_id = ?")
//	int deleteByEmpId(String empId);
	
    @Query("DELETE FROM EmployeeDetails e WHERE e.empId = :empId")
    int deleteByEmpId(@Param("empId") String empId);
    
//    @Modifying
//    @Transactional
//    @Query("select e from EmployeeDetails e WHERE e.empId = :empId")
//    EmployeeDetails findById(@Param("empId") String empId);
	
    @Query("select n from EmployeeDetails n where n.name like :name%")
	List<EmployeeDetails> collectByName(@Param("name") String value);
}
