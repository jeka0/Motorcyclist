package com.company;

import Database.Db;
import Obj.Ammunition;

public class Main {

    public static void main(String[] args) {
	// write your code here
       Db db = Db.getInstance();
       db.ReadDB("src\\Database\\Data.json");
       for(Ammunition ammunition:db.ammunitionList)System.out.println(ammunition.toString()+"\n");
    }
}
