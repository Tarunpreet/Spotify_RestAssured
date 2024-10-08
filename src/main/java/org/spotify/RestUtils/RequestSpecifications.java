package org.spotify.RestUtils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static org.spotify.TokenHelper.TokenRefresh.getToken;
import static org.spotify.constants.Constants.*;

public class RequestSpecifications {
    public static RequestSpecification defaultReqSpecs()
    {
         return new RequestSpecBuilder().setBaseUri(baseUri).setBasePath(basepath)
                .addHeader("Authorization","Bearer "+getToken())
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).
                build();
    }
    public static RequestSpecification customReqSpecs(RequestSpecification requestSpecification,String Token,String contentType )
    {

        RequestSpecification newreqspecs=requestSpecification.header("Autorization","Bearer "+Token)
                .contentType(contentType).log().all();
        return newreqspecs;
    }
    public static RequestSpecification customReqSpecs(String BaseURI,RequestSpecification requestSpecification,String Token,String contentType )
    {

        RequestSpecification newreqspecs=requestSpecification.baseUri(BaseURI).
                header("Authorization",Token)
                .contentType(contentType).log().all();
        return newreqspecs;
    }
}
