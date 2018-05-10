package com.telrock;

import static org.junit.Assert.*;

import org.junit.Test;

import com.telrock.model.Department;
import com.telrock.model.Person;

public class HashCodeandEqualTest {
	
	@Test
	public void testEqual()
	{
		Department admin = new Department("admin", "London");
		Department finance = new Department("finance","London");
		
		Person james = new Person("james", "andrew",admin);
		Person same = new Person ("james","andrew", admin);
		Person similar = new Person("james","andrew", finance);
		
		
		
		assertFalse(admin.equals(finance));
		assertFalse(admin.hashCode() == finance.hashCode());
		
		assertNotEquals(0, admin.compareTo(finance));
		
		
	
		assertTrue(james.equals(same));
		assertTrue(james.hashCode() == same.hashCode());
		assertEquals(0, james.compareTo(same));
		
		assertFalse(james.equals(similar));
		assertFalse(james.hashCode() == similar.hashCode());
		assertNotEquals(0, james.compareTo(similar));
	}

}
