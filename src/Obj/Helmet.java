package Obj;
/** Description of the Helmet class
 * This class stores data and methods to work with them
 */
public class Helmet extends Ammunition{
    /**Stored an instance of String*/
    private String shellShape;
    /**Stored an instance of int*/
    private int NumberOfShells;
    /** This public constructor fills in the data*/
    public Helmet(String ammunitionName,String shellShape,int NumberOfShells,double price,double weight)
    {
        super(ammunitionName, price, weight);
        this.NumberOfShells = NumberOfShells;
        this.shellShape = shellShape;
    }
    /** This public method returns string type data*/
    public String GetShellShape() {return shellShape;}
    /** This public method returns int type data*/
    public int GetNumberOfShells() {return NumberOfShells;}
    @Override
    /** This public method converts an object to a string*/
    public String toString() {return "Название шлема: " + super.getName() +"\nФорма оболочки: "+shellShape +"\nКоличество оболочек: "+NumberOfShells + "\nВес: " + super.getWeight() + "\nЦена: " + super.getPrice();}
}
