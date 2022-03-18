package Obj;
/** Description of the Ammunition class
 * This class stores data and methods to work with them
 */
public abstract class Ammunition
{
    /**Stored an instance of String*/
    private String ammunitionName;
    /**Stored an instance of double*/
    private double price;
    /**Stored an instance of double*/
    private double weight;
    /** This public constructor fills in the data*/
    public Ammunition(String ammunitionName,double price,double weight)
    {
        this.ammunitionName = ammunitionName;
        this.price=price;
        this.weight=weight;
    }
    /** This public method returns string type data*/
    public String getName(){return ammunitionName;}
    /** This public method returns double type data*/
    public double getPrice(){return price;}
    /** This public method returns double type data*/
    public double getWeight(){return weight;}
    @Override
    /** This public method converts an object to a string*/
    public abstract String toString();

}
