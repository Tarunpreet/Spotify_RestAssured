package Spotify.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.spotify.Requests.Playlist.CreatePlaylist;
import org.spotify.Responses.Playlist.Playlist;
import org.spotify.Responses.error.ErrorDetail;
import org.spotify.Responses.error.ErrorResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.spotify.APIHelper.PlaylistHelper.*;
import static org.spotify.Utils.RequestSpecifications.customReqSpecs;
import static org.spotify.Utils.RequestSpecifications.defaultReqSpecs;
import static org.spotify.Utils.ResponseSpecifications.*;
import static org.spotify.Utils.ResponseSpecifications.customresspec;
import static org.spotify.constants.Constants.*;

public class PlaylistTest
{
    ResponseSpecification responseSpecification;




    @Test
    public void CreatePlaylist()
    {
        CreatePlaylist createPlaylistdata=new CreatePlaylist();
        createPlaylistdata.setName("Punjabi Favs3");
        createPlaylistdata.setDescription("All time favs3");
        createPlaylistdata.setIsPublic(true);
        Playlist playlistdata=new Playlist();

        RequestSpecification requestSpecification=defaultReqSpecs();
        ResponseSpecification responseSpecification=customresspec("application/json",201);


        playlistdata=createPlaylist(requestSpecification,responseSpecification,createPlaylistdata);//Hitting the api request

        assertThat(playlistdata.getName(),equalTo(createPlaylistdata.getName()));
        assertThat(playlistdata.getIspublic(),equalTo(createPlaylistdata.getIsPublic()));

    }
    @Test
    public void GetPlaylist()
    {
        Playlist playlistdata=new Playlist();
        RequestSpecification requestSpecification=defaultReqSpecs();
        ResponseSpecification responseSpecification=defaultresponsespec();

        playlistdata=getPlaylist(requestSpecification,responseSpecification,"6M5Xb7tycAxC5V4kvuzxPB");
        assertThat(playlistdata.getName(),equalTo("Updated Punjabi Favs"));
        assertThat(playlistdata.getIspublic(),equalTo(true));
    }
    @Test
    public void UpdatePlaylist()
    {
        CreatePlaylist createPlaylistdata=new CreatePlaylist();
        createPlaylistdata.setName("Updated Punjabii Favs");
        createPlaylistdata.setDescription("Updated All time favss");
        createPlaylistdata.setIsPublic(true);

        RequestSpecification requestSpecification=defaultReqSpecs();
        ResponseSpecification responseSpecification=customresspec("",200);

        updatePlaylist(requestSpecification,responseSpecification,  "6M5Xb7tycAxC5V4kvuzxPB",createPlaylistdata);
    }

    @Test
    public void ShouldNotCreatePlaylist()
    {
        //Should not create playlist as no name present
        //{error: {"status":400,"message":"missing feild name"}}
        CreatePlaylist createPlaylistdata=new CreatePlaylist();
        createPlaylistdata.setDescription("All time favs");
        createPlaylistdata.setIsPublic(true);

        ErrorResponse error=new ErrorResponse();

        RequestSpecification requestSpecification=defaultReqSpecs();
        ResponseSpecification responseSpecification=customresspec("application/json",400);


        error=shouldnotcreatePlaylist(requestSpecification,responseSpecification,createPlaylistdata);

        ErrorDetail errorDetail;
        errorDetail=error.getError();
        assertThat(errorDetail.getMessage(),equalTo("Missing required field: name"));
    }
    @Test
    public void ShouldNotGetPlaylist()
    {
        //Should Not get playlist due to invalid token

        ErrorResponse error=new ErrorResponse();

        RequestSpecification barereq = new RequestSpecBuilder().
                setBaseUri(baseUri).setBasePath(basepath).build();

        RequestSpecification requestSpecification=customReqSpecs(barereq,"6M5Xb7tycAxC5V4kvuzxPB","ContentType.JSON");
        ResponseSpecification responseSpecification=customresspec("application/json",401);


        error=  shouldnotgetPlaylist(requestSpecification,responseSpecification,"6M5Xb7tycAxC5V4kvuzxPB");

        ErrorDetail errorDetail;
        errorDetail=error.getError();
        assertThat(errorDetail.getMessage(),equalTo("No token provided"));
    }


}
