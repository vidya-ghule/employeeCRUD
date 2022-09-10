package com.EmployeeCRUDoperations.employeeCRUD;

import com.EmployeeCRUDoperations.employeeCRUD.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DaoEmployee extends JpaRepository<Employee,Integer> {
}
