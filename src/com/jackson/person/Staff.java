//$Id$
package com.jackson.person;

import java.math.BigDecimal;
import java.util.List;

public class Staff {

	private String name;
	private int age;
	private String position;
	private BigDecimal salary;
	private List<String> skills;
	
	public Staff(){
		
	}
	public Staff(String name, int age, String position, BigDecimal salary,
			List<String> skills) {
		super();
		this.name = name;
		this.age = age;
		this.position = position;
		this.salary = salary;
		this.skills = skills;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
	@Override
	public String toString() {
	StringBuilder staff_toString = new StringBuilder();
	staff_toString.append("name : "+getName()+" age : "+getAge()+" salary : "+getSalary()+" skills : "+getSkills());
		return staff_toString.toString();
	}
}
