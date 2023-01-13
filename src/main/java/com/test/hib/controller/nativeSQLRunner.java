package com.test.hib.controller;


import java.util.Iterator;
import java.util.List;
import org.hibernate.Filter;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
public class nativeSQLRunner {
    public static void main(String[] args)
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        // To get a physical connection
        // Query the database by means of specific tablename
        // straightaway. SQL should be like how we do
        // from SQLCommandline or workbench

        // USER_ID | age | city | email              | fullname | password | salary
        String userQuery = "select * from USER";
        // New instance of Query for the given SQL
        //SQLQuery sqlQuery1 = session.createSQLQuery(userQuery);
        NativeQuery sqlQuery1 = session.createSQLQuery(userQuery);

        // We will get the details via list
        List userList = sqlQuery1.list();
        Iterator userIterator = userList.iterator();
        while (userIterator.hasNext()) {
            Object[] object = (Object[])userIterator.next();
            System.out.println("User Id : " + object[0] +
                    " Age : " + object[1]
                    + " City : " + object[2]
                    + " email: " + object[3]		);
        }
        // Always good to clear
        // and close the session
        session.clear();
        session.close();
    }
}