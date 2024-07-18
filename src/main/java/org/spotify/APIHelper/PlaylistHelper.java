package org.spotify.APIHelper;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.spotify.Requests.Playlist.CreatePlaylist;
import org.spotify.Responses.Playlist.Playlist;
import org.spotify.Responses.error.ErrorResponse;

import static io.restassured.RestAssured.given;
import static org.spotify.APIHelper.GenericAPIHelper.*;

public class PlaylistHelper {
    public static Playlist createPlaylist(RequestSpecification requestSpecification, ResponseSpecification responseSpecification, CreatePlaylist createPlaylistdata)
    {
        Response result=postcall(requestSpecification,responseSpecification,"/users/31q6bavboh4c2yrlxww6g4oh7z3a/playlists",createPlaylistdata);
       return  result.as(Playlist.class);
    }
    public static Playlist getPlaylist(RequestSpecification requestSpecification, ResponseSpecification responseSpecification, String PlaylistID)
    {
        Response result=getcall(requestSpecification,responseSpecification,"/playlists/"+PlaylistID);
        return result.as(Playlist.class);
    }
    public  static void  updatePlaylist(RequestSpecification requestSpecification, ResponseSpecification responseSpecification, String PlaylistID, CreatePlaylist createPlaylistdata)
    {
       putCall(requestSpecification,responseSpecification,"/playlists/"+PlaylistID,createPlaylistdata);
    }
    public static ErrorResponse shouldnotcreatePlaylist(RequestSpecification requestSpecification, ResponseSpecification responseSpecification, CreatePlaylist createPlaylistdata)
    {
        Response result=postcall(requestSpecification,responseSpecification,"/users/31q6bavboh4c2yrlxww6g4oh7z3a/playlists",createPlaylistdata);
        return result.as(ErrorResponse.class);
    }
    public static ErrorResponse shouldnotgetPlaylist(RequestSpecification requestSpecification, ResponseSpecification responseSpecification, String PlaylistID)
    {
        Response result=getcall(requestSpecification,responseSpecification,"/playlists/"+PlaylistID);
       return result.as(ErrorResponse.class);
    }

}
