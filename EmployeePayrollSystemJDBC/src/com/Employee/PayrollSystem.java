package com.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PayrollSystem {
	private ArrayList<Employee> employeeList;
	private Connection connection;

	public PayrollSystem() {
		employeeList = new ArrayList<Employee>();
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##emp", "123");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addEmployee(Employee employee) {
		employeeList.add(employee);
		try {
			String sql = "insert into employees (id,name,employee_type, monthly_salary, hours_worked, hourly_rate) values (?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, employee.getId());
			statement.setString(2, employee.getName());
			if (employee instanceof FullTimeEmployee) {
				statement.setString(3, "FullTime");
				statement.setDouble(4, ((FullTimeEmployee) employee).calculateSalary());
				statement.setNull(5, java.sql.Types.INTEGER);
				statement.setNull(6, java.sql.Types.DOUBLE);

			} else if (employee instanceof PartTimeEmployee) {
				PartTimeEmployee partTimeEmployee = (PartTimeEmployee) employee;
				statement.setString(3, "PartTime");
				statement.setNull(4, java.sql.Types.DOUBLE);
				statement.setDouble(5, partTimeEmployee.getHoursWorked());
				statement.setDouble(6, partTimeEmployee.getHourlyRate());
			}
			statement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void removeEmployee(int id) {
		Employee employeeToEmployee = null;
		for (Employee employee : employeeList) {
			if (employee.getId() == id) {
				employeeToEmployee = employee;
				break;
			}
		}
		if (employeeToEmployee != null) {
			employeeList.remove(employeeToEmployee);
			try {
				String sql = "delete from employees where id =?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, id);
				statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void displayEmployees() {
		employeeList.clear();// Clear the list to avoid duplication
		try {
			String sql = "select * from employees";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String employeeType = resultSet.getString("employee_type");
				double monthlySalar = resultSet.getDouble("monthly_salary");
				int hoursWorked = resultSet.getInt("hours_worked");
				double hourlyRate = resultSet.getDouble("hourly_rate");
				Employee employee;
				if ("FullTime".equals(employeeType)) {
					employee = new FullTimeEmployee(name, id, monthlySalar);

				} else {
					employee = new PartTimeEmployee(name, id, hoursWorked, hourlyRate);

				}
				employeeList.add(employee);
				System.out.println(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
