package com.telrock;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.telrock.dao.DepartmentService;
import com.telrock.model.Department;

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:*/applicationContext.xml" })
@Transactional
public class DepartmentServiceTest {
	
	@Autowired
	DepartmentService deptService;
	
	@Test
	public void getOrCreateDepartment()
	{
	
	String DeptName = "Admin";
	String Area = "London";
	
	Department dept = deptService.getOrCreateDepartment(DeptName, Area);
	
	
	Assert.assertNotNull("The returned object can't be null", dept);
	Assert.assertNotNull("The id can't be null", dept.getId());
	Assert.assertTrue("The id has to be greater than 0", dept.getId() > 0);
	Assert.assertEquals(DeptName, dept.getName());
	Assert.assertEquals(Area, dept.getName());
	
	}
	
	@Test
	public void testgetDefaultDepartment()
	{
		Department dept = deptService.getDefaultDepartment();
		Assert.assertNotNull("The returned object can't be null", dept);
		Assert.assertNotNull("The id can't be null", dept.getId());
		Assert.assertTrue("The id has to be greater than 0", dept.getId() > 0);
		Assert.assertEquals(DepartmentService.DEFAULT_NAME, dept.getName());
		Assert.assertEquals(DepartmentService.DEFAULT_AREA, dept.getName());
	}
	
	@Test
	public void testfindDepartmentsInArea()
	{
		String Area = "London";
		List<Department> deptList = deptService.findDepartmentsInArea(Area);
		Assert.assertNotNull("The returned list can't be null", deptList);
		Assert.assertTrue("Size of list has to be greater than 0", deptList.size() > 0);
		Assert.assertEquals(Area, deptList.get(0).getArea());
		
	}
}
