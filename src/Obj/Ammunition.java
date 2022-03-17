package Obj;

public abstract class Ammunition
{
    private String ammunitionName;
    private double price;
    private double weight;
    public Ammunition(String ammunitionName,double price,double weight)
    {
        this.ammunitionName = ammunitionName;
        this.price=price;
        this.weight=weight;
    }
    public String getName(){return ammunitionName;}
    public double getPrice(){return price;}
    public double getWeight(){return weight;}
    @Override
    public abstract String toString();

}
