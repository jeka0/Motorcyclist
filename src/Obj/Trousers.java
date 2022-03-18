package Obj;
/** Description of the Trousers class
 * This class stores data and methods to work with them
 */
public class Trousers extends Ammunition{
    /**Stored an instance of String*/
    private String materials;
    /**Stored an instance of String*/
    private String protectiveKneePads;
    /** This public constructor fills in the data*/
    public Trousers(String ammunitionName,String materials,String protectiveKneePads,double price,double weight)
    {
        super(ammunitionName, price, weight);
        this.protectiveKneePads = protectiveKneePads;
        this.materials = materials;
    }
    /** This public method returns string type data*/
    public String GetMaterials() {return materials;}
    /** This public method returns string type data*/
    public String GetProtectiveKneePads() {return protectiveKneePads;}
    @Override
    /** This public method converts an object to a string*/
    public String toString() {return "Название штанов: " + super.getName() +"\nМатериал: "+materials +"\nЗащитные наколенники: "+ protectiveKneePads + "\nВес: " + super.getWeight() + "\nЦена: " + super.getPrice();}

}
