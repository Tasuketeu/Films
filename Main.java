package com.company.base.accenture.films;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Movie movie=new Movie();
        User user=new User();
        Review review=new Review();
        String notInSystem = "Вы не в системе";
        System.out.println(notInSystem);
        Scanner sc = new Scanner(System.in);


        System.out.println("Введите команду\n" +
                "register -- регистрация\n" +
                "login -- логин\n" +
                "search -- поиск фильма\n" +
                "logout -- выход из аккаунта\n" +
                "addReview -- добавить отзыв\n" +
                "deleteReview -- удалить отзыв(пока доступно только для пользователей)\n" +
                "detail -- ???????\n" +
                "exit -- выход из программы" +
                "editReview -- редактировать отзыв(пока доступно только для пользователей):");
        List<String> CommandList=new ArrayList<String>();
        CommandList.add("register");
        CommandList.add("login");
        CommandList.add("search");
        CommandList.add("logout");
        CommandList.add("addreview");
        CommandList.add("deletereview");
        CommandList.add("detail");
        CommandList.add("exit");
        String commands=sc.next();

        while (!(commands.equals("exit"))) {
            if (User.inSystem) {
                if (commands.equals("logout")) {
                    User.NotInSystem();
                    if(User.adminMode){
                        User.adminLogout();
                    }
                    System.out.println("Вы не в системе");
                }
                if (commands.equals("search")) {
                        System.out.println("Поиск фильмов:");
                        movie.getFilmInfo(sc.next());
                        commands=sc.next();
                    if(commands.equals("details"))
                    {
                        movie.getMovieDetails();
                    }
                }
                if (commands.equals("deleteReview")) {
                    System.out.println("Введите название фильма, на который вы написали обзор и хотите удалить:");
                    commands=sc.next();
                    if(movie.searchFilmToReview(commands))
                    {
                        review.deleteReview(commands);
                    }
                }
                if(!User.adminMode) {
                    if (commands.equals("addReview")) {
                        System.out.println("Введите название фильма, на который хотите написать обзор:");
                        commands=sc.next();
                        if(movie.searchFilmToReview(commands))
                        {
                            System.out.println("Фильм найден! Напишите отзыв:");
                            review.addReview(sc.next(),commands);
                        }
                    }
                    if (commands.equals("myReviews")) {
                        //review.getMyReviews();
                    }
                    if (commands.equals("editReview")) {
                        if(User.adminMode) {
                            System.out.println("Введите название фильма, который хотите отредактировать:");
                        }
                        else{
                            System.out.println("Введите название фильма, на который вы написали обзор и хотите отредактировать:");
                        }
                        commands=sc.next();
                        if(movie.searchFilmToReview(commands))
                        {
                            System.out.println("Фильм найден! Отредактируйте отзыв:");
                            review.editReview(sc.next(),commands);
                        }
                    }
                }
            }
            if (!User.inSystem) {
                if (commands.equals("register")) {
                    System.out.println("Зарегистрируйтесь:");
                    System.out.println("Введите имя:");
                    String regname= sc.next();
                    System.out.println("Введите логин:");
                    String reglogin = sc.next();
                    System.out.println("Введите пароль:");
                    String regpassword = sc.next();
                    user.registerUsers(regname,reglogin,regpassword);
                }
                if (commands.equals("login")) {
                    System.out.println("Залогиньтесь:");
                    System.out.println("Введите имя:");
                    String logname= sc.next();
                    System.out.println("Введите логин:");
                    String loglogin = sc.next();
                    System.out.println("Введите пароль:");
                    String logpassword = sc.next();
                    user.LoginOldUsers(logname,loglogin,logpassword);
                }
            }
            commands = sc.next();
        }

    }
}
