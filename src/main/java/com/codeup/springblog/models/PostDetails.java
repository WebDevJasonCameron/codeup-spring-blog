package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name = "post_details")
public class PostDetails {

    // ATT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private boolean isAwesome;
    @Column
    private String historyOfPost;
    @Column
    private String topicDescription;
    @OneToOne
    private Post post;

    // CON
    public PostDetails() {
    }
    public PostDetails(boolean isAwesome, String historyOfPost, String topicDescription) {
        this.isAwesome = isAwesome;
        this.historyOfPost = historyOfPost;
        this.topicDescription = topicDescription;
    }
    public PostDetails(boolean isAwesome, String historyOfPost, String topicDescription, Post post) {
        this.isAwesome = isAwesome;
        this.historyOfPost = historyOfPost;
        this.topicDescription = topicDescription;
        this.post = post;
    }

    // GET
    public long getId() {
        return id;
    }
    public boolean isAwesome() {
        return isAwesome;
    }
    public String getHistoryOfPost() {
        return historyOfPost;
    }
    public String getTopicDescription() {
        return topicDescription;
    }
    public Post getPost() {
        return post;
    }


    // SET
    public void setAwesome(boolean awesome) {
        isAwesome = awesome;
    }
    public void setHistoryOfPost(String historyOfPost) {
        this.historyOfPost = historyOfPost;
    }
    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }
    public void setPost(Post post) {
        this.post = post;
    }




}  //<--END