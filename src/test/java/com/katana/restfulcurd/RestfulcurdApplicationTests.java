package com.katana.restfulcurd;

import com.katana.restfulcurd.entity.Article;
import com.katana.restfulcurd.entity.Comment;
import com.katana.restfulcurd.service.ArticleService;
import com.katana.restfulcurd.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.awt.print.Pageable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestfulcurdApplicationTests {

    @Autowired
    ArticleService articleService;
    @Autowired
    CommentService commentService;
    @Autowired
    DataSource dataSource;

    @Test
    public void jpaleftjoin() {
        List<Article> list = articleService.leftJoin();
        for (Article article : list) {
            System.out.println(article.toString());
            System.out.println(article.getCommentSet().size());
            Set<Comment> comments = article.getCommentSet();
            for (Comment comment : comments) {
                System.out.println(comment.toString());
            }
        }
    }

    @Test
    public void findAllComments() {
        List<Comment> commentList = commentService.findAll();
        for (int i = 0; i < commentList.size(); i++) {
            Comment comment = commentList.get(i);
            System.out.println(comment.toString());
        }
    }

    @Test
    public void findArticlePageable() {
        Page<Article> page = articleService.findAllPageable(1);
        List<Article> articles = page.getContent();
        Long b = page.getTotalElements();
        Integer a = page.getTotalPages();
        System.out.println(b);
        System.out.println(a);
        for (Article article : articles) {
            System.out.println(article);
            System.out.println(article.getCommentSet().size());
        }

    }

    @Test
    public void contextLoads() {
        List<Article> list = articleService.findAll();
        for (Article article : list) {
            System.out.println(article.toString());
            System.out.println(article.getCommentSet().size());
            Set<Comment> comments = article.getCommentSet();
            for (Comment comment : comments) {
                System.out.println(comment.toString());
            }
        }
    }

    @Test
    public void testDatasource() throws SQLException {
        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}
