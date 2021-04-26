package components;

import javax.ejb.Remote;

@Remote
public interface SubjectsOperationRemote {

    int[] getNumberSubjectsByCourse();

}
