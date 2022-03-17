package Obj;

import com.company.AmmunitionWeightComparator;

import java.util.LinkedList;

public class Motorcyclist {
    private LinkedList<Ammunition> ammunitionList;
    public Motorcyclist()
    {
        this.ammunitionList = new LinkedList<>();
    }
    public void AddAmmunition(Ammunition ammunition)
    {
        if(ammunition==null)return;
        ammunitionList.add(ammunition);
    }
    public double CalculateSum(LinkedList<Ammunition> ammList)
    {
        double sum=0;
        if(ammList != null) for(Ammunition ammunition:ammList)sum+=ammunition.getPrice();
        return sum;
    }
    public void SortAmmunitionByWeight()
    {
        ammunitionList.sort(new AmmunitionWeightComparator());
    }
    public LinkedList<Ammunition> FindAllByPrice(double minPrice,double maxPrice)
    {
       LinkedList<Ammunition> ammunitions = new LinkedList<>();
       for(Ammunition amm : ammunitionList)
       {
           if(amm.getPrice()>minPrice&&amm.getPrice()<maxPrice)ammunitions.add(amm);
       }
       return ammunitions;
    }


}
