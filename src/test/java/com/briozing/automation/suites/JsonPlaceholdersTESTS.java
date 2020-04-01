package com.briozing.automation.suites;
import com.briozing.automation.factory.Log4JFactory;
import com.briozing.automation.helpers.JsonPlaceholdersHelper;
import com.briozing.automation.models.*;
import com.briozing.automation.utils.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.json.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class JsonPlaceholdersTESTS {

    private Logger logger = Log4JFactory.getLogger(this.getClass().getSimpleName());
    private JsonPlaceholdersHelper jsonPlaceholdersHelper;
    private TestValidationHelper validationHelper;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        jsonPlaceholdersHelper = new JsonPlaceholdersHelper();
        validationHelper = new TestValidationHelper();
    }

    @DataProvider(name = "post-id-dp")
    public Object[][] postIdDP() {

        return new Object[][]{
                {"1"}
        };
    }

    @DataProvider(name = "post-userId-dp")
    public Object[][] postUserIdDP() {

        return new Object[][]{
                {"1"}
        };
    }

    @DataProvider(name = "comment-postid-dp")
    public Object[][] commentPostIdDP() {

        return new Object[][]{
                {"1"}
        };
    }

    @Test(groups = {"smoke","getallposts"})
    public void verify_get_all_posts() {
        try {
            logger.info("-------------Test Started ------------");
            final Map<String, Boolean> testSteps = new HashMap<>();
            testSteps.put(TestSteps.STEP_GET_ALL_POST.name(), true);
            validateGetAllPosts(testSteps);
            logger.info("--------------Test Ended -------------");

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.info(ex);
            AppAssert.assertTrue(false, "Failure getting all posts");
        }
    }

    @Test(groups = {"smoke","getpostbyid"},dataProvider = "post-id-dp")
    public void verify_get_post_by_id(String id) {
        try {
            logger.info("-------------Test Started ------------");
            final Map<String, Boolean> testSteps = new HashMap<>();
            testSteps.put(TestSteps.STEP_GET_POST_BY_ID.name(), true);
            validateGetPostById(testSteps, id);
            logger.info("--------------Test Ended -------------");

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.info(ex);
            AppAssert.assertTrue(false, "Failure getting posts by id");
        }
    }

    @Test(groups = {"smoke","getpostbyuserid"},dataProvider = "post-userId-dp")
    public void verify_get_post_by_userid(String userId) {
        try {
            logger.info("-------------Test Started ------------");
            final Map<String, Boolean> testSteps = new HashMap<>();
            testSteps.put(TestSteps.STEP_GET_POST_BY_USERID.name(), true);
            validateGetPostByUserId(testSteps, userId);
            logger.info("--------------Test Ended -------------");

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.info(ex);
            AppAssert.assertTrue(false, "Failure getting posts by userid");
        }
    }

    @Test(groups = {"smoke","getallcomments"})
    public void verify_get_all_comments() {
        try {
            logger.info("-------------Test Started ------------");
            final Map<String, Boolean> testSteps = new HashMap<>();
            testSteps.put(TestSteps.STEP_GET_ALL_COMMENTS.name(), true);
            validateGetAllComments(testSteps);
            logger.info("--------------Test Ended -------------");

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.info(ex);
            AppAssert.assertTrue(false, "Failure getting all comments");
        }
    }

    @Test(groups = {"smoke","getcommentsbypostid"},dataProvider = "comment-postid-dp")
    public void verify_get_comments_by_post_id(String postId) {
        try {
            logger.info("-------------Test Started ------------");
            final Map<String, Boolean> testSteps = new HashMap<>();
            testSteps.put(TestSteps.STEP_GET_COMMENTS_BY_POST_ID.name(), true);
            validateGetCommentsByPostId(testSteps, postId);
            logger.info("--------------Test Ended -------------");

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.info(ex);
            AppAssert.assertTrue(false, "Failure getting comments by postid");
        }
    }

    @Test(groups = {"smoke","getallalbums"})
    public void verify_get_all_albums() {
        try {
            logger.info("-------------Test Started ------------");
            final Map<String, Boolean> testSteps = new HashMap<>();
            testSteps.put(TestSteps.STEP_GET_ALL_ALBUMS.name(), true);
            validateGetAllAlbums(testSteps);
            logger.info("--------------Test Ended -------------");

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.info(ex);
            AppAssert.assertTrue(false, "Failure getting all albums");
        }
    }

    @Test(groups = {"smoke","getallphotos"})
    public void verify_get_all_photos() {
        try {
            logger.info("-------------Test Started ------------");
            final Map<String, Boolean> testSteps = new HashMap<>();
            testSteps.put(TestSteps.STEP_GET_ALL_PHOTOS.name(), true);
            validateGetAllPhotos(testSteps);
            logger.info("--------------Test Ended -------------");

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.info(ex);
            AppAssert.assertTrue(false, "Failure getting all photos");
        }
    }

    @Test(groups = {"smoke","getalltodos"})
    public void verify_get_all_todos() {
        try {
            logger.info("-------------Test Started ------------");
            final Map<String, Boolean> testSteps = new HashMap<>();
            testSteps.put(TestSteps.STEP_GET_ALL_TODOS.name(), true);
            validateGetAllTodos(testSteps);
            logger.info("--------------Test Ended -------------");

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.info(ex);
            AppAssert.assertTrue(false, "Failure getting all Todos");
        }
    }

    @Test(groups = {"smoke","getallusers"})
    public void verify_get_all_users() {
        try {
            logger.info("-------------Test Started ------------");
            final Map<String, Boolean> testSteps = new HashMap<>();
            testSteps.put(TestSteps.STEP_GET_ALL_USERS.name(), true);
            validateGetAllUsers(testSteps);
            logger.info("--------------Test Ended -------------");

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.info(ex);
            AppAssert.assertTrue(false, "Failure getting all Users");
        }
    }

    private void validateGetAllPosts(Map<String, Boolean> testSteps) throws Exception {
        if (null != testSteps.get(TestSteps.STEP_GET_ALL_POST.name()) && testSteps.get(TestSteps.STEP_GET_ALL_POST.name())) {
            MainUtils.stepLog(logger, TestSteps.STEP_GET_ALL_POST.name());
            final AllPostsDTO[] response = jsonPlaceholdersHelper.getAllPosts(200)
                    .getBody().as(AllPostsDTO[].class);
            validationHelper.verify_get_all_posts(response);
        }
    }

    private void validateGetPostById(Map<String, Boolean> testSteps, String id) throws Exception {
        if (null != testSteps.get(TestSteps.STEP_GET_POST_BY_ID.name()) && testSteps.get(TestSteps.STEP_GET_POST_BY_ID.name())) {
            MainUtils.stepLog(logger, TestSteps.STEP_GET_POST_BY_ID.name());
            final AllPostsDTO response = jsonPlaceholdersHelper.getPostById(id,200)
                    .getBody().as(AllPostsDTO.class);
            validationHelper.verify_get_post_by_id(response,id);
        }
    }

    private void validateGetPostByUserId(Map<String, Boolean> testSteps, String userId) throws Exception {
        if (null != testSteps.get(TestSteps.STEP_GET_POST_BY_USERID.name()) && testSteps.get(TestSteps.STEP_GET_POST_BY_USERID.name())) {
            MainUtils.stepLog(logger, TestSteps.STEP_GET_POST_BY_USERID.name());
            final AllPostsDTO[] response = jsonPlaceholdersHelper.getPostByUserId(userId,200)
                    .getBody().as(AllPostsDTO[].class);
            validationHelper.verify_get_post_by_userid(response,userId);
        }
    }

    private void validateGetAllComments(Map<String, Boolean> testSteps) throws Exception {
        if (null != testSteps.get(TestSteps.STEP_GET_ALL_COMMENTS.name()) && testSteps.get(TestSteps.STEP_GET_ALL_COMMENTS.name())) {
            MainUtils.stepLog(logger, TestSteps.STEP_GET_ALL_COMMENTS.name());
            final AllCommentsDTO[] response = jsonPlaceholdersHelper.getAllComments(200)
                    .getBody().as(AllCommentsDTO[].class);
            validationHelper.verify_get_all_comments(response);
        }
    }

    private void validateGetCommentsByPostId(Map<String, Boolean> testSteps, String postId) throws Exception {
        if (null != testSteps.get(TestSteps.STEP_GET_COMMENTS_BY_POST_ID.name()) && testSteps.get(TestSteps.STEP_GET_COMMENTS_BY_POST_ID.name())) {
            MainUtils.stepLog(logger, TestSteps.STEP_GET_COMMENTS_BY_POST_ID.name());
            final AllCommentsDTO[] response = jsonPlaceholdersHelper.getCommentsByPostId(postId,200)
                    .getBody().as(AllCommentsDTO[].class);
            validationHelper.verify_get_comments_by_post_id(response,postId);
        }
    }

    private void validateGetAllAlbums(Map<String, Boolean> testSteps) throws Exception {
        if (null != testSteps.get(TestSteps.STEP_GET_ALL_ALBUMS.name()) && testSteps.get(TestSteps.STEP_GET_ALL_ALBUMS.name())) {
            MainUtils.stepLog(logger, TestSteps.STEP_GET_ALL_ALBUMS.name());
            final AllAlbumsDTO[] response = jsonPlaceholdersHelper.getAllAlbums(200)
                    .getBody().as(AllAlbumsDTO[].class);
            validationHelper.verify_get_all_albums(response);
        }
    }

    private void validateGetAllPhotos(Map<String, Boolean> testSteps) throws Exception {
        if (null != testSteps.get(TestSteps.STEP_GET_ALL_PHOTOS.name()) && testSteps.get(TestSteps.STEP_GET_ALL_PHOTOS.name())) {
            MainUtils.stepLog(logger, TestSteps.STEP_GET_ALL_PHOTOS.name());
            final AllPhotosDTO[] response = jsonPlaceholdersHelper.getAllPhotos(200)
                    .getBody().as(AllPhotosDTO[].class);
            validationHelper.verify_get_all_photos(response);
        }
    }

    private void validateGetAllTodos(Map<String, Boolean> testSteps) throws Exception {
        if (null != testSteps.get(TestSteps.STEP_GET_ALL_TODOS.name()) && testSteps.get(TestSteps.STEP_GET_ALL_TODOS.name())) {
            MainUtils.stepLog(logger, TestSteps.STEP_GET_ALL_TODOS.name());
            final AllTodosDTO[] response = jsonPlaceholdersHelper.getAllTodos(200)
                    .getBody().as(AllTodosDTO[].class);
            validationHelper.verify_get_all_todos(response);
        }
    }

    private void validateGetAllUsers(Map<String, Boolean> testSteps) throws Exception {
        if (null != testSteps.get(TestSteps.STEP_GET_ALL_USERS.name()) && testSteps.get(TestSteps.STEP_GET_ALL_USERS.name())) {
            MainUtils.stepLog(logger, TestSteps.STEP_GET_ALL_USERS.name());
            final AllUsersDTO[] response = jsonPlaceholdersHelper.getAllUsers(200)
                    .getBody().as(AllUsersDTO[].class);
            validationHelper.verify_get_all_users(response);
        }
    }
}
