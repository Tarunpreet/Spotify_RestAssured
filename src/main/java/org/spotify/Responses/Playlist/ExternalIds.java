package org.spotify.Responses.Playlist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExternalIds {
    @JsonProperty("isrc")
    private String isrc;

    @JsonProperty("ean")
    private String ean;

    @JsonProperty("upc")
    private String upc;
}