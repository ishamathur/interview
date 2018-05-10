/*
 * Copyright Telrock Communications Limited 2008 * 
 *
 * $Header:  $
 * $Revision:  $
 * $Date:  $ 
 * 
 */
package com.telrock.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.telrock.model.Department;

@Repository
public class DepartmentServiceImpl implements DepartmentService
{
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public Department getOrCreateDepartment(String departmentName, String area)
	{
		
		Department dept = (Department) em.createQuery("select d from Department d where d.name = :name").setParameter("name", departmentName).getSingleResult();
		if(dept != null) {
			return dept;
		}
		else
		{
			Department department = new Department(departmentName, area);
			em.persist(department);
			em.flush();
			return department;
		}
			
			
	}

	@Transactional
	public Department getDefaultDepartment()
	{
		Query query= em.createQuery("select d from Department d where d.name = :name and d.area = :area");
		query.setParameter("name", DEFAULT_NAME);
		query.setParameter("area", DEFAULT_AREA);
		Department dept = (Department) query.getSingleResult();
		return dept;
	}

	@Transactional
	public List<Department> findDepartmentsInArea(String area)
	{
		List<Department> deptList = em.createQuery("select d from Department d where d.area = :area").setParameter("area", area).getResultList();
		return deptList;
	}
}
