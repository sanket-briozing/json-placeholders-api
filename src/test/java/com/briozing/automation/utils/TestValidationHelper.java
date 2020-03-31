package com.briozing.automation.utils;

import com.briozing.automation.factory.Log4JFactory;
import com.briozing.automation.models.AllAlbumsDTO;
import com.briozing.automation.models.AllCommentsDTO;
import com.briozing.automation.models.AllPostsDTO;
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

}



