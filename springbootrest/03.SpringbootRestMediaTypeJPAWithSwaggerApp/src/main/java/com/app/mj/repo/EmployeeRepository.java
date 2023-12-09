package com.app.mj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.mj.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
