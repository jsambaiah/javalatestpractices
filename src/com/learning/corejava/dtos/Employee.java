/**
 * 
 */
package com.learning.corejava.dtos;

/**
 * @author ACJW8ZZ
 *
 */
public class Employee {
	private Integer id;
	private String name;
	private Double salary;

	/**
	 * @param id
	 * @param name
	 * @param salary
	 */
	public Employee(Integer id, String name, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the salary
	 */
	public Double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	/**
	 * Adds the given amount to salary.
	 * 
	 * @param increment
	 */
	public void salaryIncrement(Double increment) {
		this.salary = this.salary + increment;
	}
}
