package javaee.demo.angular2.service;

import javaee.demo.angular2.model.blog.Article;

import java.util.List;

/**
 * Created by Yehoshua on 01.02.17.
 */

public interface BlogService {
    List<Article> getArticles();
}
