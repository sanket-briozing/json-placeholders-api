package com.briozing.automation.helpers;

import com.briozing.automation.common.Configuration;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;

public class JsonPlaceholdersHelper {
    private RequestSpecification requestSpecification;

    public JsonPlaceholdersHelper() {
        requestSpecification = with()
                .contentType(ContentType.JSON)
                .log().all()
                .baseUri(Configuration.apiServer);
    }
    public Response getAllPosts(int status) {
        final Response response = given(requestSpecification)
                .get("/posts");
        response.then().assertThat().statusCode(status);
        return response;
    }

    public Response getPostById(String id,int status) {
        final Response response = given(requestSpecification)
                .pathParam("id", id)
                .get("/posts/{id}");
        response.then().assertThat().statusCode(status);
        return response;
    }

    public Response getAllComments(int status) {
        final Response response = given(requestSpecification)
                .get("/comments");
        response.then().assertThat().statusCode(status);
        return response;
    }

    public Response getAllAlbums(int status) {
        final Response response = given(requestSpecification)
                .get("/albums");
        response.then().assertThat().statusCode(status);
        return response;
    }
}
