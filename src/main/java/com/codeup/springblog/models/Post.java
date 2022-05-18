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
    private PostDetails postDetailsId;

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
    public Post(String title, String body, PostDetails postDetailsId) {
        this.title = title;
        this.body = body;
        this.postDetailsId = postDetailsId;
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
    public PostDetails getPostDetailsId() {
        return postDetailsId;
    }

    // SET
    public void setTitle(String title) {
        this.title = title;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public void setPostDetailsId(PostDetails postDetailsId) {
        this.postDetailsId = postDetailsId;
    }


}  //<--END
