package com.company.base.accenture.films;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;

public class User {

    Map<String,User> users= new LinkedHashMap<>();
    static Map<String, String> map = new LinkedHashMap<>();
    static int NameId=0;
    static int LoginId=10000;
    static int PasswordId=100000000;
    static boolean inSystem=false;
    static boolean adminMode=false;


    Review review=new Review();
    ContainUsers containUsers=new ContainUsers();

    public Map MapUsers(String regname, String reglogin, String regpassword) {
        NameId++;LoginId++;PasswordId++;
        map.put(Integer.toString(NameId), regname);
        map.put(Integer.toString(LoginId), reglogin);
        map.put(Integer.toString(PasswordId), regpassword);
        return map;
    }

    public void registerUsers(String regname,String reglogin,String regpassword) {
            if (users.containsKey(reglogin)&&(!users.isEmpty())) {
                System.out.println("Пользователь с таким логином уже существует!");
            } else {
                User user = new User();
                containUsers.usersList(user);
                users = user.MapUsers(regname, reglogin, regpassword);
                users.put(reglogin, user);
            }
    }

    public void LoginOldUsers(String logname, String loglogin, String logpassword) {
        int NameId1      =0;
        int LoginId1     =10000;
        int PasswordId1  =100000000;
        if(logname=="admin"&&
                loglogin=="admin"&&
                logpassword=="admin"
        )
        {
            adminMode=true;
        }
            if(users.containsKey(loglogin)) {
                for (Object i:containUsers.getUsersList()) {
                    NameId1++;
                    LoginId1++;
                    PasswordId1++;
                    if (users.get(loglogin).equals(i)) {
                            if (map.get(Integer.toString(NameId1)).equals(logname)&&
                            map.get(Integer.toString(LoginId1)).equals(loglogin)&&
                            map.get(Integer.toString(PasswordId1)).equals(logpassword)
                            )
                            {
                                System.out.println("Вы вошли в систему!");
                                review.setActiveUser(i);
                                InSystem();
                            }
                            else {
                                System.out.println("Неверно введённые данные!");
                            }
                                                        }
                    }
                    }
            else{
                System.out.println("Такого пользователя не существует!");
            }
                }

    public static boolean NotInSystem() {
        inSystem=false;
        return inSystem;
    }

    public static boolean InSystem() {
        inSystem=true;
        return inSystem;
    }
    public static boolean adminLogout() {
        adminMode=false;
        return adminMode;
    }
}