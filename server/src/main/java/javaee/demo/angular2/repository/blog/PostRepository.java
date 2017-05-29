package javaee.demo.angular2.repository.blog;

import javaee.demo.angular2.model.shrimpService.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yehoshuamatamorosvalverde on 23/5/17.
 */
public interface PostRepository extends CrudRepository<Post,Long> {
}
