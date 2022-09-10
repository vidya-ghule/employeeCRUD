package com.EmployeeCRUDoperations.employeeCRUD.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class Contact {
    @Id
    String place;
    Long phno;
}
