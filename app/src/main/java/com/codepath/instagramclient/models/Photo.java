package com.codepath.instagramclient.models;

public class Photo {
    public String type;
    public String username;
    public String userImage;
    public String caption;
    public String imageUrl;
    public int imageHeight;
    public int likesCount;

    public String formattedLikesCount() {
        return likesCount + (likesCount == 1 ? " like" : " likes");
    }
}
