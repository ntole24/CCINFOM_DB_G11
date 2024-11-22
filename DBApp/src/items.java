// put packages if needed
import java.util.*;
import java.sql.*;
public class items{
    public String item_id;
    public String name;
    public String description;
    public int quantity;
    public double selling_price;

    public ArrayList <String> item_idList = new ArrayList<String>();
    public ArrayList <String> nameList = new ArrayList<String>();
    public ArrayList <String> descriptionList = new ArrayList<String>();
    public ArrayList <Integer> quantityList = new ArrayList<Integer>();
    public ArrayList <Double> selling_priceList = new ArrayList<Double>();
    public items() {}

    public void clearArrayLists() {
        item_idList.clear();
        nameList.clear();
        descriptionList.clear();
        quantityList.clear();
        selling_priceList.clear();
    }

    public String getIDFromName(String itemName) {
        try {
            // connection to database sql and other things
            String url = "jdbc:mysql://localhost/sys";
            Class.forName ("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "DataCampSQL24!");
            System.out.println("Connection Successful");

            String queryBuffer = "SELECT i.item_id FROM draftDB.items i WHERE i.name = '";
            queryBuffer += itemName;
            queryBuffer += "' LIMIT 1;";

            PreparedStatement pstmt = conn.prepareStatement(queryBuffer);
            ResultSet rst = pstmt.executeQuery();
            clearArrayLists();

            while (rst.next()) 
                item_id = rst.getString("item_id");
            
            pstmt.close();
            conn.close();

            System.out.println("Successful run!");

            return item_id;
            // return 1;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void items_overQuantity () {
        try{
            // connection to database sql and other things
            String url = "jdbc:mysql://localhost/sys";
            Class.forName ("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "DataCampSQL24!");
            System.out.println("Connection Successful");

            PreparedStatement pstmt = conn.prepareStatement("SELECT i.item_id, i.name FROM draftDB.items i WHERE i.quantity > 100");
            ResultSet rst = pstmt.executeQuery();
            clearArrayLists();

            while (rst.next()) { // iterate through each row and add the results
                item_id = rst.getString("item_id");
                name = rst.getString("name");
                item_idList.add(item_id);
                nameList.add(name);
            }
            pstmt.close();
            conn.close();
            System.out.println("Successful run!");
            // return 1;
        } catch(Exception e){
            System.out.println(e.getMessage());
            // return 0;
        }
    }
    public void addItem(){
        try{
            // connection to database sql and other things
            String url = "jdbc:mysql://localhost/sys";
            Class.forName ("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "DataCampSQL24!");
            System.out.println("Connection Successful");

            // Initialize the prepared statement to use
            PreparedStatement pstmt = conn.prepareStatement("SELECT CONCAT('I', LPAD(SUBSTRING(IFNULL(MAX(item_id), 'I000'), 2) + 1, 3, '0')) AS newID FROM draftDB.items");
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                item_id = rst.getString("newID");
            }

            pstmt = conn.prepareStatement("INSERT INTO draftDB.items (item_id, name, description, quantity, selling_price) VALUE (?, ?, ?, ?, ?)");
            pstmt.setString(1, item_id);
            pstmt.setString(2, name);
            pstmt.setString(3, description);
            pstmt.setInt(4, quantity);
            pstmt.setDouble(5, selling_price);

            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
            System.out.println("Successful run!");
            // return 1;
        } catch(Exception e){
            System.out.println(e.getMessage());
            // return 0;
        }
    }
    // add other function if needed
}