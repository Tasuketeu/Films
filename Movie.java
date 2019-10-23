package com.company.base.accenture.films;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Movie {
    static String searchResult="";
    static boolean details=false;
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

        if(!(search.equals("details"))) {
            searchResult = search;
        }
        else{
            details=true;
        }

        ContainMovies containMovies = new ContainMovies();
        containMovies.mapMovies();
        containMovies.moviesList();
        Review review = new Review();
        Map<Map, String> reviewMap = review.getMapToImdb();
        Map<Map, List> mapToReview;
        Map<String, String> mapReviews;
        List<Integer> dateReviewRating;
        for (int i = 0; i < 5; i++) {
            if (searchResult.equals(containMovies.imdb.get(i)) || searchResult.equals(containMovies.title.get(i)) || searchResult.equals(Integer.toString(containMovies.date.get(i).getYear()))) {
                if(!details) {
                    System.out.println("Фильм найден");
                    System.out.println(containMovies.film_type.get(i));
                    System.out.println(containMovies.title.get(i));
                    System.out.println(containMovies.genre.get(i));
                }
                else  {
                    System.out.println(containMovies.imdb.get(i));
                    System.out.println(containMovies.date.get(i));
                    System.out.println(containMovies.rating.get(i));
                    System.out.println(containMovies.details.get(i));
                    if (!reviewMap.entrySet().isEmpty()) {
                        for (Map.Entry<Map, String> entry : reviewMap.entrySet()) {
                            if (entry.getValue().equals(containMovies.imdb.get(i))) {
                                mapToReview = entry.getKey();
                                for (Map.Entry<Map, List> entry2 : mapToReview.entrySet()) {

                                    dateReviewRating = entry2.getValue();
                                    mapReviews = entry2.getKey();
                                    for (Map.Entry<String, String> entry3 : mapReviews.entrySet()) {

                                        System.out.println("\n");

                                        System.out.println(dateReviewRating.get(0)); //date

                                        System.out.println(entry3.getValue()); //login
                                        System.out.println(dateReviewRating.get(1)); //review

                                        System.out.println(dateReviewRating.get(2)); //rating

                                        System.out.println("\n");
                                    }
                                }
                            }
                        }
                        return;
                    }
                }
            }
        }
        details=false;
    }
    public static void getMovieDetails(){
    }
}
