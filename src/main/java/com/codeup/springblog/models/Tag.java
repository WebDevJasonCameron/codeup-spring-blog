package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tag {

    // ATT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "badge_color")
    private String badgeColor;
    @Column(name = "bg_color")
    private String bgColor;
    @Column(name = "btn_outline_color")
    private String btnOutlineColor;
    @ManyToMany(mappedBy = "postTags")
    private List<Post> postTags;

    // CON
    public Tag() {
    }
    public Tag(long id, String name, String badgeColor, String bgColor, String btnOutlineColor, List<Post> postTags) {
        this.id = id;
        this.name = name;
        this.badgeColor = badgeColor;
        this.bgColor = bgColor;
        this.btnOutlineColor = btnOutlineColor;
        this.postTags = postTags;
    }


    // GET
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getBadgeColor() {
        return badgeColor;
    }
    public String getBgColor() {
        return bgColor;
    }
    public String getBtnOutlineColor() {
        return btnOutlineColor;
    }
    public List<Post> getPostTags() {
        return postTags;
    }


    // SET
    public void setName(String name) {
        this.name = name;
    }
    public void setBadgeColor(String badgeColor) {
        this.badgeColor = badgeColor;
    }
    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }
    public void setBtnOutlineColor(String btnOutlineColor) {
        this.btnOutlineColor = btnOutlineColor;
    }
    public void setPostTags(List<Post> postTags) {
        this.postTags = postTags;
    }


    // CHECKS
    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", badgeColor='" + badgeColor + '\'' +
                ", bgColor='" + bgColor + '\'' +
                ", btnOutlineColor='" + btnOutlineColor + '\'' +
                ", postTags=" + postTags +
                '}';
    }


}  //<--END
