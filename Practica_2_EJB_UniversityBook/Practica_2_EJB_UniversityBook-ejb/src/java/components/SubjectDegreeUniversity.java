/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entities.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ignacio
 */
@Stateless
public class SubjectDegreeUniversity implements SubjectDegreeUniversityRemote {

    @EJB
    private StudyBeanRemote studyBean;
    
    @Override
    public java.util.HashMap<String, ArrayList<Subject>> getSubjectGroupByUniversity() {
        HashMap<String, ArrayList<Subject>> subjects = new HashMap<String, ArrayList<Subject>>();
        for(Subject subject : studyBean.getSubjects()){
            String clave = ""+ subject.getUniversity().getId();
            if(!subjects.containsKey(clave)){
                subjects.put(clave, new ArrayList<Subject>());
            }
            subjects.get(clave).add(subject);
        }
        return subjects;
    }
    
    
}
