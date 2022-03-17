package Obj;

import java.util.LinkedList;

public class Motorcyclist {
    public LinkedList<Ammunition> ammunitionList;
    public Motorcyclist()
    {
        this.ammunitionList = new LinkedList<>();
    }
    public void AddAmmunition(Ammunition ammunition)
    {
        if(ammunition==null)return;
        Boolean flag = true;int i=0;
        for(;i< ammunitionList.size();i++)if(ammunitionList.get(i).getClass()==ammunition.getClass()){flag =false; break;}
        if(!flag) ammunitionList.remove(i);
        ammunitionList.add(ammunition);
    }
    public double CalculateSum()
    {
        double sum=0;
        if(ammunitionList != null) for(Ammunition ammunition:ammunitionList)sum+=ammunition.getPrice();
        return sum;
    }
}
