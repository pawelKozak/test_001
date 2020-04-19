package biz.voti.summator.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IntRequest {

    @JsonProperty
    private Integer value;

    public IntRequest() {
    }

    public int getValue() {
        return value;
    }
}
