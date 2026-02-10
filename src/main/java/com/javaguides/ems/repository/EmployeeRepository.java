package com.javaguides.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaguides.ems.entity.Employee;

//Jpa repository is a generic interface it accepts 2 parameters one is entity class and second onw is prmairy key type

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
