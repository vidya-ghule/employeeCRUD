package com.EmployeeCRUDoperations.employeeCRUD.Controller;

import com.EmployeeCRUDoperations.employeeCRUD.Entity.Employee;
import com.EmployeeCRUDoperations.employeeCRUD.Service.serviceinterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class controller {
    @Autowired
    serviceinterface seri;
    //create employee in cache
    HashMap<Integer,Employee> hashmaps=new HashMap<>();
    @RequestMapping("/create")
    public String addemployee1(@RequestBody Employee employee)
    {
        Employee emp=new Employee();
        emp.setEid(employee.getEid());
        emp.setName(employee.getName());
        emp.setSalary(employee.getSalary());
      //  emp.setContact(employee.getContact());
        hashmaps.put(emp.getEid(), emp);
        Employee returnemploee=hashmaps.get(emp.getEid());
       return returnemploee.toString();
        }
        @GetMapping("/msg/{name1}")
        public String greetingMsg1(@PathVariable  String name1) {

            if (LocalTime.now().getHour() < 12 && LocalTime.now().getHour() > 12) {
                String s = "Good Morning";
                return ("hello " + name1 + " " + s);
            } else if (LocalTime.now().getHour() > 12 && LocalTime.now().getHour() < 17) {
                String s = "Good Afternoon";
                return ("hello " + name1 + " " + s);
            } else {
                String s = "Good Night";
                return ("hello " + name1 + " " + s);
            }

    }
    @PostMapping("/addEmp")
    public Employee addEmp(@RequestBody Employee employee){
        System.out.println("hii "+employee);
        return seri.addemp(employee);
    }
    @GetMapping("/postEmp/{id}")
    public Employee postEmp(@PathVariable int id){

        return seri.postemp(id);
    }
    @GetMapping("/postEmp")
    public String allEmp(){
        String emp=seri.Allemp();
        return emp;
    }
@PutMapping("update/{id}")
public String updateEmp(@PathVariable int id, @RequestBody Employee employee)
{
    return seri.updateemp(id,employee);
}
@DeleteMapping("delete/{id}")
    public String deletemp(@PathVariable int id)
{
    return seri.deleteemp(id);
}


    }

