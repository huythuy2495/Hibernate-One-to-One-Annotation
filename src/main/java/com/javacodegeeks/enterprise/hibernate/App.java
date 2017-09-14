package com.javacodegeeks.enterprise.hibernate;


import java.util.Date;

import org.hibernate.Session;
import com.javacodegeeks.enterprise.hibernate.utils.HibernateUtil;;

public class App 
{
    public static void main( String[] args )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Student student = new Student();

        student.setStudentName("JavaFun");
        student.setStudentAge("19");
        
        StudentInformation studentInfo = new StudentInformation();
        
        studentInfo.setAddress("1st Street");
        studentInfo.setPhoneNumber("982349823");
        studentInfo.setRegistryNumber("ax203");
        studentInfo.setEnlisted(new Date());
        
        studentInfo.setStudent(student);
        student.setStudentInfo(studentInfo);

        session.save(student);
        session.getTransaction().commit();
        System.out.println("Great! Student was saved");
    }
}