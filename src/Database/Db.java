package Database;

import Obj.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import Obj.Helmet;
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
}
