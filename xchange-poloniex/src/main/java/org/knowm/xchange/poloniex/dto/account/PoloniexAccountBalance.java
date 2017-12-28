package org.knowm.xchange.poloniex.dto.account;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;
import java.util.Map;

import javax.annotation.Generated;

/**
 * Created by antonin on 16/12/17.
 */

public class PoloniexAccountBalance {

    private String currency;
    private BigDecimal available;

    public PoloniexAccountBalance(String currency, BigDecimal available) {
        this.currency = currency;
        this.available = available;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAvailable() {
        return available;
    }

    public void setAvailable(BigDecimal available) {
        this.available = available;
    }

}

