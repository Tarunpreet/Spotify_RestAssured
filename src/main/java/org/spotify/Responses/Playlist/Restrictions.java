package org.spotify.Responses.Playlist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Restrictions {
    @JsonProperty("reason")
    private String reason;
}