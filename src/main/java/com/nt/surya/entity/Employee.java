package com.nt.surya.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "emptab")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "eid")
	private Integer id;
	
	@Column(name = "ename")
	private String empName;
	
	@Column(name = "esal")
	private Double empSal;
	
	@Column(name = "edept")
	private String empDept;
	
	@Column(name = "eaddr")
	private String empAddr;
}
