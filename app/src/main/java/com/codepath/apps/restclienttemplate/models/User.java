package com.codepath.apps.restclienttemplate.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class User {

    public String body;
    public String createdAt;
    public User user;
    public String name;
    public String screenName;
    public String profileImageUrl;


    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        return tweet;
    }

    public static List<Tweet> fromJsonArray(JSONArray  JsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for(int i =0; i < JsonArray.length();i++){
            tweets.add(fromJson(JsonArray.getJSONObject(i)));

        }
        return tweets;
    }
}
