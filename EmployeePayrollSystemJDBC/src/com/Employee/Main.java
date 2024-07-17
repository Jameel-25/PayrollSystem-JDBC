package com.Employee;

public class Main {
	public static void main(String[] args) {
		PayrollSystem payrollSystem = new PayrollSystem();
		FullTimeEmployee emp1 = new FullTimeEmployee("Vikas", 1, 70000);
		FullTimeEmployee emp2 = new FullTimeEmployee("John", 2, 89000);
		FullTimeEmployee emp3 = new FullTimeEmployee("Mohan", 3, 87900);
		PartTimeEmployee emp4 = new PartTimeEmployee("Alexander", 4, 40, 100);
		PartTimeEmployee emp5 = new PartTimeEmployee("Raju", 5, 35, 105);
		PartTimeEmployee emp6 = new PartTimeEmployee("Hamid", 6, 45, 110);

		payrollSystem.addEmployee(emp1);
		payrollSystem.addEmployee(emp2);
		payrollSystem.addEmployee(emp3);
		payrollSystem.addEmployee(emp4);
		payrollSystem.addEmployee(emp5);
		payrollSystem.addEmployee(emp6);
		System.out.println("Initial Employee Details: ");
		payrollSystem.displayEmployees();

		System.out.println("Removing Employees");
		payrollSystem.removeEmployee(3);
		payrollSystem.removeEmployee(5);

		System.out.println("Remaining Employee Details: ");
		payrollSystem.displayEmployees();
	}
}
