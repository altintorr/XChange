package org.knowm.xchange.poloniex.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.knowm.xchange.poloniex.dto.marketdata.PoloniexPublicTrade;

import java.math.BigDecimal;
import java.util.List;

import si.mazi.rescu.ExceptionalReturnContentException;

public class PoloniexLoanCreationResponse {

  private final Boolean success;
  private final String message;
  private final Long orderID;

  @JsonCreator
  public PoloniexLoanCreationResponse(@JsonProperty("success") Boolean success, @JsonProperty("message") String message, @JsonProperty("orderID") Long orderID) {

    if (orderID == null) {
      throw new ExceptionalReturnContentException("No trade data in response");
    }
    this.success = success;
    this.message = message;
    this.orderID = orderID;
  }

  public Boolean getSuccess() {
    return success;
  }
  public String getMessage() {
    return message;
  }
  public Long getOrderID() {
    return orderID;
  }

}
