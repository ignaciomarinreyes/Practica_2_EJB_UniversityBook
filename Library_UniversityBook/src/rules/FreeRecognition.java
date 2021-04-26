package rules;

import components.PostUserBeanRemote;
import entities.Post;
import java.io.Serializable;

public class FreeRecognition extends RecognitionStrategy implements Serializable {

    @Override
    public int calculateDonationRecognitions(PostUserBeanRemote postUserBean, Post post) {
        return 0;
    }

}
