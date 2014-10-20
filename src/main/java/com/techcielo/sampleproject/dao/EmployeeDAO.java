package com.techcielo.sampleproject.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.techcielo.sampleproject.bean.EmployeeBean;

@Transactional
public class EmployeeDAO {
	@Autowired
	@Qualifier("contextMapFactory")
	CustomEntityManagerFactory fac;

	public EmployeeBean getEmployee(String dbName, Integer empId)
			throws Exception {
		System.out.println("Getting employee");
		EmployeeBean bean = null;
		if (fac != null) {
			EntityManager em=null;
			if ((em=fac.getEm(dbName)) != null) {
				System.out.println("Enitity Manager:" + em);
				bean = (EmployeeBean) em
						.createQuery(
								"FROM EmployeeBean where employeeId=:empId")
						.setParameter("empId", empId).getSingleResult();
			} else {
				throw new Exception("Entity Manager is null");
			}
		} else {
			throw new Exception("Factory is null");
		}
		return bean;
	}

	public void updateEmployee(String dbname, Integer id, String name) {
		System.out.println("Updating Employee");
		if (fac != null) {
			EntityManager em = fac.getEm(dbname);
			System.out.println("Enitity Manager:" + em);
			EmployeeBean bean = em.find(EmployeeBean.class, id);
			bean.setName(name);
			em.persist(bean);
		}
	}
}
