package com.codeup.springblog.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email"}))
public class User {

    // ATT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(length = 10_000)
    private String bio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private List<Post> posts;

    // CON
    public User() {
    }
    public User(String username, String email, String bio) {
        this.username = username;
        this.email = email;
        this.bio = bio;
    }
    public User(String username, String email, String bio, List<Post> posts) {
        this.username = username;
        this.email = email;
        this.bio = bio;
        this.posts = posts;
    }

    // AUTH
    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        posts = copy.posts;
        username = copy.username;
        password = copy.password;
    }


    // GET
    public long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getBio() {
        return bio;
    }
    public List<Post> getPosts() {
        return posts;
    }
    public String getPassword() {
        return password;
    }

    // SET
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // CHECKS
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", bio='" + bio + '\'' +
                ", posts=" + posts +
                '}';
    }

}  //<--END
