package org.spotify.Responses.Playlist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class Tracks {
    @JsonProperty("href")
    private String href;

    @JsonProperty("limit")
    private int limit;

    @JsonProperty("next")
    private String next;

    @JsonProperty("offset")
    private int offset;

    @JsonProperty("previous")
    private String previous;

    @JsonProperty("total")
    private int total;

    @JsonProperty("items")
    private List<TrackItem> items;
}