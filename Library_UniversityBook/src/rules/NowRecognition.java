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
public class NowRecognition extends RecognitionStrategy{

    @Override
    public void calculateDonationRecognitions(PostUserBeanRemote postUserBean) {
        postUserBean.addDonationRecognition(new DonationRecognition(1, LocalDateTime.now()));
    }
    
}
