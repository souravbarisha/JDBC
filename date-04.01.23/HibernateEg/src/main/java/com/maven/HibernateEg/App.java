package com.maven.HibernateEg;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       //Configuration- activates hibernate framework
    	//configure- read both cfg files and mapping details
    	//buildSessionFactory- from cfg object it takes jdbc information and create a jdbc connection
    	SessionFactory s = new Configuration().configure().buildSessionFactory();
    	//opens an connection with db and session object perform CURD
    	Session ses = s.openSession(); // one of the method od session factory to get session obj
    	//operation performed in db, save permanent
    	Transaction t = ses.beginTransaction();
    	//create object of presistent class
        Student s1 = new Student();
        // use object to enter data in table using setter method
        s1.setStuId(101);
        s1.setStuFirstName("Sourav");
        s1.setStuLastName("Das");
        s1.setStuEmail("souravbarisha@gmail.com");
        s1.setStuPhone(875953332);
        s1.setStuAddr("Medinipur");
        s1.setStuFees(8000.00);
        // session object is used to save the persistent object
        ses.save(s1);
        //transaction object to commit change
        t.commit();
        // closing session
        ses.close();
        
    }
}
