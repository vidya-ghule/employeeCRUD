package com.EmployeeCRUDoperations.employeeCRUD.Service;

import com.EmployeeCRUDoperations.employeeCRUD.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface serviceinterface {
    public  boolean addemployee(Employee  employee);

    Employee addemp(Employee employee);

    Employee postemp(int id);

    String Allemp();

    String updateemp(int id, Employee employee);

    String deleteemp(int id);
}

