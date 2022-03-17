package com.company;

import Obj.Ammunition;

import java.util.LinkedList;
import java.util.Scanner;

public class Console {
    static Scanner scanner = new Scanner(System.in);
    public static int ReadInt(String str, int min){return ReadInt(str,min,-1);}
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
    public static void PrintMessage(String str) {System.out.print(str);}
    public static void PrintMenu(String mess, String[] arr)
    {
        System.out.println(mess);
        for(String str:arr)System.out.println(str);
    }
    public static void ShowAmm(LinkedList<Ammunition> ammunitions)
    {
        if(ammunitions!=null&&ammunitions.size()!=0)for(Ammunition ammunition: ammunitions) System.out.println(ammunition.toString());else
            System.out.println("Список пуст!!!");
    }
    public static void ShowAmmName(LinkedList<Ammunition> ammunitions)
    {
        int i =1;
        if(ammunitions!=null&&ammunitions.size()!=0)for(Ammunition ammunition: ammunitions){ System.out.println(i + ". " +ammunition.getName());i++;}else
            System.out.println("Список пуст!!!");
    }
}
