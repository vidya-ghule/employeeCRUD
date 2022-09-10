package com.EmployeeCRUDoperations.employeeCRUD;

import com.EmployeeCRUDoperations.employeeCRUD.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class CacheManager {
    @Autowired
    DaoEmployee daoEmployee;
        //create employee in cache
      public static HashMap<Integer, Employee> chache=new HashMap<>();
        @Scheduled(cron = "* * * * * *")//this is a cron expected to call the function according to specific time
        public void loadcache(){
            System.out.println("chache started loading");
            List<Employee> employeeList=  daoEmployee.findAll();
            employeeList.forEach(employee ->chache.put(employee.getEid(),employee) );
            System.out.println("chache ending loading");
                }

    }

