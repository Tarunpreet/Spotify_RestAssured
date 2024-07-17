package org.spotify.Responses.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ErrorResponse {

    @JsonProperty("error")
    private ErrorDetail error;
}