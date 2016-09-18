package com.xinglefly.model;

import com.google.gson.annotations.SerializedName;


public class ResultData {
    public @SerializedName("data") DeveloperInfo getData;
    public @SerializedName("article") DeveloperItem getArticles;
}