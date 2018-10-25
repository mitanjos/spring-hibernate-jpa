package com.techcielo.sampleproject.service.test;

import com.techcielo.sampleproject.service.EmployeeService;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpServiceTest extends TestCase{

	private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");;
	private EmployeeService svc;
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		svc = (EmployeeService) ctx.getBean("empSvc");
	}
	public void testGetSGEmployee(){
		try {
			System.out.println(svc.getEmployee("SG",1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void testGetTWEmployee(){
		try {
			System.out.println(svc.getEmployee("TW",1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
