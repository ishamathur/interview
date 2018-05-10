package com.telrock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Person entity
 * 
 * @author com.telrock
 */
@Entity
public class Person implements Comparable<Person>
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@Column
	private String surname;
	
	 @ManyToOne
	 @JoinColumn(name = "id")
	 private Department department;

	public Person()
	{
	}
	
	public Person(String name, String surname)
	{
		this.name = name;
		this.surname = surname;
	}
	
	public Person(String name, String surname ,Department Dept)
	{
		this.name = name;
		this.surname = surname;
		this.department = Dept;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString()
	{
		return "Person [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if(department ==null)
		{
			if(other.department!=null)
			return false;
		}else if (!department.equals(other.department))
			return false;
		return true;
	}

	@Override
	public int compareTo(Person obj) {
		Person other = (Person)obj;
		int nameDiff = name.compareTo(obj.name);
		if(nameDiff==0)
		{
			int surnameDiff = surname.compareTo(obj.surname);
			if(surnameDiff==0)
			{
				//return 0;
				int deptDiff = department.compareTo(other.department);
				if(deptDiff == 0)
					return 0;
				else
					return deptDiff;
					
			}
			else
				return surnameDiff;
		}
		else
			return nameDiff;
	}
	
	
}
