import java.util.ArrayList;
import java.sql.*;

public class supplier_item_cost{
    public String supplier_id;
    public String item_id;
    public double unit_cost;
    public ArrayList <String> supplier_idList = new ArrayList<String>();
    public ArrayList <String> item_idList = new ArrayList<String>();
    public ArrayList <Double> unit_costList = new ArrayList<Double>();
    public supplier_item_cost() {}

    public void clearArrayLists() {
        supplier_idList.clear();
        item_idList.clear();
        unit_costList.clear();
    }

    public void setVals(String item_id, String supplier_id, double unit_cost) {
        this.item_id = item_id;
        this.supplier_id = supplier_id;
        this.unit_cost = unit_cost;
    }

    public double getItemSupplierComboPrice (String inputItemID, String inputSupplierID) {
        try {
            // connection to database sql and other things
            String url = "jdbc:mysql://localhost/sys";
            Class.forName ("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "DataCampSQL24!");
            System.out.println("Connection Successful");

            String queryBuffer = "SELECT sic.unit_cost FROM draftDB.supplier_item_cost sic WHERE sic.item_id = '%s' AND sic.supplier_id = '%s'";
            queryBuffer = String.format(queryBuffer, inputItemID, inputSupplierID);

            PreparedStatement pstmt = conn.prepareStatement(queryBuffer);
            ResultSet rst = pstmt.executeQuery();
            clearArrayLists();

            unit_cost = -1;

            while (rst.next()) 
                unit_cost = rst.getDouble("unit_cost");
            
            pstmt.close();
            conn.close();

            System.out.println("Successful run!");

            return unit_cost;
            // return 1;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
    public int addSupplierItemCost(){
        try {
            // connection to database
            // connection to database
            String url = "jdbc:mysql://localhost/sys";
            Class.forName ("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "DataCampSQL24!");
            System.out.println("Connection Successful");

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO draftDB.supplier_item_cost (item_id, supplier_id, unit_cost) VALUE (?, ?, ?)");
            pstmt.setString(1, item_id);
            pstmt.setString(2, supplier_id);
            pstmt.setDouble(3, unit_cost);

            pstmt.executeUpdate();

            pstmt.close();
            conn.close();

            clearArrayLists();
            return 1;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
    // add other function if needed
}