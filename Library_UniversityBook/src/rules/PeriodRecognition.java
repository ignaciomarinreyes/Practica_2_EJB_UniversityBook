/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rules;

import components.PostUserBeanRemote;
import entities.DonationRecognition;
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
    public void calculateDonationRecognitions(PostUserBeanRemote postUserBean) {
        for(int i = 1; i <= 12; i = i + periodRecognition - 1){
            //postUserBean.addDonationRecognition(new DonationRecognition(1, LocalDateTime.now().plusMonths(i)));
            postUserBean.addDonationRecognition(new DonationRecognition(1, LocalDateTime.now().plusSeconds(i)));
        }
    }
        
    
    
}
