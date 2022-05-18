package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name = "postDetails")
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
    private Post postId;

    // CON
    public PostDetails() {
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
    public Post getPostId() {
        return postId;
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
    public void setPostId(Post postId) {
        this.postId = postId;
    }




}  //<--END