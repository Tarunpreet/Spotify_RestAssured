package org.spotify.Responses.Playlist;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TrackItem {
    @JsonProperty("added_at")
    private String addedAt;

    @JsonProperty("added_by")
    private AddedBy addedBy;

    @JsonProperty("is_local")
    private boolean isLocal;

    @JsonProperty("track")
    private Track track;
}