package com.briozing.automation.helpers;

import com.briozing.automation.common.Configuration;
import com.briozing.automation.models.CreatePostDTO;
import com.briozing.automation.models.UpdateTitleDTO;
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

    public Response getPostByUserId(String userId,int status) {
        final Response response = given(requestSpecification)
                .queryParam("userId",userId)
                .get("/posts");
        response.then().assertThat().statusCode(status);
        return response;
    }

    public Response getAllComments(int status) {
        final Response response = given(requestSpecification)
                .get("/comments");
        response.then().assertThat().statusCode(status);
        return response;
    }

    public Response getCommentsByPostId(String postId,int status) {
        final Response response = given(requestSpecification)
                .pathParam("postId", postId)
                .get("/posts/{postId}/comments");
        response.then().assertThat().statusCode(status);
        return response;
    }

    public Response getAllAlbums(int status) {
        final Response response = given(requestSpecification)
                .get("/albums");
        response.then().assertThat().statusCode(status);
        return response;
    }

    public Response getAllPhotos(int status) {
        final Response response = given(requestSpecification)
                .get("/photos");
        response.then().assertThat().statusCode(status);
        return response;
    }

    public Response getAllTodos(int status) {
        final Response response = given(requestSpecification)
                .get("/todos");
        response.then().assertThat().statusCode(status);
        return response;
    }

    public Response getAllUsers(int status) {
        final Response response = given(requestSpecification)
                .get("/users");
        response.then().assertThat().statusCode(status);
        return response;
    }

    public Response createPost(CreatePostDTO createPostDTO, int status) {
        final Response response = given(requestSpecification)
                .body(createPostDTO)
                .post("/posts");
        response.prettyPrint();
        response.then().assertThat().statusCode(status);
        return response;
    }

    public Response updatePost(CreatePostDTO createPostDTO,String id, int status) {
        final Response response = given(requestSpecification)
                .pathParam("id", id)
                .body(createPostDTO)
                .put("/posts/{id}");
        response.prettyPrint();
        response.then().assertThat().statusCode(status);
        return response;
    }

    public Response updateTitle(UpdateTitleDTO updateTitleDTO, String id, int status) {
        final Response response = given(requestSpecification)
                .pathParam("id", id)
                .body(updateTitleDTO)
                .put("/posts/{id}");
        response.prettyPrint();
        response.then().assertThat().statusCode(status);
        return response;
    }

    public Response deletePost(String id, int status) {
        final Response response = given(requestSpecification)
                .pathParam("id", id)
                .delete("/posts/{id}");
        response.then().assertThat().statusCode(status);
        return response;
    }
}
