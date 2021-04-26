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
import java.time.LocalDateTime;

/**
 *
 * @author ignacio
 */
public class PeriodRecognition extends RecognitionStrategy{

    private int periodRecognition;

    public PeriodRecognition(int periodRecognition) {
        this.periodRecognition = periodRecognition;
    }
  
    @Override
    public int calculateDonationRecognitions(PostUserBeanRemote postUserBean, Post post) {
        int result = 0;
        for(int i = 0; i < 12; i = i + periodRecognition){
            //postUserBean.addDonationRecognition(new DonationRecognition(1, post.getDate().plusMonths(i)));
            result++;
            postUserBean.addDonationRecognition(new DonationRecognition(1, post.getDate().plusSeconds(i)));
        }
        return result;
    }
        
    
    
}
