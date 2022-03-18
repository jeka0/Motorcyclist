package Obj;
/** Description of the Shoes class
 * This class stores data and methods to work with them
 */
public class Shoes  extends Ammunition{
    /**Stored an instance of String*/
    private String materials;
    /**Stored an instance of String*/
    private String clasp;
    /** This public constructor fills in the data*/
    public Shoes(String ammunitionName,String materials,String clasp,double price,double weight)
    {
        super(ammunitionName, price, weight);
        this.clasp = clasp;
        this.materials = materials;
    }
    /** This public method returns string type data*/
    public String GetMaterials() {return materials;}
    /** This public method returns string type data*/
    public String GetClasp() {return clasp;}
    @Override
    /** This public method converts an object to a string*/
    public String toString() {return "Название ботинок: " + super.getName() +"\nМатериал: "+ materials +"\nЗастежка: "+ clasp + "\nВес: " + super.getWeight() + "\nЦена: " + super.getPrice();}
}
