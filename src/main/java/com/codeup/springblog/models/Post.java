package com.codeup.springblog.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

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
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name="post_details_id")
    private PostDetails postDetails;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post", orphanRemoval = true)
    @JsonBackReference
    private List<PostImage> postImages;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


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
    public Post(String title, String body, PostDetails postDetails, User user) {
        this.title = title;
        this.body = body;
        this.postDetails = postDetails;
        this.user = user;
    }
    public Post(String title, String body, PostDetails postDetails, List<PostImage> postImages) {
        this.title = title;
        this.body = body;
        this.postDetails = postDetails;
        this.postImages = postImages;
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
    public List<PostImage> getPostImages() {
        return postImages;
    }
    public User getUser() {
        return user;
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
    public void setPostImages(List<PostImage> postImages) {
        this.postImages = postImages;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", postDetails=" + postDetails +
                ", postImages=" + postImages +
                '}';
    }
}  //<--END
