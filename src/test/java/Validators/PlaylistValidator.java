package Validators;

import io.qameta.allure.Step;
import org.spotify.Requests.Playlist.CreatePlaylist;
import org.spotify.Responses.Playlist.Playlist;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PlaylistValidator {
    @Step
    public static void PlaylistDataValidator(CreatePlaylist expectedData, Playlist actualData)

    {
        assertThat(actualData.getName(),equalTo(expectedData.getName()));
        assertThat(actualData.getIspublic(),equalTo(expectedData.getIsPublic()));
    }
}
