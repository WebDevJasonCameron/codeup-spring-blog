package com.codeup.springblog.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="post_images")
public class PostImage {

    // ATT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String imageTitle;
    private String url;
    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonBackReference
    private Post post;

    // CON
    public PostImage() {
    }
    public PostImage(String imageTitle, String url) {
        this.imageTitle = imageTitle;
        this.url = url;
    }
    public PostImage(String imageTitle, String url, Post post) {
        this.imageTitle = imageTitle;
        this.url = url;
        this.post = post;
    }


    // GET
    public long getId() {
        return id;
    }
    public String getImageTitle() {
        return imageTitle;
    }
    public String getUrl() {
        return url;
    }
    public Post getPost() {
        return post;
    }


    // SET
    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void setPost(Post post) {
        this.post = post;
    }


}  //<--END


