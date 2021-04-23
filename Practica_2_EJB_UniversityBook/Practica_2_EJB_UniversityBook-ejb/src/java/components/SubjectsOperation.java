/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entities.Subject;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ignacio
 */
@Stateless
public class SubjectsOperation implements SubjectsOperationRemote {

    @EJB
    private StudyBeanRemote studyBean;
    
    @Override
    public int[] getNumberSubjectsByCourse() {
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
