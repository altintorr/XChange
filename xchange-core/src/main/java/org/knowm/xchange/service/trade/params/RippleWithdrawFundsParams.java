package org.knowm.xchange.service.trade.params;

import java.math.BigDecimal;

import android.support.annotation.Nullable;

import org.knowm.xchange.currency.Currency;

public class RippleWithdrawFundsParams extends DefaultWithdrawFundsParams {
  @Nullable
  public final String tag;//optional

  public RippleWithdrawFundsParams(String address, Currency currency, BigDecimal amount) {
    this(address, currency, amount, null);
  }

  public RippleWithdrawFundsParams(String address, Currency currency, BigDecimal amount, String tag) {
    super(address, currency, amount);
    this.tag = tag;
  }

  @Override
  public String toString() {
    return "RippleWithdrawFundsParams{" +
        "address='" + address + '\'' +
        ", tag='" + tag + '\'' +
        ", currency=" + currency +
        ", amount=" + amount +
        ", commission=" + commission +
        '}';
  }
}
