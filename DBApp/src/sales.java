import java.util.ArrayList;
import java.sql.*;


public class sales{
    public String sale_id;
    public String customer_id;
    public String item_id;
    public int quantity;
    public Date sale_date;
    public ArrayList <String> sale_idList = new ArrayList<String>();
    public ArrayList <String> customer_idList = new ArrayList<String>();
    public ArrayList <String> item_idList = new ArrayList<String>();
    public ArrayList <Integer> quantityList = new ArrayList<Integer>();
    public ArrayList <Date> sale_dateList = new ArrayList<Date>();
    public sales() {}
    public void clearArrayLists() {
        sale_idList.clear();
        customer_idList.clear();
        item_idList.clear();
        quantityList.clear();
        sale_dateList.clear();
    }
    public void setValExceptPurID(String customer_id, String item_id, int quantity, Date sale_date) {
        this.item_id = item_id;
        this.customer_id = customer_id;
        this.quantity = quantity;
        this.sale_date = sale_date;
    }
    public int addSale(){
        try{
            // connection to database
            String url = "jdbc:mysql://localhost/sys";
            Class.forName ("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "DataCampSQL24!");
            System.out.println("Connection Successful");

            PreparedStatement pstmt = conn.prepareStatement("SELECT CONCAT('SA', LPAD(SUBSTRING(IFNULL(MAX(sale_id), 'SA000'), 3) + 1, 3, '0')) AS newID FROM draftDB.sales");
            ResultSet rst = pstmt.executeQuery();
            clearArrayLists();

            while (rst.next()) {
                sale_id = rst.getString("newID");
            }
            pstmt = conn.prepareStatement("INSERT INTO draftDB.sales (sale_id, customer_id, item_id, quantity, sale_date) VALUE (?, ?, ?, ?, ?)");
            pstmt.setString(1, sale_id);
            pstmt.setString(2, customer_id);
            pstmt.setString(3, item_id);
            pstmt.setInt(4, quantity);
            pstmt.setDate(5, sale_date);

            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
            System.out.println("Successful run!");
            return 1;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
    // add other function if needed
}