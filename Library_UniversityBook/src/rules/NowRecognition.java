package rules;

import components.PostUserBeanRemote;
import entities.DonationRecognition;
import entities.Post;
import java.io.Serializable;

public class NowRecognition extends RecognitionStrategy implements Serializable {

    @Override
    public int calculateDonationRecognitions(PostUserBeanRemote postUserBean, Post post) {
        postUserBean.addDonationRecognition(new DonationRecognition(1, post.getDate()));
        return 1;
    }

}
