package com.company.base.accenture.films;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

public class ContainMovies {
    static List moviesList=new ArrayList<User>();
    Map<String,String> movies= new LinkedHashMap<>();
    static Map<Integer, String> map = new LinkedHashMap<>();
    List<String> imdb=new ArrayList<>();
    List<String> film_type=new ArrayList<>();
    List<String> title = new ArrayList<>();
    List<String> genre=new ArrayList<>();
    List<LocalDate> date=new ArrayList<>();
    List<String> rating=new ArrayList<>();
    List<String> details=new ArrayList<>();

    static int movieId=0;

    public Map mapMovies() {
        imdb.add("0133093"); film_type.add("Фильм"); title.add("Матрица");
        imdb.add("0088763"); film_type.add("Фильм"); title.add("Начало");
        imdb.add("0068646"); film_type.add("Фильм"); title.add("Интерстеллар");
        imdb.add("0078748"); film_type.add("Фильм"); title.add("Чужой");
        imdb.add("0088247"); film_type.add("Фильм"); title.add("Терминатор");


        genre.add("Боевик, киберпанк");
        genre.add("Научная фантастика");
        genre.add("Научная фантастика");
        genre.add("Ужасы");
        genre.add("Боевик");

        date.add(LocalDate.of(1999, Month.JULY, 9));
        date.add(LocalDate.of(2017, Month.JULY, 9));
        date.add(LocalDate.of(2019, Month.JULY, 9));
        date.add(LocalDate.of(1973, Month.JULY, 9));
        date.add(LocalDate.of(1975, Month.JULY, 9));

        rating.add("10.0");
        rating.add("10.0");
        rating.add("10.0");
        rating.add("10.0");
        rating.add("10.0");

        details.add("Фильм");
        details.add("Фильм");
        details.add("Фильм");  //заполнить
        details.add("Фильм");
        details.add("Фильм");

        for (int i=0;i<5;i++) {
            map.put(0+movieId,imdb.get(i));
            map.put(1+movieId,film_type.get(i));
            map.put(2+movieId,title.get(i));
            map.put(3+movieId,genre.get(i));
            map.put(4+movieId,date.get(i).toString());
            map.put(5+movieId,rating.get(i));
            map.put(6+movieId,details.get(i));
            movieId+=7;
        }
        return map;
    }

    public Map moviesList()
    {
        return movies;
    }

    public List getMoviesList(){
        return moviesList;
    }
}
