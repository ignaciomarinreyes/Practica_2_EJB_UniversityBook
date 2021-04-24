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
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class StudyBean implements StudyBeanRemote {

    private ArrayList<University> universities;
    private ArrayList<Degree> degrees;
    private ArrayList<Subject> subjects;
    
    @PostConstruct
    public void init(){
        universities = new ArrayList<University>();
        degrees = new ArrayList<Degree>();
        subjects = new ArrayList<Subject>();
        universities.addAll(Data.getUniversities());
        degrees.addAll(Data.getDegrees());
        subjects.addAll(Data.getSubjects());
    }

    @Override
    public ArrayList<University> getUniversities() {
        return universities;
    }

    @Override
    public ArrayList<Degree> getDegrees() {
        return degrees;
    }

    @Override
    public ArrayList<Subject> getSubjects() {
        return subjects;
    }  

    @Override
    public Subject getSubjectById(int idSubject) {
        for(Subject subject :subjects){
            if(subject.getId() == idSubject){
                return subject;
            }
        }
        return null;
    }
  
    
}
