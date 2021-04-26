package components;

import entities.Degree;
import entities.Subject;
import entities.University;
import java.util.ArrayList;
import javax.ejb.Remote;

@Remote
public interface StudyBeanRemote {

    ArrayList<University> getUniversities();

    ArrayList<Degree> getDegrees();

    ArrayList<Subject> getSubjects();

    Subject getSubjectById(int idSubject);

}
