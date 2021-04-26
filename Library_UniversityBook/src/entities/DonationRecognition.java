package entities;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DonationRecognition implements Serializable {

    private int donation;
    private LocalDateTime donationDate;

    public DonationRecognition(int donation, LocalDateTime donationDate) {
        this.donation = donation;
        this.donationDate = donationDate;
    }

    public int getDonation() {
        return donation;
    }

    public boolean isRecognizableBy(LocalDateTime date) {
        return date.isAfter(donationDate) || date.isEqual(donationDate);
    }

}
