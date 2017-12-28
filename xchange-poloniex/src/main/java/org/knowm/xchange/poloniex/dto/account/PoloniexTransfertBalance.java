package org.knowm.xchange.poloniex.dto.account;

import java.math.BigDecimal;

/**
 * Created by antonin on 27/12/17.
 */

public class PoloniexTransfertBalance {

    String currency;
    BigDecimal exchangeBalance;
    BigDecimal marginBalance;
    BigDecimal lendingBalance;

    public PoloniexTransfertBalance(String currency, BigDecimal exchangeBalance, BigDecimal marginBalance, BigDecimal lendingBalance) {
        this.currency = currency;
        this.exchangeBalance = exchangeBalance;
        this.marginBalance = marginBalance;
        this.lendingBalance = lendingBalance;
    }

    public String getCurrency() {
        return currency;
    }
    public BigDecimal getExchangeBalance() {
        return exchangeBalance;
    }
    public BigDecimal getMarginBalance() {
        return marginBalance;
    }
    public BigDecimal getLendingBalance() {
        return lendingBalance;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public void setExchangeBalance(BigDecimal exchangeBalance) {
        this.exchangeBalance = exchangeBalance;
    }
    public void setMarginBalance(BigDecimal marginBalance) {
        this.marginBalance = marginBalance;
    }
    public void setLendingBalance(BigDecimal lendingBalance) {
        this.lendingBalance = lendingBalance;
    }
}
