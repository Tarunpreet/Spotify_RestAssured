package org.spotify.Responses.Playlist;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddedBy {
    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;

    @JsonProperty("followers")
    private Followers followers;

    @JsonProperty("href")
    private String href;

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("uri")
    private String uri;
}
