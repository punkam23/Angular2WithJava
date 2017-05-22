package javaee.demo.angular2.repository.blog;

import javaee.demo.angular2.model.blog.Article;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Yehoshua on 01.02.17.
 */

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
