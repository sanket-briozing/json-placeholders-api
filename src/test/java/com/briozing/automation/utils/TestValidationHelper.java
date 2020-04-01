package com.briozing.automation.utils;

import com.briozing.automation.factory.Log4JFactory;
import com.briozing.automation.models.*;
import org.apache.log4j.Logger;


public class TestValidationHelper {

    private Logger logger = Log4JFactory.getLogger(this.getClass().getSimpleName());

    public TestValidationHelper() {

    }

    public void verify_get_all_posts(AllPostsDTO[] actualResponse) {
        int count = actualResponse.length;
        logger.info("Total number of posts: " + count);
        AppAssert.assertTrue(count == 100, "List of posts is equal to 100");
        for (AllPostsDTO post : actualResponse) {
            logger.info("User id = " + post.getUserId());
            logger.info("Id = " + post.getId());
            AppAssert.assertTrue(post.getUserId() != null, "User id is not null");
            AppAssert.assertTrue(post.getId() != null, "Id is not null");
        }
    }

    public void verify_get_post_by_id(AllPostsDTO actualResponse, String id) {
        AppAssert.assertEqual(actualResponse.getId().toString(),id ,"Id matched");
    }

    public void verify_get_post_by_userid(AllPostsDTO[] actualResponse, String userid) {
        int count = actualResponse.length;
        logger.info("Total number of posts: " + count);
        for (int i=0; i<count;i++){
            AppAssert.assertEqual(actualResponse[i].getUserId().toString() ,userid ,"UserId for index "+ i );
        }
        for (AllPostsDTO post : actualResponse) {
            logger.info("Id = " + post.getId());
            logger.info("Title = " + post.getTitle());
            logger.info("Body = " + post.getBody());
            AppAssert.assertTrue(post.getId() != null, "Id is not null");
            AppAssert.assertTrue(post.getTitle() != null, "Title is not null");
            AppAssert.assertTrue(post.getBody() != null, "Body is not null");
        }
    }

    public void verify_get_all_comments(AllCommentsDTO[] actualResponse) {
        int count = actualResponse.length;
        logger.info("Total number of posts: " + count);
        AppAssert.assertTrue(count == 500, "List of comments is equal to 500");
        for (AllCommentsDTO comment : actualResponse) {
            logger.info("Post id = " + comment.getPostId());
            logger.info("Id = " + comment.getId());
            AppAssert.assertTrue(comment.getPostId() != null, "Post id is not null");
            AppAssert.assertTrue(comment.getId() != null, "Id is not null");
        }
    }

    public void verify_get_comments_by_post_id(AllCommentsDTO[] actualResponse, String postId) {
        int count = actualResponse.length;
        logger.info("Total number of comments: " + count);
        for (int i=0; i<count;i++){
            AppAssert.assertEqual(actualResponse[i].getPostId().toString() ,postId ,"Id for index "+ i );
        }
        for (AllCommentsDTO comment : actualResponse) {
            logger.info("Post id = " + comment.getPostId());
            logger.info("Id = " + comment.getId());
            AppAssert.assertTrue(comment.getPostId() != null, "Post id is not null");
            AppAssert.assertTrue(comment.getId() != null, "Id is not null");
        }
    }

    public void verify_get_all_albums(AllAlbumsDTO[] actualResponse) {
        int count = actualResponse.length;
        logger.info("Total number of albums: " + count);
        AppAssert.assertTrue(count == 100, "List of comments is equal to 100");
        for (AllAlbumsDTO album : actualResponse) {
            logger.info("User id = " + album.getUserId());
            logger.info("Id = " + album.getId());
            AppAssert.assertTrue(album.getUserId() != null, "User id is not null");
            AppAssert.assertTrue(album.getId() != null, "Id is not null");
        }
    }

    public void verify_get_all_photos(AllPhotosDTO[] actualResponse) {
        int count = actualResponse.length;
        logger.info("Total number of photos: " + count);
        AppAssert.assertTrue(count == 5000, "List of photos is equal to 5000");
        for (AllPhotosDTO photo : actualResponse) {
            logger.info("Album id = " + photo.getAlbumId());
            logger.info("Id = " + photo.getId());
            AppAssert.assertTrue(photo.getAlbumId() != null, "Album id is not null");
            AppAssert.assertTrue(photo.getId() != null, "Id is not null");
        }
    }

    public void verify_get_all_todos(AllTodosDTO[] actualResponse) {
        int count = actualResponse.length;
        logger.info("Total number of todos: " + count);
        AppAssert.assertTrue(count == 200,"List of todos is equal to 200");
        for (AllTodosDTO todo : actualResponse) {
            logger.info("User id = " + todo.getUserId());
            logger.info("Id = " + todo.getId());
            AppAssert.assertTrue(todo.getUserId() != null, "User id is not null");
            AppAssert.assertTrue(todo.getId() != null, "Id is not null");
        }
    }

    public void verify_get_all_users(AllUsersDTO[] actualResponse) {
        int count = actualResponse.length;
        logger.info("Total number of todos: " + count);
        AppAssert.assertTrue(count == 10,"List of Users is equal to 10");
        for (AllUsersDTO user : actualResponse) {
            logger.info("Id = " + user.getId());
            AppAssert.assertTrue(user.getId() != null, "Id is not null");
        }
    }
}



