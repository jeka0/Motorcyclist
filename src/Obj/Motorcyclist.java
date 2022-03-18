package Obj;

import java.util.LinkedList;
/** Description of the motorcyclist class
 * This class stores data and methods to work with them
 */
public class Motorcyclist {
    /**Stored an instance of list ammunition*/
    public LinkedList<Ammunition> ammunitionList;
    /** This public constructor creates a list of ammunition*/
    public Motorcyclist()
    {
        this.ammunitionList = new LinkedList<>();
    }
    /** This public method adds or replaces an item to the ammunition list*/
    public void AddAmmunition(Ammunition ammunition)
    {
        if(ammunition==null)return;
        Boolean flag = true;int i=0;
        for(;i< ammunitionList.size();i++)if(ammunitionList.get(i).getClass()==ammunition.getClass()){flag =false; break;}
        if(!flag) ammunitionList.remove(i);
        ammunitionList.add(ammunition);
    }
    /**This public method counts the sum of all elements*/
    public double CalculateSum()
    {
        double sum=0;
        if(ammunitionList != null) for(Ammunition ammunition:ammunitionList)sum+=ammunition.getPrice();
        return sum;
    }
}
