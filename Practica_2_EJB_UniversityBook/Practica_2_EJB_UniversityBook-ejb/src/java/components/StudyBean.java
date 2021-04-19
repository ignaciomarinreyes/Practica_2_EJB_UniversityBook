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
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 *
 * @author ignacio
 */
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
    }

    @Override
    public void addDefaultUniversities(java.util.ArrayList<University> universities) {
        this.universities.addAll(universities);
    }

    @Override
    public void addDefaultDegrees(java.util.ArrayList<Degree> degrees) {
        this.degrees.addAll(degrees);
    }

    @Override
    public void addDefaultSubjects(java.util.ArrayList<Subject> subjects) {
        this.subjects.addAll(subjects);
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
    
   
    
}
