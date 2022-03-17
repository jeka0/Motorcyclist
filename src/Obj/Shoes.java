package Obj;

public class Shoes  extends Ammunition{
    private String materials;
    private String clasp;
    public Shoes(String ammunitionName,String materials,String clasp,double price,double weight)
    {
        super(ammunitionName, price, weight);
        this.clasp = clasp;
        this.materials = materials;
    }
    public String GetMaterials() {return materials;}
    public String GetClasp() {return clasp;}
    @Override
    public String toString() {return "Название ботинок: " + super.getName() +"\nМатериал: "+ materials +"\nЗастежка: "+ clasp + "\nВес: " + super.getWeight() + "\nЦена: " + super.getPrice();}
}
