
package rules;

import components.PostUserBeanRemote;
import entities.Post;


public abstract class RecognitionStrategy {
    public abstract int calculateDonationRecognitions(PostUserBeanRemote postUserBean, Post post);
}
