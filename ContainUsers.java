package com.company.base.accenture.films;

import java.util.ArrayList;
import java.util.List;

public class ContainUsers {

    static List usersList=new ArrayList<User>();
    public void usersList(User newUser){
        usersList.add(newUser);
    }

    public List getUsersList(){
        return usersList;
    }
}
