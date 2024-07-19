package org.spotify.RestUtils;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import  io.restassured.specification.ResponseSpecification;

public class ResponseSpecifications {
    public static ResponseSpecification defaultresponsespec()
    {
        return new ResponseSpecBuilder().
                expectContentType("application/json").
                expectStatusCode(200).
                log(LogDetail.ALL).build();
    }
    public static ResponseSpecification customresspec(String ContentType,int statuscode)
    {
        if(ContentType.equals(""))
        {
            return new ResponseSpecBuilder().
                    expectStatusCode(statuscode).
                    log(LogDetail.ALL).build();
        }
        return new ResponseSpecBuilder().
                expectContentType(ContentType).
                expectStatusCode(statuscode).
                log(LogDetail.ALL).build();
    }
}

