package javaee.demo.angular2.model.shrimpService;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Yehoshua on 23.05.17.
 */

@Entity
public class Post implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Id;

    @Column(name="title", length = 100)
    private String title;

    @Column(name="description", columnDefinition = "TEXT")
    private String content;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
