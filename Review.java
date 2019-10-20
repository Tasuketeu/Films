package com.company.base.accenture.films;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Review {
    static String userId;
    Map<String,String> reviews= new LinkedHashMap<>();
    static Map<Integer, String> map = new LinkedHashMap<>();
    static int reviewId=0;
    ContainUsers containUsers=new ContainUsers();

    public Map mapUsersReviews(String review) {
        reviewId++;
        map.put(reviewId,review);
        return map;
    }
    public void setActiveUser(Object activeUser) {
        userId=activeUser.toString();
    }

    public void addReview(String review) {
        Review review1=new Review();
        reviews = review1.mapUsersReviews(review);
        reviews.put(review, userId);
    }
    public void getMyReviews() {
        for (Map.Entry<String,String> entry : reviews.entrySet()) {
            if (entry.getValue().equals(userId)) {
                System.out.println(entry.getKey());
            }
        }
    }
}
