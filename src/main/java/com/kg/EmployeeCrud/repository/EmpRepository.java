package com.kg.EmployeeCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kg.EmployeeCrud.Model.EmpPojo;

@Repository
public interface EmpRepository extends JpaRepository<EmpPojo, Integer> {

}
