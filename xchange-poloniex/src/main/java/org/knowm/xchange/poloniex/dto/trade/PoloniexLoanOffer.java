package org.knowm.xchange.poloniex.dto.trade;

import java.math.BigDecimal;

/**
 * Created by antonin.badoux on 20/12/2017.
 */

public class PoloniexLoanOffer {

    private PoloniexLoanCreationResponse response = null;

    private String currency;
    private BigDecimal amount;
    private BigDecimal rate;
    private BigDecimal duration;
    private Boolean autorenew;

    public PoloniexLoanOffer(String currency, BigDecimal amount, BigDecimal rate, BigDecimal duration, Boolean autorenew) {
        this.currency = currency;
        this.amount = amount;
        this.rate = rate;
        this.duration = duration;
        this.autorenew = autorenew;
    }

    //GETTER
    public PoloniexLoanCreationResponse getResponse() {
        return response;
    }
    public String getCurrency() {
        return currency;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public BigDecimal getRate() {
        return rate;
    }
    public BigDecimal getDuration() {
        return duration;
    }
    public Boolean getAutorenew() { return autorenew;}

    //SETTER
    public void setResponse(PoloniexLoanCreationResponse response) {
        this.response = response;
    }

}
