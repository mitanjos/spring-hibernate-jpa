package com.techcielo.sampleproject.service;

import com.techcielo.sampleproject.bean.EmployeeBean;
import com.techcielo.sampleproject.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EmployeeService {

	@Autowired
	EmployeeDAO empDao;	

	public void setEmpDao(EmployeeDAO empDao) {
		this.empDao = empDao;
	}


	
	public String getEmployee(String dbName,Integer employeeId) throws Exception{
		System.out.println("Getting Employee from DAO..");
		EmployeeBean bean = empDao.getEmployee(dbName,employeeId);
		System.out.println("Got retply from DAO");
		empDao.updateEmployee(dbName, employeeId, "Hitasha".equalsIgnoreCase(bean.getName())?"Bhavika":"Hitasha");
		bean = empDao.getEmployee(dbName,employeeId);
		return bean.getName();
	}
}
