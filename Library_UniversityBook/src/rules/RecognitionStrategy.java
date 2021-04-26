
package rules;

import components.PostUserBeanRemote;
import entities.Post;
import java.io.Serializable;


public abstract class RecognitionStrategy implements Serializable{
    public abstract int calculateDonationRecognitions(PostUserBeanRemote postUserBean, Post post);
}
