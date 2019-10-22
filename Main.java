package com.company.base.accenture.films;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Movie movie=new Movie();
        User user=new User();
        user.registerUsers("admin","admin","admin");
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
                "deleteReview -- удалить отзыв(для пользователей)\n" +
                "detail -- ???????\n" +
                "exit -- выход из программы\n" +
                "editReview -- редактировать отзыв(для пользователей)\n" +
                "deleteReviewByAdmin -- удалить отзыв(для админа) \n" +
                "editReviewByAdmin -- редактировать отзыв(для админа):");
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
        String login;

        while (!(commands.equals("exit"))) {
            if (User.inSystem) {
                if (commands.equals("logout")) {
                    User.NotInSystem();
                    if(user.getAdminLogin()){
                        user.setAdminLogin(false);
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


                if(user.getAdminLogin()){
                    if (commands.equals("editReviewByAdmin")) {

                        System.out.println("Введите название фильма, для которого хотите отредактировать отзыв:");
                        commands=sc.next();
                        if(movie.searchFilmToReview(commands))
                        {
                            System.out.println("Фильм найден! Выберите пользователя, чей отзыв хотите отредактировать:");
                            login=sc.next();
                            System.out.println("Отредактируйте отзыв:");
                            String review=sc.next();
                            review.editReviewByAdmin(sc.next(),commands,login);
                        }
                    }
                    if (commands.equals("deleteReviewByAdmin")) {
                        System.out.println("Введите название фильма, для которого хотите удалить отзыв:");
                        commands=sc.next();
                        if(movie.searchFilmToReview(commands))
                        {
                            System.out.println("Фильм найден! Выберите пользователя, чей отзыв хотите удалить:");
                            login=sc.next();
                            review.deleteReviewByAdmin(commands,login);
                        }
                    }
                }


                if(!user.adminMode) {
                    if (commands.equals("addReview")) {
                        System.out.println("Введите название фильма, на который хотите написать обзор:");
                        commands=sc.next();
                        String myReview;
                        String myRating;
                        if(movie.searchFilmToReview(commands))
                        {
                            System.out.println("Фильм найден! Напишите отзыв:");
                            myReview=sc.next();
                            System.out.println("Дайте оценку:");
                            myRating=sc.next();
                            review.addReview(myReview,myRating,commands);
                        }
                    }
                    if (commands.equals("myReviews")) {
                        //review.getMyReviews();
                    }
                    if (commands.equals("editReview")) {
                            System.out.println("Введите название фильма, на который вы написали отзыв и хотите отредактировать:");
                        commands=sc.next();
                        if(movie.searchFilmToReview(commands))
                        {
                            System.out.println("Фильм найден! Отредактируйте отзыв:");
                            review.editReview(sc.next(),commands);
                        }
                    }
                    if (commands.equals("deleteReview")) {
                        System.out.println("Введите название фильма, на который вы написали отзыв и хотите удалить:");
                        commands=sc.next();
                        if(movie.searchFilmToReview(commands))
                        {
                            System.out.println("Удалите фильм:");
                            review.deleteReview(commands);
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
                    System.out.println(User.adminMode);
                }
            }
            commands = sc.next();
        }

    }
}
