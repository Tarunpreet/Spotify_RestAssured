package org.spotify.Responses.Playlist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Followers {
    @JsonProperty("href")
    private String href;

    @JsonProperty("total")
    private int total;
}