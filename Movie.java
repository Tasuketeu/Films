package com.company.base.accenture.films;

public class Movie {
    public static void getFilms(String search) {
        String[] film = new String[5];
        String[] id=new String[5];
        double[] rating=new double[5];
        film[0] = "Матрица";            id[0]="0133093";
        film[1] = "Назад в будущее";    id[1]="0088763";
        film[2] = "Крёстный отец";      id[2]="0068646";
        film[3] = "Чужой";              id[3]="0078748";
        film[4] = "Терминатор";         id[4]="0088247";
        for (int i = 0; i < 5; i++) {
            if (search.equals(film[i])) {
                System.out.println("Фильм найден");
                System.out.println(film[i]);
                System.out.println(id[i]);
            }
        }
    }
//    public static String Imdb(String imdb) {
//        List<String> ids = new ArrayList<>();
//        ids.add("0133093");
//        ids.add("0088763");
//        ids.add("0068646");
//        ids.add("0078748");
//        ids.add("0088247");
//        for (int i = 0; i < 5; i++) {
//            if (imdb.equals(ids.get(i))) {
//                System.out.println("rgargare");
//            }
//        }
//        return imdb;
//    }
}
