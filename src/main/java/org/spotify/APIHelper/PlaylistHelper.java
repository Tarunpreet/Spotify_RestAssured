package org.spotify.APIHelper;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.spotify.Requests.Playlist.CreatePlaylist;
import org.spotify.Responses.Playlist.Playlist;
import org.spotify.Responses.error.ErrorResponse;
import org.spotify.Utils.DataManager;

import static io.restassured.RestAssured.given;
import static org.spotify.RestUtils.GenericAPIHelper.*;

public class PlaylistHelper {
    @Step
    public static Playlist createPlaylist(RequestSpecification requestSpecification, ResponseSpecification responseSpecification, CreatePlaylist createPlaylistdata)
    {
        Response result=postcall(requestSpecification,responseSpecification,"/users/"+ DataManager.getInstance().get("user_id") +"/playlists",createPlaylistdata);
       return  result.as(Playlist.class);
    }
    @Step
    public static Playlist getPlaylist(RequestSpecification requestSpecification, ResponseSpecification responseSpecification, String PlaylistID)
    {
        Response result=getcall(requestSpecification,responseSpecification,"/playlists/"+PlaylistID);
        return result.as(Playlist.class);
    }
    @Step
    public  static void  updatePlaylist(RequestSpecification requestSpecification, ResponseSpecification responseSpecification, String PlaylistID, CreatePlaylist createPlaylistdata)
    {
       putCall(requestSpecification,responseSpecification,"/playlists/"+PlaylistID,createPlaylistdata);
    }
    @Step
    public static ErrorResponse shouldnotcreatePlaylist(RequestSpecification requestSpecification, ResponseSpecification responseSpecification, CreatePlaylist createPlaylistdata)
    {
        Response result=postcall(requestSpecification,responseSpecification,"/users/"+ DataManager.getInstance().get("user_id") +"/playlists",createPlaylistdata);
        return result.as(ErrorResponse.class);
    }
    @Step
    public static ErrorResponse shouldnotgetPlaylist(RequestSpecification requestSpecification, ResponseSpecification responseSpecification, String PlaylistID)
    {
        Response result=getcall(requestSpecification,responseSpecification,"/playlists/"+PlaylistID);
       return result.as(ErrorResponse.class);
    }

}
