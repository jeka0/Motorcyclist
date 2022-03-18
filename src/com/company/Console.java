package com.company;

import Obj.Ammunition;

import java.util.LinkedList;
import java.util.Scanner;

/** Console class description
 * This class stores methods that allow you to output data to the console and receive data from it
 */
public class Console {
    /**Saved an instance of Scanner to read data from the console*/
    static Scanner scanner = new Scanner(System.in);
    /**This public static overloaded method receives data from the console and checks it for correctness*/
    public static int ReadInt(String str, int min){return ReadInt(str,min,-1);}
    /**This public static method receives data from the console and checks it for correctness*/
    public static int ReadInt(String str, int min, int max)
    {
        boolean flag;
        int num=0;
        PrintMessage(str);
        do {
            flag = false;
            try {
                num = Integer.parseInt(scanner.nextLine());
                if(num<min||(max!=-1 && num>max))throw new Exception();
            }catch (Exception e){ PrintMessage("Введено неверное значение!!!!\nПовторите ввод:");flag =true;}
        }while(flag);
        return num;
    }
    /**This public static method outputs data to the console*/
    public static void PrintMessage(String str) {System.out.print(str);}
    /**This public static method outputs the menu to the console*/
    public static void PrintMenu(String mess, String[] arr)
    {
        System.out.println(mess);
        for(String str:arr)System.out.println(str);
    }
    /**This public static method outputs the description of the elements to the console*/
    public static void ShowAmm(LinkedList<Ammunition> ammunitions)
    {
        if(ammunitions!=null&&ammunitions.size()!=0)for(Ammunition ammunition: ammunitions) System.out.println(ammunition.toString());else
            System.out.println("Список пуст!!!");
    }
    /**This public static method outputs the names of the elements to the console*/
    public static void ShowAmmName(LinkedList<Ammunition> ammunitions)
    {
        int i =1;
        if(ammunitions!=null&&ammunitions.size()!=0)for(Ammunition ammunition: ammunitions){ System.out.println(i + ". " +ammunition.getName());i++;}else
            System.out.println("Список пуст!!!");
    }
}
