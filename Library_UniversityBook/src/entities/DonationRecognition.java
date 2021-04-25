/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author ignacio
 */
public class DonationRecognition {
    
    private int donation;
    private LocalDateTime donationDate;

    public DonationRecognition(int donation, LocalDateTime donationDate) {
        this.donation = donation;
        this.donationDate = donationDate;
    }

    public int getDonation() {
        return donation;
    }
    
    public boolean isRecognizableBy(LocalDateTime date){
        return date.isAfter(donationDate) || date.isEqual(donationDate);
    }
    
}
