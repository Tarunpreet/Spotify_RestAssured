package org.spotify.Requests.Playlist;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class CreatePlaylist
{
    String name;
    String description;
    @JsonProperty("public")
    Boolean isPublic;
}
