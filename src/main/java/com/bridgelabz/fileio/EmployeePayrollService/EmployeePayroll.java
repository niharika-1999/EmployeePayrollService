package com.bridgelabz.fileio.EmployeePayrollService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayroll {
	public enum IOService{CONSOLE_IO,FILE_IO,DB_IO,REST_IO}
	private List<EmployeePayrollData> employeePayrollList;
	public EmployeePayroll() {
		System.out.println("Welcome to Employee Payroll Service.");
	}
	/**
	 * Creating Employee Payroll class of id,name and salary
	 * @param employeePayrollList
	 */
	public EmployeePayroll(List<EmployeePayrollData>employeePayrollList)
	{
		this.employeePayrollList = employeePayrollList;
	}

	private void readEmployeePayrollData(Scanner consoleInput) {
		System.out.println("Enter Employee ID: ");
		int id = consoleInput.nextInt();
		System.out.println("Enter Employee Name: ");
		String name = consoleInput.next();
		System.out.println("Enter Employee Salary: ");
		double salary = consoleInput.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id,name,salary));
	}

	private void writeEmployeePayrollData(Scanner consoleInputReader) 
	{
		System.out.println("\n Writing Employee Payroll Roaster to Console \n" + employeePayrollList);
	}

	public static void main(String[] args) 
	{
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmployeePayroll employeePayrollService = new EmployeePayroll(employeePayrollList);
		Scanner consoleInputReader = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData(consoleInputReader);
		employeePayrollService.writeEmployeePayrollData(consoleInputReader);
		consoleInputReader.close();
	}
}



