package com.company.base.accenture.films;

import java.util.LinkedHashMap;
import java.util.Map;

public class ContainUsers {

    static Map<String, User> usersList = new LinkedHashMap<>();
    static boolean inSystem=false;
    static boolean adminMode=false;


    public void registerUsers(String regName,String regLogin,String regPassword) {
        if (usersList.containsKey(regLogin)&&(!usersList.isEmpty())) {
            System.out.println("Пользователь с таким логином уже существует!");
        } else {
            usersList.put(regLogin,new User(regName,regLogin,regPassword));
        }
    }

    public void LoginOldUsers(String Name, String Login, String Password) {

        if(Name.equals("admin")&&
                Login.equals("admin")&&
                Password.equals("admin")
        )
        {
            adminMode=true;
        }

        if(usersList.containsKey(Login)) {
            for (Map.Entry<String,User> entry:usersList.entrySet()) {
                if (Login.equals(entry.getKey())) {

                    if (entry.getValue().regName.equals(Name)&&
                            entry.getValue().regPassword.equals(Password)
                    )
                    {
                        System.out.println("Вы вошли в систему!");
                        ContainMovies.setActiveUser(Login);
                        ContainUsers.inSystem=true;
                        return;
                    }
                    else {
                        System.out.println("Неверно введённые данные!");
                        return;
                    }
                }
            }
        }
        else{
            System.out.println("Такого пользователя не существует!");
        }
    }

}
