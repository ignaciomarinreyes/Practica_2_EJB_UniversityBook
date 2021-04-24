/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entities.Degree;
import entities.Subject;
import entities.University;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author ignacio
 */
@Remote
public interface StudyBeanRemote {

    ArrayList<University> getUniversities();

    ArrayList<Degree> getDegrees();

    ArrayList<Subject> getSubjects();

    Subject getSubjectById(int idSubject);
    
}
