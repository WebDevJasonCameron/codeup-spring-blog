package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name = "postDetails")
public class PostDetails {

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

}