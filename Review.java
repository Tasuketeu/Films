package com.company.base.accenture.films;

import java.util.LinkedHashMap;
import java.util.Map;

public class Review {
    static String userId;
    static Map<Integer, String> map = new LinkedHashMap<>();

    static Map<Map,String> mapToImdb= new LinkedHashMap<>();

    static String login=null;

    public void setActiveUser(Object activeUser) {
        userId=activeUser.toString();
    }

    public void addReview(String review,String movie) {
        User user = new User();
        Map<String, String> mapUserLogin = user.getMapUserLogin();

        for (Map.Entry<String, String> entry : mapUserLogin.entrySet()) {
                    if (entry.getValue().equals(userId)) {
                        login=entry.getKey();
                    }
            }

        Review newReview=new Review();
        Movie newMovie=new Movie();

        Map<String,String> reviews= new LinkedHashMap<>();

        Map<Map,String> mapToReview= new LinkedHashMap<>();
        reviews.put(newReview.toString(), login);
        String imdb=newMovie.getImdb(movie);
        mapToReview.put(reviews,review);
        mapToImdb.put(mapToReview,imdb);
        System.out.println(reviews);
        System.out.println(mapToReview);
        System.out.println(mapToImdb);
    }
    public void deleteReview(String movie) {

        Map<Map, String> mapToReview;
        Map<String, String> mapReviews;
        User user = new User();
        Movie newMovie = new Movie();
        String imdb = newMovie.getImdb(movie);
        Map<String, String> mapUserLogin = user.getMapUserLogin();

        for (Map.Entry<Map, String> entry : mapToImdb.entrySet()) {
            if (entry.getValue().equals(imdb)) {
                mapToReview = entry.getKey();
                for (Map.Entry<Map, String> entry2 : mapToReview.entrySet()) {
                    mapReviews = entry2.getKey();
                    for (Map.Entry<String, String> entry3 : mapReviews.entrySet()) {
                        if (entry3.getValue().equals(login)) {
                            mapToImdb.remove(entry.getKey());
                            System.out.println(mapToImdb.entrySet());
                        }
                    }
                }
            }
        }
    }
        public void editReview(String review,String movie) {

            Map<Map, String> mapToReview;
            Map<String, String> mapReviews;
            User user = new User();
            Movie newMovie = new Movie();
            String imdb = newMovie.getImdb(movie);
            Map<String, String> mapUserLogin = user.getMapUserLogin();

            for (Map.Entry<Map, String> entry : mapToImdb.entrySet()) {
                if (entry.getValue().equals(imdb)) {
                    mapToReview = entry.getKey();
                    for (Map.Entry<Map, String> entry2 : mapToReview.entrySet()) {
                        mapReviews = entry2.getKey();
                        for (Map.Entry<String, String> entry3 : mapReviews.entrySet()) {
                            if (entry3.getValue().equals(login)) {
                                mapToReview.replace(mapReviews,review);
                                System.out.println(mapToReview.entrySet());
                                System.out.println(mapToImdb.entrySet());
                            }
                        }
                    }
                }
            }
        }

    public Map getMapToImdb(){
        return mapToImdb;
    }

}
