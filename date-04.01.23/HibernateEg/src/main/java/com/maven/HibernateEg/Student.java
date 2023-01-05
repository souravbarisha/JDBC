package com.maven.HibernateEg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
// @Entity - This annotation specifies that the class is an entity
// Table - This annotation specifies the table in the database with which this entity is mapped.
// @ID - This annotation specifies the primary key of the Entity.

@Getter
@Setter
@Entity // marking this class as Entity
// specifies the table name where data base of this entity is to be persisted.
@Table(name = "Student_Info")

public class Student {
	@Id //Marks identifier of class
	private int StuId;
	private String stuFirstName,stuLastName,stuEmail,stuAddr;
	private double stuFees;
	private long stuPhone;
}
