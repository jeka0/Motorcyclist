package Obj;

public class Gloves extends Ammunition{
    private String seams;
    private String FingerProtection;
    public Gloves(String ammunitionName,String seams,String FingerProtection,double price,double weight)
    {
        super(ammunitionName, price, weight);
        this.FingerProtection = FingerProtection;
        this.seams = seams;
    }
    public String GetSeams() {return seams;}
    public String GetFingerProtection() {return FingerProtection;}
    @Override
    public String toString() {return "Название перчаток: " + super.getName() +"\nШвы: "+seams +"\nЗащита на пальцах: "+FingerProtection + "\nВес: " + super.getWeight() + "\nЦена: " + super.getPrice();}
}
