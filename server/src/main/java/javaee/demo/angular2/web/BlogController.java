package javaee.demo.angular2.web;

import javaee.demo.angular2.model.blog.Article;
import javaee.demo.angular2.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yehoshua on 01.02.17.
 */

@RestController
@CrossOrigin()
public class BlogController {

    @Autowired
    BlogService blogService;

    @RequestMapping(value = "/blog/list", method = RequestMethod.GET)
    public @ResponseBody
        List<Article> resultList() {

        return blogService.getArticles();

    }


}
