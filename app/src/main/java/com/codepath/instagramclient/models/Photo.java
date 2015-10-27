package com.codepath.instagramclient.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Photo {
    public String type;
    public String username;
    public String userImage;
    public String caption;
    public String imageUrl;
    public int imageHeight;
    public int likesCount;

    public static Photo fromJson(JSONObject photoJSON) {
        Photo photo = new Photo();

        try {
            // Decode the attributes of the json into a data model
            photo.type = photoJSON.getString("type");
            photo.username = photoJSON.getJSONObject("user").getString("username");
            photo.userImage = photoJSON.getJSONObject("user").getString("profile_picture");
            photo.caption = photoJSON.getJSONObject("caption").getString("text");
            photo.imageUrl = photoJSON.getJSONObject("images").getJSONObject("standard_resolution").getString("url");
            photo.imageHeight = photoJSON.getJSONObject("images").getJSONObject("standard_resolution").getInt("height");
            photo.likesCount = photoJSON.getJSONObject("likes").getInt("count");
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        return photo;
    }

    public static ArrayList<Photo> fromJSON(JSONArray jsonArray) {
        ArrayList<Photo> photos = new ArrayList<Photo>(jsonArray.length());
        // Process each result in json array, decode and convert to business object
        JSONObject photoJSON = null;
        try {
            for (int i=0; i < jsonArray.length(); i++) {
                photoJSON = jsonArray.getJSONObject(i);
                Photo photo = Photo.fromJson(photoJSON);
                if (photo != null) {
                    photos.add(photo);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return photos;
    }

    public String formattedLikesCount() {
        return likesCount + (likesCount == 1 ? " like" : " likes");
    }
}
