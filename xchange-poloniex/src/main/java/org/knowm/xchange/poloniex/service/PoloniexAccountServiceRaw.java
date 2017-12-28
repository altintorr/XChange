package org.knowm.xchange.poloniex.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.support.annotation.Nullable;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.poloniex.PoloniexAdapters;
import org.knowm.xchange.poloniex.PoloniexException;
import org.knowm.xchange.poloniex.dto.LoanInfo;
import org.knowm.xchange.poloniex.dto.account.PoloniexAccountBalance;
import org.knowm.xchange.poloniex.dto.account.PoloniexBalance;
import org.knowm.xchange.poloniex.dto.account.PoloniexLoan;
import org.knowm.xchange.poloniex.dto.trade.PoloniexDepositsWithdrawalsResponse;
import org.knowm.xchange.utils.DateUtils;

/**
 * @author Zach Holmes
 */

public class PoloniexAccountServiceRaw extends PoloniexBaseService {

  /**
   * Constructor
   *
   * @param exchange
   */
  public PoloniexAccountServiceRaw(Exchange exchange) {

    super(exchange);
  }

  public List<Balance> getExchangeWallet() throws IOException {
    try {
      HashMap<String, PoloniexBalance> response = poloniexAuthenticated.returnCompleteBalances(apiKey, signatureCreator, exchange.getNonceFactory(),
          null);
      return PoloniexAdapters.adaptPoloniexBalances(response);
    } catch (PoloniexException e) {
      throw new ExchangeException(e.getError(), e);
    }
  }

  public List<Balance> getWallets() throws IOException {
    try {
      // using account="all" for margin + lending balances
      HashMap<String, PoloniexBalance> response = poloniexAuthenticated.returnCompleteBalances(apiKey, signatureCreator, exchange.getNonceFactory(),
          "all");
      return PoloniexAdapters.adaptPoloniexBalances(response);
    } catch (PoloniexException e) {
      throw new ExchangeException(e.getError(), e);
    }
  }

  public LoanInfo getLoanInfo() throws IOException {
    try {
      HashMap<String, PoloniexLoan[]> response = poloniexAuthenticated.returnActiveLoans(apiKey, signatureCreator, exchange.getNonceFactory());
      HashMap<String, PoloniexLoan[]> response2 = poloniexAuthenticated.returnOpenLoanOffers(apiKey, signatureCreator, exchange.getNonceFactory());
      if(response2 != null) {
        ArrayList<PoloniexLoan> poloniexLoans = new ArrayList<PoloniexLoan>();
        for (Map.Entry<String, PoloniexLoan[]> entry : response2.entrySet()) {
          for (PoloniexLoan pl : entry.getValue()) {
            pl.setCurrency(entry.getKey());
            poloniexLoans.add(pl);
          }
        }
        PoloniexLoan[] pltmp = new PoloniexLoan[poloniexLoans.size()];
        response.put("opened", poloniexLoans.toArray(pltmp));
      }
      else {
        response.put("opened",new PoloniexLoan[0]);
      }
      return PoloniexAdapters.adaptPoloniexLoans(response);    } catch (PoloniexException e) {
      throw new ExchangeException(e.getError(), e);
    }
  }

  public String getDepositAddress(String currency) throws IOException {

    HashMap<String, String> response = poloniexAuthenticated.returnDepositAddresses(apiKey, signatureCreator, exchange.getNonceFactory());

    if (response.containsKey("error")) {
      throw new ExchangeException(response.get("error"));
    }
    if (response.containsKey(currency)) {
      return response.get(currency);
    } else {
      throw new ExchangeException("Poloniex did not return a deposit address for " + currency);
    }
  }

  public HashMap<String,ArrayList<PoloniexAccountBalance>> getAvailableAccountBalances() throws IOException {
    HashMap<String, HashMap<String,BigDecimal>> response = poloniexAuthenticated.returnAvailableAccountBalances(apiKey, signatureCreator, exchange.getNonceFactory());
    return PoloniexAdapters.adaptAccountBalance(response);
  }

  public void transferValue(String currency, String amount, String fromAccount, String toAccount) {
    try {
      HashMap<String, String> response = poloniexAuthenticated.transferBalance(apiKey, signatureCreator, exchange.getNonceFactory(),currency, amount,fromAccount,toAccount);
      int i = 2+2;
    }
    catch(PoloniexException e) {
      throw new PoloniexException(e.getError());
    }
    catch(IOException e) {
      throw new PoloniexException(e.getMessage());
    }
  }

  /**
   * @param paymentId For XMR withdrawals, you may optionally specify "paymentId".
   */
  public String withdraw(Currency currency, BigDecimal amount, String address, @Nullable String paymentId) throws IOException {
    return poloniexAuthenticated
        .withdraw(apiKey, signatureCreator, exchange.getNonceFactory(), currency.getCurrencyCode(), amount, address, paymentId).getResponse();
  }

  public PoloniexDepositsWithdrawalsResponse returnDepositsWithdrawals(Date start, Date end) throws IOException {
    return poloniexAuthenticated.returnDepositsWithdrawals(apiKey, signatureCreator, exchange.getNonceFactory(), DateUtils.toUnixTimeNullSafe(start),
        DateUtils.toUnixTimeNullSafe(end));
  }

}
