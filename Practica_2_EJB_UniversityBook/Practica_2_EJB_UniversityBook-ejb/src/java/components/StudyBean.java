/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import data.Data;
import entities.Degree;
import entities.Subject;
import entities.University;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Startup
@Singleton
public class StudyBean implements StudyBeanRemote {

    private ArrayList<University> universities;
    private ArrayList<Degree> degrees;
    private ArrayList<Subject> subjects;
    private StatisticBeanRemote statisticBean;
    private LogBeanRemote logBean;
    
    @PostConstruct
    public void init(){
        universities = new ArrayList<University>();
        degrees = new ArrayList<Degree>();
        subjects = new ArrayList<Subject>();
        universities.addAll(Data.getUniversities());
        degrees.addAll(Data.getDegrees());
        subjects.addAll(Data.getSubjects());
        try {
            statisticBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/StatisticBean!components.StatisticBeanRemote");
            logBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/LogBean!components.LogBeanRemote");            
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        statisticBean.addMapNumberInvokeBean("StudyBean");
        logBean.writeLogEJBInfo("StudyBean::init::Llamada al PostConstruct");
    }

    @Override
    public ArrayList<University> getUniversities() {
        statisticBean.addMapNumberInvokeBean("StudyBean");
        logBean.writeLogEJBInfo("StudyBean::getUniversities::Obtiene las universidades");
        return universities;
    }

    @Override
    public ArrayList<Degree> getDegrees() {
        statisticBean.addMapNumberInvokeBean("StudyBean");
        logBean.writeLogEJBInfo("StudyBean::getDegrees::Obtiene los grados");        
        return degrees;
    }

    @Override
    public ArrayList<Subject> getSubjects() {
        statisticBean.addMapNumberInvokeBean("StudyBean");
        logBean.writeLogEJBInfo("StudyBean::getSubjects::Obtiene las asignaturas");
        return subjects;
    }  

    @Override
    public Subject getSubjectById(int idSubject) {
        statisticBean.addMapNumberInvokeBean("StudyBean");
        logBean.writeLogEJBInfo("StudyBean::getSubjectById::Obtiene las asignaturas por ID");
        for(Subject subject :subjects){
            if(subject.getId() == idSubject){
                return subject;
            }
        }
        return null;
    }
  
    
}
