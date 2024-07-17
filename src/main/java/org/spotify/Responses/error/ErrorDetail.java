package org.spotify.Responses.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ErrorDetail {

    @JsonProperty("status")
    private int status;

    @JsonProperty("message")
    private String message;
}