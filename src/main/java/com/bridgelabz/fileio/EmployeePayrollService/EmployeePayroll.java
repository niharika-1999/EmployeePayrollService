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

	public void writeEmployeePayrollData(IOService ioService) 
	{
		if(ioService.equals(IOService.CONSOLE_IO))
		{
			System.out.println("\n Writing Employee Payroll Roaster to Console\n"+ employeePayrollList);   
		}
		else if(ioService.equals(IOService.FILE_IO))
		{
			new EmployeePayrollFileIO().writeData(employeePayrollList);
		}
	}

	public long countEntries(IOService ioService)
	{  
		return new EmployeePayrollFileIO().countEntries();
	}

	public void printData()
	{
		new EmployeePayrollFileIO().printData();
	}



	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmployeePayroll employeePayrollService = new EmployeePayroll(employeePayrollList);
		Scanner consoleInput = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData(consoleInput);
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
		employeePayrollService.printData();
		consoleInput.close();

	}
}




