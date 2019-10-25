package com.company.base.accenture.films;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        ContainMovies containMovies=new ContainMovies();
        ContainUsers containUsers=new ContainUsers();
        containUsers.registerUsers("admin","admin","admin");

        ContainMovies.getMoviesFromCSV("E:/movies.csv");

        String notInSystem = "Вы не в системе";
        System.out.println(notInSystem);
        Scanner sc = new Scanner(System.in);


        System.out.println("Введите команду\n" +
                "register -- регистрация\n" +
                "login -- логин\n" +
                "logout -- выход из аккаунта\n" +
                "search -- поиск фильма\n" +
                "details -- показать детали фильма\n" +
                "addReview -- добавить отзыв\n" +
                "editReview -- редактировать отзыв(для пользователей и админов)\n"+
                "deleteReview -- удалить отзыв(для пользователей и админов)\n" +
                "exit -- выход из программы:");

        String commands=sc.next();
        String login;

        while (!(commands.equals("exit"))) {
            if (ContainUsers.inSystem) {
                if (commands.equals("logout")) {
                    ContainUsers.inSystem=false;
                    if(ContainUsers.adminMode){
                        ContainUsers.adminMode=false;
                    }
                    System.out.println("Вы не в системе");
                }
                if (commands.equals("search")) {
                        System.out.println("Поиск фильмов:");
                        ContainMovies.getFilmInfo(sc.next());
                        commands=sc.next();
                    if(commands.equals("details"))
                    {
                        ContainMovies.getFilmInfo(commands);
                    }
                }

                    if (commands.equals("addReview")) {
                        System.out.println("Введите название фильма, на который хотите написать обзор:");
                        commands=sc.next();
                        String myReview;
                        String myRating;
                        if(ContainMovies.searchFilm(commands))
                        {
                            System.out.println("Фильм найден! Напишите отзыв:");
                            myReview=sc.next();
                            System.out.println("Дайте оценку:");
                            myRating=sc.next();
                            containMovies.addReview(commands,myReview,myRating);
                        }
                    }

                    if (commands.equals("myReviews")) {
                        //review.getMyReviews();
                    }

                    if (commands.equals("editReview")) {
                        if(!ContainUsers.adminMode) {
                            System.out.println("Введите название фильма, на который вы написали отзыв и хотите отредактировать:");
                            commands = sc.next();
                            String myReview;
                            String myRating;
                            if (ContainMovies.searchFilm(commands)) {
                                System.out.println("Фильм найден! Отредактируйте отзыв:");
                                myReview = sc.next();
                                System.out.println("Дайте оценку:");
                                myRating = sc.next();
                                containMovies.editReview(commands,myReview,myRating);
                            }
                        }
                        else {
                            System.out.println("Введите название фильма, для которого хотите отредактировать отзыв:");
                            commands=sc.next();
                            String myReview;
                            String myRating;
                            if(ContainMovies.searchFilm(commands))
                            {
                                System.out.println("Фильм найден! Выберите пользователя, чей отзыв хотите отредактировать:");
                                login=sc.next();
                                System.out.println("Отредактируйте отзыв:");
                                myReview=sc.next();
                                System.out.println("Дайте оценку:");
                                myRating=sc.next();
                                containMovies.editReview(commands,myReview,myRating);
                            }
                        }
                    }

                    if (commands.equals("deleteReview")) {
                        if(!ContainUsers.adminMode) {
                            System.out.println("Введите название фильма, на который вы написали отзыв и хотите удалить:");
                            commands = sc.next();
                            if (ContainMovies.searchFilm(commands)) {
                                System.out.println("Фильм найден!Обзор удалён!");
                                containMovies.deleteReview(commands);
                            }
                        }
                        else {
                            System.out.println("Введите название фильма, для которого хотите удалить отзыв:");
                            commands = sc.next();
                            if (ContainMovies.searchFilm(commands)) {
                                System.out.println("Фильм найден! Выберите пользователя, чей отзыв хотите удалить:");
                                login = sc.next();
                                containMovies.deleteReview(commands);
                            }
                        }
                    }

            }
            else {

                if (commands.equals("register")) {
                    System.out.println("Зарегистрируйтесь:");
                    System.out.println("Введите имя:");
                    String regName= sc.next();
                    System.out.println("Введите логин:");
                    String regLogin = sc.next();
                    System.out.println("Введите пароль:");
                    String regPassword = sc.next();
                    containUsers.registerUsers(regName,regLogin,regPassword);
                }

                if (commands.equals("login")) {
                    System.out.println("Залогиньтесь:");
                    System.out.println("Введите имя:");
                    String Name= sc.next();
                    System.out.println("Введите логин:");
                    String Login = sc.next();
                    System.out.println("Введите пароль:");
                    String Password = sc.next();
                    containUsers.LoginOldUsers(Name,Login,Password);
                }

            }
            commands = sc.next();
        }

    }
}
