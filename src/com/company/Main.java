package com.company;

import Database.Db;
import Obj.Ammunition;
import Obj.Motorcyclist;

import java.util.LinkedList;

public class Main {
    private static Db db = Db.getInstance();
    private static Motorcyclist motorcyclist = new Motorcyclist();
    private static String[] operationMenu = {
            "1. Добавить/Заменить амуницию мотоциклисту",
            "2. Подсчитать стоимость амуниции мотоциклиста",
            "3. Показать амуницию мотоциклиста",
            "4. Показать всю амуницию ",
            "5. Показать отсортированную амуницию (на основе веса)",
            "6. Подсчитать общую стоимость всей амуниции",
            "7. Показать элементы амуниции соответствующие диапазону цены",
            "0. Выход"};
    private static String[] typesMenu ={
            "1. Шлема",
            "2. Куртки",
            "3. Перчатки",
            "4. Штаны",
            "5. Ботинки"
    };
    public static void main(String[] args) {
        db = Db.getInstance();
       db.ReadDB("src\\Database\\Data.json");
       menu();
    }

    public static void menu()
    {
        boolean flag;
        do {
            flag = true;
            Console.PrintMenu("Выберите действие:",operationMenu);
            int num = Console.ReadInt("#/>",0,7);
            switch (num)
            {
                case 0: flag = false;break;
                case 1: typeSelectionMenu();break;
                case 2: Console.PrintMessage("Общая стоимость амуниции мотоциклиста: " + motorcyclist.CalculateSum() + "\n");break;
                case 3: Console.ShowAmm(motorcyclist.ammunitionList);break;
                case 4: Console.ShowAmm(db.ammunitionList);break;
                case 5: db.SortAmmunitionByWeight();Console.ShowAmm(db.ammunitionList);break;
                case 6: Console.PrintMessage("Общая стоимость всей амуниции: " + db.CalculateSum() + "\n");break;
                case 7: int min = Console.ReadInt("Введите минимальную цену: ",0);Console.ShowAmm(db.FindAllByPrice(min,Console.ReadInt("Введите максимальную цену: ",min)));break;
            }
        }while(flag);
    }
    public static void typeSelectionMenu()
    {
        Console.PrintMenu("Выберите тип амуниции:",typesMenu);
        int num = Console.ReadInt("#/>",1,5);
        LinkedList<Ammunition> masAmm=null;
        switch (num)
        {
            case 1:masAmm = db.FindAllHelmet(); break;
            case 2:masAmm = db.FindAllJacket(); break;
            case 3:masAmm = db.FindAllGloves(); break;
            case 4:masAmm = db.FindAllTrousers(); break;
            case 5:masAmm = db.FindAllShoes(); break;
        }
        Console.PrintMessage("Выберите амуницию:\n");
        Console.ShowAmmName(masAmm);
        num = Console.ReadInt("#/>",1,masAmm.size());
        motorcyclist.AddAmmunition(masAmm.get(num-1));
    }
}
