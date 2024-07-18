package org.spotify.APIHelper;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class GenericAPIHelper {
    public static Response getcall(RequestSpecification requestSpecification, ResponseSpecification responseSpecification, String EndPoint)
    {
       return given(requestSpecification).
                when().get(EndPoint).
                then().spec(responseSpecification).extract().response();
    }
    public static Response postcall(RequestSpecification requestSpecification, ResponseSpecification responseSpecification, String EndPoint,Object Payload)
    {
        return given(requestSpecification).body(Payload).
                when().post(EndPoint)
                .then().spec(responseSpecification).extract().response();
    }
    public static Response postcall(RequestSpecification requestSpecification, ResponseSpecification responseSpecification, String EndPoint)
    {
        return given(requestSpecification).
                when().post(EndPoint)
                .then().spec(responseSpecification).extract().response();
    }
    public static Response putCall(RequestSpecification requestSpecification,ResponseSpecification responseSpecification,String EndPoint,Object Payload)
    {
       return given(requestSpecification).body(Payload).
                when().put(EndPoint)
                .then().spec(responseSpecification).extract().response();
    }


}
