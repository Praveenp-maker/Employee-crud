package com.kg.EmployeeCrud.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_DETAILS")
public class EmpPojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int empId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ROLE")
	private String role;

	@Column(name = "AGE")
	private int age;

	@Column(name = "EXPERIENCE")
	private int experience;

	@Column(name = "NATIVE")
	private String enative;

	public EmpPojo() {
		super();
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getEnative() {
		return enative;
	}

	public void setEnative(String enative) {
		this.enative = enative;
	}

	@Override
	public String toString() {
		return "EmpPojo [empId=" + empId + ", name=" + name + ", role=" + role + ", age=" + age + ", experience="
				+ experience + ", enative=" + enative + "]";
	}

	public EmpPojo(int empId, String name, String role, int age, int experience, String enative) {
		super();
		this.empId = empId;
		this.name = name;
		this.role = role;
		this.age = age;
		this.experience = experience;
		this.enative = enative;
	}

}
