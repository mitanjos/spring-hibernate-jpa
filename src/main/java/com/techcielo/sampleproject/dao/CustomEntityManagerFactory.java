package com.techcielo.sampleproject.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
@Transactional
public class CustomEntityManagerFactory {

	@PersistenceContext(unitName = "db-sg")
	private EntityManager sgEm;

	@PersistenceContext(unitName = "db-tw")
	private EntityManager twEm;

	public EntityManager getEm(String groupname) {
		switch (groupname.toUpperCase()) {
		case "SG":
			System.out.println("Returning SG DB"+sgEm);
			return sgEm;
		case "TW":
			System.out.println("Returing TW DB"+twEm);
			return twEm;
		default:
			System.out.println("Returing null");
			return null;
		}
	}
}
