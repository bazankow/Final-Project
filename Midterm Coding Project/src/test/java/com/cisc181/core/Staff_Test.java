package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;


public class Staff_Test {

	@BeforeClass
	public static void setup() throws PersonException {
		
		
	}
	
	@Test(expected=PersonException.class)
	public void test() throws PersonException {
		ArrayList<Staff> staff = new ArrayList<Staff>();
		Date date = new Date();
		Staff staff1 = new Staff("B", "A", "Z", date, "home", "(610)-504-2012", "bazank@udel.edu",
						"Deffinetly not", 10, 1000.00, date, eTitle.MASTER);
		Staff staff2 = new Staff("B", "A", "Z", date, "home", "(610)-504-2012", "bazank@udel.edu",
				"Deffinetly not", 10, 100.00, date, eTitle.MASTER);
		Staff staff3 = new Staff("B", "A", "Z", date, "home", "(610)-504-2012", "bazank@udel.edu",
				"Deffinetly not", 10, 2000.00, date, eTitle.MASTER);
		Staff staff4 = new Staff("B", "A", "Z", date, "home", "(610)-504-2012", "bazank@udel.edu",
				"Deffinetly not", 10, 1400.00, date, eTitle.MASTER);
		Staff staff5 = new Staff("B", "A", "Z", date, "home", "(610)-504-2012", "bazank@udel.edu",
				"Deffinetly not", 10, 1600.00, date, eTitle.MASTER);
		staff.add(staff1);
		staff.add(staff2);
		staff.add(staff3);
		staff.add(staff4);
		staff.add(staff5);	
		double sum = 0;
		for(Staff s : staff){
			sum = sum + s.getSalary();			
		}
		double average = sum/staff.size();
		System.out.println(average);
		
		assertEquals(average,1220.0);
		
		Staff staff6 = new Staff("B", "A", "Z", date, "home", "(61b)-504-2012", "bazank@udel.edu",
				"Deffinetly not", 10, 1600.00, date, eTitle.MASTER);
	}
	@Test(expected=PersonException.class)
	public void test2() throws PersonException
	{
		Date date2 = new Date(10,15,12);
		System.out.println(date2);
		Staff staff7 = new Staff("B", "A", "Z", date2, "home", "(610)-504-2012", "bazank@udel.edu",
				"Deffinetly not", 10, 1600.00, date2, eTitle.MASTER);
	}
	

	private void assertEquals(double average, double d) {
		// TODO Auto-generated method stub
		
	}	

}
