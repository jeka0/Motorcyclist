package Obj;

public class Helmet extends Ammunition{
    private String shellShape;
    private int NumberOfShells;
    public Helmet(String ammunitionName,String shellShape,int NumberOfShells,double price,double weight)
    {
        super(ammunitionName, price, weight);
        this.NumberOfShells = NumberOfShells;
        this.shellShape = shellShape;
    }
    public String GetShellShape() {return shellShape;}
    public int GetNumberOfShells() {return NumberOfShells;}
    @Override
    public String toString() {return "Название шлема: " + super.getName() +"\nФорма оболочки: "+shellShape +"\nКоличество оболочек: "+NumberOfShells + "\nВес: " + super.getWeight() + "\nЦена: " + super.getPrice();}
}
