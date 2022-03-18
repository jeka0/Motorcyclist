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
/** Description of the Database class
 * This class stores data and methods that produce methods on them
 */
public class Db {
    /**Stored an instance of Database*/
    private static Db instance;
    /**Stored an instance of list ammunition*/
    public LinkedList<Ammunition> ammunitionList = new LinkedList<>();
    /**This private constructor prohibits the creation of an instance of the class*/
    private Db(){}
    /**This public method returns an existing database instance or creates a new one*/
    public static Db getInstance()
    {
        if(instance==null) instance = new Db();
        return instance;
    }
    /**This public method sorts the list of ammunition by weight*/
    public void SortAmmunitionByWeight()
    {
        ammunitionList.sort(new AmmunitionWeightComparator());
    }
    /**This public method finds all items suitable for the price range*/
    public LinkedList<Ammunition> FindAllByPrice(double minPrice,double maxPrice)
    {
        LinkedList<Ammunition> ammunitions = new LinkedList<>();
        for(Ammunition amm : ammunitionList)
        {
            if(amm.getPrice()>minPrice&&amm.getPrice()<maxPrice)ammunitions.add(amm);
        }
        return ammunitions;
    }
    /**This public method counts the sum of all elements*/
    public double CalculateSum()
    {
        double sum=0;
        if(ammunitionList != null) for(Ammunition ammunition:ammunitionList)sum+=ammunition.getPrice();
        return sum;
    }
    /**This public method gets data from a json file*/
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
    /**This private method parses the json file*/
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
    /**This private method adds an element of the Helmet class to the ammunition list*/
    private void AddHelmet(JSONObject object){ammunitionList.add(new Helmet(object.get("Name").toString(),object.get("ShellShape").toString(),Integer.parseInt(object.get("NumberOfShells").toString()),Double.parseDouble(object.get("Price").toString()),Double.parseDouble(object.get("Weight").toString())));}
    /**This private method adds an element of the Jacket class to the ammunition list*/
    private void AddJacket(JSONObject object){ammunitionList.add(new Jacket(object.get("Name").toString(),object.get("Materials").toString(),Integer.parseInt(object.get("NumberOfPockets").toString()),Double.parseDouble(object.get("Price").toString()),Double.parseDouble(object.get("Weight").toString())));}
    /**This private method adds an element of the Gloves class to the ammunition list*/
    private void AddGloves(JSONObject object){ammunitionList.add(new Gloves(object.get("Name").toString(),object.get("Seams").toString(),object.get("FingerProtection").toString(),Double.parseDouble(object.get("Price").toString()),Double.parseDouble(object.get("Weight").toString())));}
    /**This private method adds an element of the Trousers class to the ammunition list*/
    private void AddTrousers(JSONObject object){ammunitionList.add(new Trousers(object.get("Name").toString(),object.get("Materials").toString(),object.get("ProtectiveKneePads").toString(),Double.parseDouble(object.get("Price").toString()),Double.parseDouble(object.get("Weight").toString())));}
    /**This private method adds an element of the Shoes class to the ammunition list*/
    private void AddShoes(JSONObject object){ammunitionList.add(new Shoes(object.get("Name").toString(),object.get("Materials").toString(),object.get("Clasp").toString(),Double.parseDouble(object.get("Price").toString()),Double.parseDouble(object.get("Weight").toString())));}
    /**This public method finds all elements of the Gloves class*/
    public LinkedList<Ammunition> FindAllGloves() {LinkedList<Ammunition> ammunitions = new LinkedList<>(); for(Ammunition amm : ammunitionList) if(amm instanceof Gloves)ammunitions.add(amm);return ammunitions;}
    /**This public method finds all elements of the Helmet class*/
    public LinkedList<Ammunition> FindAllHelmet() {LinkedList<Ammunition> ammunitions = new LinkedList<>(); for(Ammunition amm : ammunitionList) if(amm instanceof Helmet)ammunitions.add(amm);return ammunitions;}
    /**This public method finds all elements of the Jacket class*/
    public LinkedList<Ammunition> FindAllJacket() {LinkedList<Ammunition> ammunitions = new LinkedList<>(); for(Ammunition amm : ammunitionList) if(amm instanceof Jacket)ammunitions.add(amm);return ammunitions;}
    /**This public method finds all elements of the Trousers class*/
    public LinkedList<Ammunition> FindAllTrousers() {LinkedList<Ammunition> ammunitions = new LinkedList<>(); for(Ammunition amm : ammunitionList) if(amm instanceof Trousers)ammunitions.add(amm);return ammunitions;}
    /**This public method finds all elements of the Shoes class*/
    public LinkedList<Ammunition> FindAllShoes() {LinkedList<Ammunition> ammunitions = new LinkedList<>(); for(Ammunition amm : ammunitionList) if(amm instanceof Shoes)ammunitions.add(amm);return ammunitions;}
}
