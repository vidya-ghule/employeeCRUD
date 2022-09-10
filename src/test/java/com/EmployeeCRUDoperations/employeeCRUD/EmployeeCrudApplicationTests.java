package com.EmployeeCRUDoperations.employeeCRUD;

import com.EmployeeCRUDoperations.employeeCRUD.Entity.Employee;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeCrudApplicationTests {
@Autowired
	DaoEmployee daoEmployee;
	@Test
@Order(1)
	void contextLoads() {
	}
	@Test
	@Order(2)
	public void testallEmp() throws URISyntaxException {
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/employee/postEmp";
		URI uri=new URI(url);
		ResponseEntity<String> response=restTemplate.getForEntity(uri,String.class);
		Assertions.assertEquals(200,response.getStatusCodeValue());
	}
	@Test
	@Order(3)
	public void testupdateEmp() throws URISyntaxException {
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/employee/update/1";
		URI uri=new URI(url);
		Employee emp=new Employee(11,"vedu",20000);
		HttpHeaders httpHeaders=new HttpHeaders();
		HttpEntity<Employee> httpEntity=new HttpEntity<>(emp,httpHeaders);
		ResponseEntity<String> response=restTemplate.exchange(url,HttpMethod.PUT,httpEntity,String.class);
		Assertions.assertEquals(200,response.getStatusCodeValue());
	}
	@Test
	@Order(4)
	public void testpostEmp() throws URISyntaxException {
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/employee/postEmp/1";
		URI uri=new URI(url);
		ResponseEntity<Employee> response=restTemplate.getForEntity(uri,Employee.class);
		Assertions.assertEquals(200,response.getStatusCodeValue());
	}
	@Test
	@Order(5)
	public void testaddEmp() throws URISyntaxException {
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/employee/addEmp";
		URI uri=new URI(url);
		Employee emp=new Employee(11,"vedu",20000);
		HttpHeaders httpHeaders=new HttpHeaders();
		HttpEntity<Employee> httpEntity=new HttpEntity<>(emp,httpHeaders);
		ResponseEntity<Employee> response=restTemplate.exchange(url,HttpMethod.POST,httpEntity,Employee.class);
		Assertions.assertEquals(200,response.getStatusCodeValue());
	}
	@Test
	@Order(6)
	public void testDeleteEmp() throws URISyntaxException {
		RestTemplate restTemplate=new RestTemplate();
		Employee emp=new Employee(11,"vedu",20000);
		HttpHeaders httpHeaders=new HttpHeaders();
		HttpEntity<Employee> httpEntity=new HttpEntity<>(emp,httpHeaders);
		String url="http://localhost:8080/employee/delete/11";
		URI uri=new URI(url);
		ResponseEntity<String> response=restTemplate.exchange(url,HttpMethod.DELETE,httpEntity,String.class);
		Assertions.assertEquals(200,response.getStatusCodeValue());
	}
}
