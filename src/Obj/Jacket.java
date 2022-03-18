package Obj;
/** Description of the Jacket class
 * This class stores data and methods to work with them
 */
public class Jacket extends Ammunition{
    /**Stored an instance of String*/
    private String materials;
    /**Stored an instance of int*/
    private int NumberOfPockets;
    /** This public constructor fills in the data*/
    public Jacket(String ammunitionName,String materials,int NumberOfPockets,double price,double weight)
    {
        super(ammunitionName, price, weight);
        this.NumberOfPockets = NumberOfPockets;
        this.materials = materials;
    }
    /** This public method returns string type data*/
    public String GetMaterials() {return materials;}
    /** This public method returns int type data*/
    public int GetNumberOfPockets() {return NumberOfPockets;}
    @Override
    /** This public method converts an object to a string*/
    public String toString() {return "Название куртки: " + super.getName() +"\nМатериал: "+materials +"\nКоличество карманов: "+NumberOfPockets + "\nВес: " + super.getWeight() + "\nЦена: " + super.getPrice();}

}

