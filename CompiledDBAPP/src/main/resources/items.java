// put packages if needed
import java.util.*;
import java.sql.*;
public class items{
    public int item_id;
    public String name;
    public String description;
    public int quantity;
    public double selling_price;

    public ArrayList <Integer> item_idList = new ArrayList<Integer>();
    public ArrayList <String> nameList = new ArrayList<String>();
    public ArrayList <String> descriptionList = new ArrayList<String>();
    public ArrayList <Integer> quantityList = new ArrayList<Integer>();
    public ArrayList <Double> selling_priceList = new ArrayList<Double>();
    public items() {}
    public static void addItem(){
        try{
            // connection to database sql and other things
            String url = "jdbc:mysql://localhost/sys";
            Class.forName ("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "DataCampSQL24!");
            System.out.println("Connection Successful");
            conn.close();
            // return 1;
        } catch(Exception e){
            System.out.println(e.getMessage());
            // return 0;
        }
    }
    // add other function if needed
    public static void main(String[] args) {
        addItem();
    }
}