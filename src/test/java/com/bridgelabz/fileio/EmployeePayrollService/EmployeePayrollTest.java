package com.bridgelabz.fileio.EmployeePayrollService;
import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;
import com.bridgelabz.fileio.EmployeePayrollService.EmployeePayroll.IOService;
/**
 * EmployeePayrollTest to test the output of the file
 * @author Niharika Rao
 *
 */
public class EmployeePayrollTest {
	@Test 
	public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries() 
	{
		EmployeePayrollData[] arrayOfEmps= {
				new EmployeePayrollData(1," Jeff Bezos",100000.0),
				new EmployeePayrollData(2,"Bill Gates",200000.0),
				new EmployeePayrollData(3,"Mark Zuckerberg",300000.0)
		};
		EmployeePayroll employeePayrollService;
		employeePayrollService =new EmployeePayroll(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
		long entries=employeePayrollService.countEntries(IOService.FILE_IO);
		assertEquals(3,entries);
	}
}

