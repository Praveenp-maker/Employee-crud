package com.kg.EmployeeCrud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.kg.EmployeeCrud.Model.EmpPojo;
import com.kg.EmployeeCrud.repository.EmpRepository;

@Service
public class EmpService {
	@Autowired
	EmpRepository empRep;
	

	public List<EmpPojo> getAllemployee() {
		List<EmpPojo> employees = new ArrayList<EmpPojo>();
		empRep.findAll().forEach(emp1 -> employees.add(emp1));
		return employees;
	}

	public EmpPojo findByValue(int Empid) {
		return empRep.findById(Empid).orElse(null);
	}

	public EmpPojo saveEmployee(EmpPojo emp) {
		return empRep.save(emp);
	}

	public List<EmpPojo> saveAllEmployee(List<EmpPojo> emp) {
		return empRep.saveAll(emp);
	}

	public void deleteSingleValue(int empid) {
		empRep.deleteById(empid);
	}

	public EmpPojo saveorupdate(EmpPojo pojonew) {
		
		return empRep.save(pojonew);
	}

//	public  EmpPojo update(int empid,EmpPojo pojonew) {
//		EmpPojo pojo=empRep.findById(empid).orElse(null);
//		
//		pojo.setEmpId(pojonew.getEmpId());
//		pojo.setAge(pojonew.getAge());
//		pojo.setEnative(pojonew.getEnative());
//		pojo.setExperience(pojonew.getExperience());
//		pojo.setName(pojonew.getName());
//		pojo.setRole(pojonew.getName());
//		
//		EmpPojo updated= empRep.save(pojo);
//		return updated;
//	}

//	public EmpPojo findByEmpName(String name) {
//		return empRep.findByName(name);
//	}

//	public EmpPojo updateemp(EmpPojo emppojo) {
//		EmpPojo existing=empRep.findById(EmpPojo.getEmpid()).orElse(null);
//	}
}
