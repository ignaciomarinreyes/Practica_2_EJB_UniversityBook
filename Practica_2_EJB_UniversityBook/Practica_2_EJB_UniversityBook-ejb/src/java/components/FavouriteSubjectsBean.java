/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import data.Data;
import entities.Subject;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

/**
 *
 * @author ignacio
 */
@Stateful
public class FavouriteSubjectsBean implements FavouriteSubjectsBeanRemote {

    ArrayList<Subject> subjects;
    
    @PostConstruct
    public void init() {
        subjects = new ArrayList<Subject>();
    }

    @Override
    public void addFavouriteSubject(Subject subject) {
        subjects.add(subject);
    }

    @Override
    public ArrayList<Subject> getFavouritesSubjects() {
        return subjects;
    }
 
    
}
