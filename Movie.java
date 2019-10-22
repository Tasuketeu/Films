package com.company.base.accenture.films;

import java.util.Map;

public class Movie {
    public static boolean searchFilmToReview(String search) {
        ContainMovies containMovies = new ContainMovies();
        containMovies.mapMovies();
        containMovies.moviesList();

        for (int i = 0; i < 5; i++) {
            if (search.equals(containMovies.imdb.get(i)) || search.equals(containMovies.title.get(i)) || search.equals(containMovies.date.get(i))) {
                return true;
            }
        }
        return false;
    }
    public String getImdb(String search) {
        ContainMovies containMovies=new ContainMovies();
        containMovies.mapMovies();
        containMovies.moviesList();
        for (int i = 0; i < 5; i++) {
            if (search.equals(containMovies.imdb.get(i))||search.equals(containMovies.title.get(i))||search.equals(containMovies.date.get(i))) {
                return containMovies.imdb.get(i);
            }
            }
        return "";
    }
    public static void getFilmInfo(String search) {
        ContainMovies containMovies = new ContainMovies();
        containMovies.mapMovies();
        containMovies.moviesList();
        Review review = new Review();
        Map<Map, String> reviewMap = review.getMapToImdb();
        Map<Map, String> mapToReview;
        Map<String, String> mapReviews;

        for (int i = 0; i < 5; i++) {
            if (search.equals(containMovies.imdb.get(i)) || search.equals(containMovies.title.get(i)) || search.equals(containMovies.date.get(i))) {
                System.out.println("Фильм найден");
                System.out.println(containMovies.imdb.get(i));
                System.out.println(containMovies.film_type.get(i));
                System.out.println(containMovies.title.get(i));
                System.out.println(containMovies.genre.get(i));
                System.out.println(containMovies.date.get(i));
                System.out.println(containMovies.rating.get(i));
                System.out.println(containMovies.details.get(i));
                if (!reviewMap.entrySet().isEmpty()) {
                    for (Map.Entry<Map, String> entry : reviewMap.entrySet()) {
                        if (entry.getValue().equals(containMovies.imdb.get(i))) {
                            mapToReview = entry.getKey();
                            for (Map.Entry<Map, String> entry2 : mapToReview.entrySet()) {
                                mapReviews = entry2.getKey();
                                for (Map.Entry<String, String> entry3 : mapReviews.entrySet()) {
                                    System.out.println(entry3.getValue()); //login
                                    System.out.println(entry2.getValue()); //review
                                }
                            }
                        }
                    }
                    return;
                }
            }
        }
    }
    public static void getMovieDetails(){
    }
}
