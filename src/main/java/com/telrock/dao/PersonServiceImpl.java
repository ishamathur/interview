package com.telrock.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.telrock.model.Department;
import com.telrock.model.Person;

/**
 * DAO implementation for Person entity
 * 
 * @author telrock.com
 */
@Repository
public class PersonServiceImpl implements PersonService
{
	/*@PersistenceContext
	private EntityManager em;
*/
	protected EntityManager entityManager;
	 
    public EntityManager getEntityManager() {
        return entityManager;
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Transactional
	public Person save(Person person)
	{
	entityManager.persist(person);
		entityManager.flush();
		return person;
	}
    
    @Transactional
	public void setDefaultDepartment(Person person)
	{
		Department dept = new Department(DepartmentService.DEFAULT_NAME, DepartmentService.DEFAULT_AREA);
		person.setDepartment(dept);
		entityManager.persist(person);
	}
}
