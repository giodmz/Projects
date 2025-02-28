package services;

public class PaypalService implements OnlinePaymentService {

    public Double paymentFee(Double amount){
        amount += amount * 0.2;
        return amount;
    }

    public Double interest(Double amount, Integer months){
        for (int i = 0; i < months; i++) {
            amount += amount * 0.1;
        }
        return amount;
    }

    
    

}
