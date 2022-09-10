package com.EmployeeCRUDoperations.employeeCRUD.Service;
import com.EmployeeCRUDoperations.employeeCRUD.CacheManager;
import com.EmployeeCRUDoperations.employeeCRUD.DaoEmployee;
import com.EmployeeCRUDoperations.employeeCRUD.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class serviceImpl implements serviceinterface{
    @Autowired
    DaoEmployee daoEmployee;
    @Override
    public boolean addemployee(Employee employee) {
        daoEmployee.save(employee);
        return false;
    }

    @Override
    public Employee addemp(Employee employee)
    {
        System.out.println(employee);
        return daoEmployee.save(employee);
    }

    @Override
    public Employee postemp(int id)
    {
        return  CacheManager.chache.get(id);
    //    return daoEmployee.findById(id);
    }

    @Override
    public String Allemp() {

return CacheManager.chache.values().toString();
       // return (List<Employee>) daoEmployee.findAll();
    }

    @Override
    public String updateemp(int id, Employee employee) {

       Optional<Employee> emp=daoEmployee.findById(id);

       if(emp.isPresent()){
         String s=  daoEmployee.save(employee).toString();
           System.out.println("hiii  "+s);
          return s;
       }else {
           return "the employee having +id + is not present";
       }

    }

    @Override
    public String deleteemp(int id) {
        Optional<Employee> emp=daoEmployee.findById(id);

        if(emp.isPresent()){
            daoEmployee.deleteById(id);

            return "employee deleted sucessfully";
        }else {
            return "employee not present of this id";
        }
    }


}
