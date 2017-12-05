package com.alkfejl.hu.Beadando.models;

/**
 * Created by D on 2017. 12. 05..
 */
public class Comment {
    private long id;
    private String comment;
    private String timeStamp;
    private long recipeId;
    private long commenterId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }

    public long getCommenterId() {
        return commenterId;
    }

    public void setCommenterId(long commenterId) {
        this.commenterId = commenterId;
    }

    public Comment() {
    }

    public Comment(long id, String comment, String timeStamp, long recipeId, long commenterId) {
        this.id = id;
        this.comment = comment;
        this.timeStamp = timeStamp;
        this.recipeId = recipeId;
        this.commenterId = commenterId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", recipeId=" + recipeId +
                ", commenterId=" + commenterId +
                '}';
    }
}
