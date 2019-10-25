package com.company.base.accenture.films;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContainMovies  {

    static List<Movie> moviesList=new ArrayList<>();
    static List<Review> reviewsList=new ArrayList<>();
    static String searchResult="";
    static boolean details=false;

    static Pattern pattern;
    static Matcher imdbMatcher;
    static Matcher titleMatcher;
    static Matcher yearMatcher;


    static String activeUser=null;

    public static void getMoviesFromCSV(String uri) throws java.io.IOException{
            List<String> lines = Files.readAllLines(Paths.get(uri), StandardCharsets.UTF_8);
            for (String line : lines) {
                String[] temp=line.split(";");
                    moviesList.add(new Movie(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6]));
            }

            Collections.sort(moviesList);
    }



    public static boolean searchFilm(String search) {

        pattern = Pattern.compile(searchResult.toLowerCase() + ".++"); //{search}.++  greedy matching
        for (int i = 0; i < moviesList.size(); i++) {

            imdbMatcher = pattern.matcher(moviesList.get(i).imdb);
            titleMatcher = pattern.matcher(moviesList.get(i).title.toLowerCase());
            yearMatcher = pattern.matcher(moviesList.get(i).dateVars[0]);

            if (imdbMatcher.matches() || titleMatcher.matches() || yearMatcher.matches()) {
                return true;
            }
        }
        return false;
    }


    public static void getFilmInfo(String search) {

        if (!(search.equals("details"))) {
            searchResult = search;
        } else {
            details = true;
        }
        pattern = Pattern.compile(searchResult.toLowerCase() + ".++"); //{search}.++  greedy matching
                for(int i=0;i<moviesList.size();i++) {

                    imdbMatcher=pattern.matcher(moviesList.get(i).imdb);
                    titleMatcher=pattern.matcher(moviesList.get(i).title.toLowerCase());
                    yearMatcher=pattern.matcher(moviesList.get(i).dateVars[0]);

                    if (imdbMatcher.matches() || titleMatcher.matches() || yearMatcher.matches()) {
                        if (!details) {
                            System.out.println("Фильм найден");
                            System.out.println(moviesList.get(i).filmType); //film type
                            System.out.println(moviesList.get(i).title); //title
                            System.out.println(moviesList.get(i).genre); //genre
                            System.out.println("\n");
                        } else {
                            System.out.println(moviesList.get(i).imdb); //imdb
                            System.out.println(moviesList.get(i).date); //date
                            System.out.println(moviesList.get(i).rating); //rating
                            System.out.println(moviesList.get(i).description); //movie description
                            if (!reviewsList.isEmpty()) {

                                    System.out.println("\n");

                                    System.out.println(reviewsList.get(i).date); //date

                                    System.out.println(reviewsList.get(i).login); //login
                                    System.out.println(reviewsList.get(i).review); //review

                                    System.out.println(reviewsList.get(i).rating); //rating

                                    System.out.println("\n");
                                return;
                            }
                        }
                    }
                }
            details = false;
    }



    public static void setActiveUser(String activeUser) {
        ContainMovies.activeUser=activeUser;
    }

    public void addReview(String imdb,String review,String rating) {
        LocalDate date = LocalDate.now();
        reviewsList.add(new Review(imdb,review,rating,activeUser,date));
    }

    public void editReview(String imdb,String review,String rating) {

        LocalDate date = LocalDate.now();

                reviewsList.set(3,new Review(imdb,review,rating,activeUser,date));
                System.out.println(reviewsList);
        }

    public void deleteReview(String imdb) {


        reviewsList.remove(3);
                System.out.println(reviewsList);
                return;
    }

}
