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
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author ignacio
 */
@Stateless
public class SubjectsOperation implements SubjectsOperationRemote {

    @EJB
    private StudyBeanRemote studyBean;
    private StatisticBeanRemote statisticBean;
    private LogBeanRemote logBean;
    
    @PostConstruct
    public void init(){
        try {
            statisticBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/StatisticBean!components.StatisticBeanRemote");
            logBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/LogBean!components.LogBeanRemote");            
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        statisticBean.addMapNumberInvokeBean("SubjectsOperation");
        logBean.writeLogEJBInfo("SubjectsOperation::init::Llamada al PostConstruct");
    }
 
    @Override
    public int[] getNumberSubjectsByCourse() {
        statisticBean.addMapNumberInvokeBean("SubjectsOperation");
        logBean.writeLogEJBInfo("SubjectsOperation::getNumberSubjectsByCourse::Obtiene el número de asignaturas por curso");
        int[] numberSubjectByCourse = new int[4];
        for (Subject subject : studyBean.getSubjects()) {
            if (subject.getCourse() == 1) {
                numberSubjectByCourse[0] = numberSubjectByCourse[0] + 1;
            } else if (subject.getCourse() == 2) {
                numberSubjectByCourse[1] = numberSubjectByCourse[1] + 1;
            } else if (subject.getCourse() == 3) {
                numberSubjectByCourse[2] = numberSubjectByCourse[2] + 1;
            } else if (subject.getCourse() == 4) {
                numberSubjectByCourse[3] = numberSubjectByCourse[3] + 1;
            }
        }
        return numberSubjectByCourse;
    }

}
