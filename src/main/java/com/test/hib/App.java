package com.test.hib;

import com.test.hib.controller.findUser_Hql;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        findUser_Hql u = new findUser_Hql();
       // u.findUser();
        //u.findUserSelect();
       // u.getRecordbyId();
        //u.getrecords();
        //u.getmaxSalary();
        u.getmaxSalaryGroupBy();
    }


}

