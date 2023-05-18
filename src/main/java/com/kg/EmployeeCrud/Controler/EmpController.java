package com.kg.EmployeeCrud.Controler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.kg.EmployeeCrud.Model.EmpPojo;
import com.kg.EmployeeCrud.repository.EmpRepository;
import com.kg.EmployeeCrud.service.EmpService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/employee")
public class EmpController {
	@Autowired
	private EmpService empService;
	@Autowired 
	private EmpRepository empRep;

	@GetMapping(value = "/list", headers = "Accept=application/json")

	public ResponseEntity<?> getAllData(HttpServletRequest req) {

		return new ResponseEntity<>(empService.getAllemployee(), HttpStatus.OK);

	}

	@PostMapping(value = "/saveInsert")

	public EmpPojo save(@RequestBody EmpPojo emppojo) {

		return empService.saveEmployee(emppojo);

	}

	@DeleteMapping("/delete/{empid}")
	private void deleteEmployee(@PathVariable int empid) {
		empService.deleteSingleValue(empid);
	}

	@PostMapping("/list")

	public List<EmpPojo> addEmployees(@RequestBody List<EmpPojo> emps) {
		return empService.saveAllEmployee(emps);

	}

	@GetMapping(value = "/listById/{empid}", headers = "Accept=application/json")

	public ResponseEntity<?> findByValue(HttpServletRequest req, @PathVariable int empid) {

		return new ResponseEntity<>(empService.findByValue(empid), HttpStatus.OK);

	}
	
//	@PutMapping("/update")
//	public EmpPojo update(@RequestParam int empid, @RequestBody EmpPojo pojonew ) {
//		System.out.println(empid);
//		return empService.saveorupdate(pojonew);
//
//		
//	}
//	@PutMapping("/update/{empid}")
//	public ResponseEntity<EmpPojo> updateEmployee(@RequestParam(value="id") int empId, @RequestBody EmpPojo employeeDetails) throws AttributeNotFoundException {
//		EmpPojo employee = empRep.findById(empId)
//				.orElseThrow(() -> new AttributeNotFoundException("Employee not exist with id :" + empId));
//		
//		employee.setAge(employeeDetails.getAge());
//		employee.setName(employeeDetails.getName());
//		employee.setEmpId(employeeDetails.getEmpId());
//		employee.setEnative(employeeDetails.getEnative());
//		employee.setExperience(employeeDetails.getExperience());
//		employee.setRole(employeeDetails.getRole());
//		
//		EmpPojo updatedEmployee = empRep.save(employee);
//		return ResponseEntity.ok(updatedEmployee);
//	}
//	

}
