package com.EmployeeCRUDoperations.employeeCRUD.Entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

   private int eid;
    private String name;
    private Integer salary;

    public Employee() {
    }

    public Employee(int eid, String name, Integer salary) {
          }

    //    @OneToOne(cascade= CascadeType.ALL)
//    private Contact contact;
}
