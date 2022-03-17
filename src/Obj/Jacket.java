package Obj;

public class Jacket extends Ammunition{
    private String materials;
    private int NumberOfPockets;
    public Jacket(String ammunitionName,String materials,int NumberOfPockets,double price,double weight)
    {
        super(ammunitionName, price, weight);
        this.NumberOfPockets = NumberOfPockets;
        this.materials = materials;
    }
    public String GetMaterials() {return materials;}
    public int GetNumberOfPockets() {return NumberOfPockets;}
    @Override
    public String toString() {return "Название куртки: " + super.getName() +"\nMaterials: "+materials +"\nКоличество карманов: "+NumberOfPockets + "\nВес: " + super.getWeight() + "\nЦена: " + super.getPrice();}

}

