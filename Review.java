package com.company.base.accenture.films;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Review {
    static String userId;
    static Map<Integer, String> map = new LinkedHashMap<>();

    static Map<Map,String> mapToImdb= new LinkedHashMap<>();
    static int reviewId=0;
    ContainUsers containUsers=new ContainUsers();


//    public Map mapUsersReviews(String review) {
//        reviewId++;
//        map.put(reviewId,review);
//        return map;
//    }

    public void setActiveUser(Object activeUser) {
        userId=activeUser.toString();
    }

    public void addReview(String review,String movie) {
        User user = new User();
        Map<String, String> mapUserLogin = user.getMapUserLogin();
        String login=null;

        for (Map.Entry<String, String> entry : mapUserLogin.entrySet()) {
                    if (entry.getValue().equals(userId)) {
                        login=entry.getKey();
                    }
            }

        Review newReview=new Review();
        Movie newMovie=new Movie();

        Map<String,String> reviews= new LinkedHashMap<>();

        Map<Map,String> mapToReview= new LinkedHashMap<>();
        //reviews = newReview.mapUsersReviews(review);
        reviews.put(newReview.toString(), login);
        String imdb=newMovie.getImdb(movie);
        mapToReview.put(reviews,review);
        mapToImdb.put(mapToReview,imdb);
        System.out.println(reviews);
        System.out.println(mapToReview);
        System.out.println(mapToImdb);
    }
//    public void getMyReviews() {
//        for (Map.Entry<String,String> entry : reviews.entrySet()) {
//            if (entry.getValue().equals(userId)) {
//                System.out.println(entry.getKey());
//            }
//        }
//    }
//    public Map getReviews(){
//        return reviews;
//    }
    public Map getMapToImdb(){
        return mapToImdb;
    }
//    public Map getMapToReview(){
//        return mapToReview;
//    }
}
