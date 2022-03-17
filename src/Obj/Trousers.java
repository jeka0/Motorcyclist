package Obj;

public class Trousers extends Ammunition{
    private String materials;
    private String protectiveKneePads;
    public Trousers(String ammunitionName,String materials,String protectiveKneePads,double price,double weight)
    {
        super(ammunitionName, price, weight);
        this.protectiveKneePads = protectiveKneePads;
        this.materials = materials;
    }
    public String GetMaterials() {return materials;}
    public String GetProtectiveKneePads() {return protectiveKneePads;}
    @Override
    public String toString() {return "Название штанов: " + super.getName() +"\nМатериал: "+materials +"\nЗащитные наколенники: "+ protectiveKneePads + "\nВес: " + super.getWeight() + "\nЦена: " + super.getPrice();}

}
