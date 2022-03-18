package Obj;
/** Description of the Gloves class
 * This class stores data and methods to work with them
 */
public class Gloves extends Ammunition{
    /**Stored an instance of String*/
    private String seams;
    /**Stored an instance of String*/
    private String FingerProtection;
    /** This public constructor fills in the data*/
    public Gloves(String ammunitionName,String seams,String FingerProtection,double price,double weight)
    {
        super(ammunitionName, price, weight);
        this.FingerProtection = FingerProtection;
        this.seams = seams;
    }
    /** This public method returns string type data*/
    public String GetSeams() {return seams;}
    /** This public method returns string type data*/
    public String GetFingerProtection() {return FingerProtection;}
    @Override
    /** This public method converts an object to a string*/
    public String toString() {return "Название перчаток: " + super.getName() +"\nШвы: "+seams +"\nЗащита на пальцах: "+FingerProtection + "\nВес: " + super.getWeight() + "\nЦена: " + super.getPrice();}
}
