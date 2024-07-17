package org.spotify.TokenHelper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.spotify.constants.Constants;

import java.util.Base64;

import static io.restassured.RestAssured.*;

public class TokenRefresh {
    public static String refreshToken="AQAwNcWWVJ6P2d6sWrKDuUuzbQsXO6Jq9OUPI5l_Lc5Qk2z22ncJMBHYrX8Wm31lGtOtwLk11hkMjJnD3RPF_6xXNnRt7P-hsroCwjWM6_07jS0i09WlUOwCWwYqdOLoPxE";
    public static String refreshAccessToken()
    {
        String client_id="03f6622aad9c44079d1109f0ff9eead1";
        String client_secret="0f617ef63258407b8f50fd1db7655e89";
        String auth = client_id + ":" + client_secret;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
        String Response= RestAssured.given().baseUri("https://accounts.spotify.com").contentType("application/x-www-form-urlencoded")
                .formParam("grant_type","refresh_token").formParam("refresh_token",refreshToken).formParam("client_id",client_id)
                .header("Authorization","Basic "+encodedAuth).log().all().when().post("/api/token").then().log().all().extract().response().asString();
        JsonPath js=new JsonPath(Response);

        refreshToken=js.getString("refresh_token");
        return js.getString("access_token");
    }

}