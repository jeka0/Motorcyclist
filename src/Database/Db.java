package Database;

import Obj.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import Obj.Helmet;
import com.company.AmmunitionWeightComparator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Db {
    private static Db instance;
    public LinkedList<Ammunition> ammunitionList = new LinkedList<>();
    private Db(){}
    public static Db getInstance()
    {
        if(instance==null) instance = new Db();
        return instance;
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
    public double CalculateSum()
    {
        double sum=0;
        if(ammunitionList != null) for(Ammunition ammunition:ammunitionList)sum+=ammunition.getPrice();
        return sum;
    }
    public void ReadDB(final String filePath)
    {
        try {
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            jsonObject.forEach((key,value)->{Pars(key.toString(),(JSONArray)value);});
        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }
    private void Pars(String name,JSONArray array)
    {
        for(int i=0;i<array.size();i++)
        {
            JSONObject object = (JSONObject)array.get(i);
            switch (name)
            {
                case "Helmets": AddHelmet(object); break;
                case "Jackets": AddJacket(object); break;
                case "Gloves": AddGloves(object); break;
                case "Trousers": AddTrousers(object); break;
                case "Shoes": AddShoes(object); break;
            }
        }
    }
    private void AddHelmet(JSONObject object){ammunitionList.add(new Helmet(object.get("Name").toString(),object.get("ShellShape").toString(),Integer.parseInt(object.get("NumberOfShells").toString()),Double.parseDouble(object.get("Price").toString()),Double.parseDouble(object.get("Weight").toString())));}
    private void AddJacket(JSONObject object){ammunitionList.add(new Jacket(object.get("Name").toString(),object.get("Materials").toString(),Integer.parseInt(object.get("NumberOfPockets").toString()),Double.parseDouble(object.get("Price").toString()),Double.parseDouble(object.get("Weight").toString())));}
    private void AddGloves(JSONObject object){ammunitionList.add(new Gloves(object.get("Name").toString(),object.get("Seams").toString(),object.get("FingerProtection").toString(),Double.parseDouble(object.get("Price").toString()),Double.parseDouble(object.get("Weight").toString())));}
    private void AddTrousers(JSONObject object){ammunitionList.add(new Trousers(object.get("Name").toString(),object.get("Materials").toString(),object.get("ProtectiveKneePads").toString(),Double.parseDouble(object.get("Price").toString()),Double.parseDouble(object.get("Weight").toString())));}
    private void AddShoes(JSONObject object){ammunitionList.add(new Shoes(object.get("Name").toString(),object.get("Materials").toString(),object.get("Clasp").toString(),Double.parseDouble(object.get("Price").toString()),Double.parseDouble(object.get("Weight").toString())));}
    public LinkedList<Ammunition> FindAllGloves() {LinkedList<Ammunition> ammunitions = new LinkedList<>(); for(Ammunition amm : ammunitionList) if(amm instanceof Gloves)ammunitions.add(amm);return ammunitions;}
    public LinkedList<Ammunition> FindAllHelmet() {LinkedList<Ammunition> ammunitions = new LinkedList<>(); for(Ammunition amm : ammunitionList) if(amm instanceof Helmet)ammunitions.add(amm);return ammunitions;}
    public LinkedList<Ammunition> FindAllJacket() {LinkedList<Ammunition> ammunitions = new LinkedList<>(); for(Ammunition amm : ammunitionList) if(amm instanceof Jacket)ammunitions.add(amm);return ammunitions;}
    public LinkedList<Ammunition> FindAllTrousers() {LinkedList<Ammunition> ammunitions = new LinkedList<>(); for(Ammunition amm : ammunitionList) if(amm instanceof Trousers)ammunitions.add(amm);return ammunitions;}
    public LinkedList<Ammunition> FindAllShoes() {LinkedList<Ammunition> ammunitions = new LinkedList<>(); for(Ammunition amm : ammunitionList) if(amm instanceof Shoes)ammunitions.add(amm);return ammunitions;}
}
