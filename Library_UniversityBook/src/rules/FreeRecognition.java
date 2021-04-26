/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rules;

import components.PostUserBeanRemote;
import entities.DonationRecognition;
import entities.Post;
import java.time.LocalDate;

/**
 *
 * @author ignacio
 */
public class FreeRecognition extends RecognitionStrategy{

    @Override
    public int calculateDonationRecognitions(PostUserBeanRemote postUserBean, Post post) {
        return 0;
    }
    
}
