package com.app.HibernateWithMaven;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
       SessionFactory sf = new Configuration().configure().buildSessionFactory();
       
       
       System.out.println(sf);
       System.out.println(sf.isClosed());
    }
}
