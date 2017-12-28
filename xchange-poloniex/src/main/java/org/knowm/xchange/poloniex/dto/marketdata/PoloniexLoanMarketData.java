package org.knowm.xchange.poloniex.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;

import javax.annotation.Generated;

/**
 * Created by antonin on 03/12/17.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({"rate", "amount", "rangeMin", "rangeMax"})
public class PoloniexLoanMarketData {

    @JsonProperty("rate")
    private BigDecimal rate;
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("rangeMin")
    private BigDecimal rangeMin;
    @JsonProperty("rangeMax")
    private BigDecimal rangeMax;

    public BigDecimal getRate() {
        return rate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getRangeMin() {
        return rangeMin;
    }

    public BigDecimal getRangeMax() {
        return rangeMax;
    }
}
