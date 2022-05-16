package com.codeup.springblog.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Post {

    // ATT
    private String title;
    private String body;

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

    // GET
    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }

    // SET
    public void setTitle(String title) {
        this.title = title;
    }
    public void setBody(String body) {
        this.body = body;
    }


}  //<--END
