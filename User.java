package com.company.base.accenture.films;

import java.util.*;

public class User {

    Map<String,User> users= new LinkedHashMap<>();
    static Map<String, String> map = new LinkedHashMap<>();
    static Map<String, String> mapUserLogin = new LinkedHashMap<>();
    static int NameId=0;
    static int LoginId=10000;
    static int PasswordId=100000000;
    static int userId=0;
    static boolean inSystem=false;
    static boolean adminMode;

    Review review=new Review();
    ContainUsers containUsers=new ContainUsers();

    public Map getMapUserLogin(){
        return mapUserLogin;
    }
    public Map MapUsers(String regname, String reglogin, String regpassword) {
            map.put(Integer.toString(NameId), regname);
            map.put(Integer.toString(LoginId), reglogin);
            map.put(Integer.toString(PasswordId), regpassword);
        NameId++;LoginId++;PasswordId++;
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
                mapUserLogin.put(reglogin,user.toString());
            }
    }

    public void LoginOldUsers(String logname, String loglogin, String logpassword) {
        int NameId1      =0;
        int LoginId1     =10000;
        int PasswordId1  =100000000;


        if(logname.equals("admin")&&
                loglogin.equals("admin")&&
                logpassword.equals("admin")
        )
        {
            adminMode=true;
        }

            if(users.containsKey(loglogin)) {
                for (Object i:containUsers.getUsersList()) {
                    if (users.get(loglogin).equals(i)) {

                            if (map.get(Integer.toString(NameId1)).equals(logname)&&
                            map.get(Integer.toString(LoginId1)).equals(loglogin)&&
                            map.get(Integer.toString(PasswordId1)).equals(logpassword)
                            )
                            {
                                System.out.println("Вы вошли в систему!");
                                review.setActiveUser(i);
                                InSystem();
                                return;
                            }
                            else {
                                System.out.println("Неверно введённые данные!");
                                return;
                            }
                                                        }

                    NameId1++;
                    LoginId1++;
                    PasswordId1++;
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
    public boolean getAdminLogin() {
        return adminMode;
    }
    public void setAdminLogin(boolean adminMode) {
        this.adminMode=adminMode;
    }
}
