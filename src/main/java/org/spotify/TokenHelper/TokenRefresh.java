package org.spotify.TokenHelper;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.spotify.Utils.ConfigManager;

import java.time.Instant;
import java.util.Base64;

import static io.restassured.RestAssured.*;
import static org.spotify.RestUtils.RequestSpecifications.customReqSpecs;

public class TokenRefresh {
    public static String refreshToken=(String) ConfigManager.getInstance().get("refresh_token");
    public static String accessToken;
    public static Instant expiry_time= Instant.EPOCH;//Initalizing to  1970-01-01T00:00:00Z so that we know we have not renewed the token

    public static String getToken()
    {
        //Not renewed the token for the first time or the token has expired
        String Response;
      if(expiry_time.equals(Instant.EPOCH)||Instant.now().isAfter(expiry_time))
      {
          int expiryseconds=0;
          System.out.println("Renewing the Token....");
          Response=refreshAccessToken();
          JsonPath js=new JsonPath(Response);
          expiryseconds=js.getInt("expires_in");
          expiry_time=Instant.now().plusSeconds(expiryseconds-10);//Expiry time for the token
          accessToken= js.getString("access_token");
          return accessToken;
      }
        System.out.println("Token not expired reusing the previous one...");
        return accessToken;

    }
//    private static String refreshAccessToken()
//    {
//        String client_id="03f6622aad9c44079d1109f0ff9eead1";
//        String client_secret="0f617ef63258407b8f50fd1db7655e89";
//        String auth = client_id + ":" + client_secret;
//        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
//        String Response= RestAssured.given().baseUri("https://accounts.spotify.com").contentType("application/x-www-form-urlencoded")
//                .formParam("grant_type","refresh_token").formParam("refresh_token",refreshToken).formParam("client_id",client_id)
//                .header("Authorization","Basic "+encodedAuth).log().all().when().post("/api/token").then().log().all().extract().response().asString();
//      return Response;
//    }
    private static String refreshAccessToken()
    {
        String client_id= (String) ConfigManager.getInstance().get("client_id");
        String client_secret=(String) ConfigManager.getInstance().get("client_secret");
        String auth = client_id + ":" + client_secret;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());

        RequestSpecification dummy =new RequestSpecBuilder().build();
        RequestSpecification requestSpecification=customReqSpecs("https://accounts.spotify.com",dummy,"Basic "+encodedAuth,"application/x-www-form-urlencoded");

        String Response= given(requestSpecification)
                .formParam("grant_type","refresh_token").formParam("refresh_token",refreshToken).formParam("client_id",client_id).
                when().post("/api/token").then().log().all().extract().response().asString();
        return Response;
    }

}