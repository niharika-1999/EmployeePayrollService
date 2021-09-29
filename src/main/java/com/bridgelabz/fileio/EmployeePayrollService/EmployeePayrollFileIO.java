package com.bridgelabz.fileio.EmployeePayrollService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollFileIO {
	public static final String PAYROLL_FILE_NAME="C:\\Users\\Niharika Rao\\eclipse-workspace\\EmployeePayrollService\\src\\main\\java\\com\\bridgelabz\\fileio\\EmployeePayrollService\\PayrollFile.txt";
	public void writeData(List<EmployeePayrollData> employeePayrollList) 
	{
		StringBuffer empBuffer=new StringBuffer();
		employeePayrollList.forEach(employee->{
		String employeeDataString=employee.toString().concat("\n");
		empBuffer.append(employeeDataString);     
		});
		try 
		{
			Files.write(Paths.get(PAYROLL_FILE_NAME),empBuffer.toString().getBytes());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public long countEntries() 
	{
		long entries=0;
		try 
		{
			entries=Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return entries;
	}
}

