package com.company.base.accenture.films;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Movie movie=new Movie();
        User user=new User();
        Review review=new Review();
        String notInSystem = "Вы не в системе";
        String inSystem = "Вы вошли в систему";
        System.out.println(notInSystem);
        Scanner sc = new Scanner(System.in);


        System.out.println("Введите команду:");
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
                        String search = sc.next();
                        movie.getFilms(search);
                }
                if (commands.equals("deletereview")) {

                }
                if(!User.adminMode) {
                    if (commands.equals("addreview")) {
                        System.out.println("Напишите обзор:");
                        review.addReview(sc.next());
                    }
                    if (commands.equals("detail")) {
                        review.getMyReviews();
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
