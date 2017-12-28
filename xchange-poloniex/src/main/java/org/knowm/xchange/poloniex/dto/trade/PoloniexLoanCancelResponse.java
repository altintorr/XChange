package org.knowm.xchange.poloniex.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by antonin on 22/12/17.
 */

public class PoloniexLoanCancelResponse {

    private final Boolean success;
    private final String error;

    @JsonCreator
    public PoloniexLoanCancelResponse(@JsonProperty("success") Boolean success, @JsonProperty("error") String error) {

        this.success = success;
        this.error = error;
    }

    public Boolean getSuccess() {
        return success;
    }
    public String getError() {
        return error;
    }

}
