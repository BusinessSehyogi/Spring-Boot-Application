package com.businesssehyogi.BusinessSehyogi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tbl_post")
public class Post {

    @Id
    private int postId;
    private LocalDateTime dateAndTime;
    @Column(length = 150)
    private String abstractContent;
    @Column(length = 500)
    private String content;
    private int noOfLikes;
    private int noOfInterested;
    private boolean visible;
    private int views;
    private boolean boostedPost;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;
    @OneToOne
    @JoinColumn(name = "area_id", referencedColumnName = "interestAreaId")
    private InterestArea areaOfPost;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Images> images;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Links> links;

    public Post() {
    }

    public Post(int postId, String abstractContent, String content, int noOfLikes, int noOfInterested, boolean visible, int views, boolean boostedPost, User user, InterestArea areaOfPost1, List<Images> images, List<Links> links) {
        this.postId = postId;
        this.abstractContent = abstractContent;
        this.content = content;
        this.noOfLikes = noOfLikes;
        this.noOfInterested = noOfInterested;
        this.visible = visible;
        this.views = views;
        this.boostedPost = boostedPost;
        this.user = user;
        this.areaOfPost = areaOfPost1;
        this.images = images;
        this.links = links;
        this.dateAndTime = LocalDateTime.now();
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public List<Links> getLinks() {
        return links;
    }

    public void setLinks(List<Links> links) {
        this.links = links;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getAbstractContent() {
        return abstractContent;
    }

    public void setAbstractContent(String abstractContent) {
        this.abstractContent = abstractContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNoOfLikes() {
        return noOfLikes;
    }

    public void setNoOfLikes(int noOfLikes) {
        this.noOfLikes = noOfLikes;
    }

    public int getNoOfInterested() {
        return noOfInterested;
    }

    public void setNoOfInterested(int noOfInterested) {
        this.noOfInterested = noOfInterested;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public boolean isBoostedPost() {
        return boostedPost;
    }

    public void setBoostedPost(boolean boostedPost) {
        this.boostedPost = boostedPost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public InterestArea getAreaOfPost() {
        return areaOfPost;
    }

    public void setAreaOfPost(InterestArea areaOfPost) {
        this.areaOfPost = areaOfPost;
    }
}
