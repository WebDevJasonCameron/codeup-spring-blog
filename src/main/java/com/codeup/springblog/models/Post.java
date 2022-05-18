package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {

    // ATT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 155)
    private String title;
    @Column(nullable = false, length = 10_000)
    private String body;
    @OneToOne
    private PostDetails postDetails;

    // CON
    public Post() {
    }
    public Post(String title) {
        this.title = title;
    }
    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }
    public Post(String title, String body, PostDetails postDetails) {
        this.title = title;
        this.body = body;
        this.postDetails = postDetails;
    }

    // GET
    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }
    public long getId() {
        return id;
    }
    public PostDetails getPostDetails() {
        return postDetails;
    }

    // SET
    public void setTitle(String title) {
        this.title = title;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public void setPostDetails(PostDetails postDetails) {
        this.postDetails = postDetails;
    }


}  //<--END
