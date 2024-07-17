package org.spotify.Responses.Playlist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Image {
    @JsonProperty("url")
    private String url;

    @JsonProperty("height")
    private int height;

    @JsonProperty("width")
    private int width;
}