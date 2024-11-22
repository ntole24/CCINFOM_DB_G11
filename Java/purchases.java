// package
import java.util.ArrayList;
import java.sql.*;


public class purchases {
    public String purchase_id;
    public String item_id;
    public Date purchase_date;
    public int quantity;
    public Date expiration_date;
    public ArrayList <String> purchase_idList = new ArrayList<String>();
    public ArrayList <String> item_idList = new ArrayList<String>();
    public ArrayList <Date> purchase_dateList = new ArrayList<Date>();
    public ArrayList <String> quantityList = new ArrayList<String>();
    public ArrayList <String> expiration_dateList = new ArrayList<String>();
    public purchases() {}

    public void clearArrayLists() {
        purchase_idList.clear();
        item_idList.clear();
        purchase_dateList.clear();
        quantityList.clear();
        expiration_dateList.clear();
    }
    public void setValExceptPurID(String item_id, Date purchase_date, int quantity, Date expiration_date) {
        this.item_id = item_id;
        this.purchase_date = purchase_date;
        this.quantity = quantity;
        this.expiration_date = expiration_date;
    }
    public int addPurchase(){
        try{
            // connection to database
            String url = "jdbc:mysql://localhost/sys";
            Class.forName ("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "DataCampSQL24!");
            System.out.println("Connection Successful");

            PreparedStatement pstmt = conn.prepareStatement("SELECT CONCAT('PU', LPAD(SUBSTRING(IFNULL(MAX(purchase_id), 'PU000'), 3) + 1, 3, '0')) AS newID FROM draftDB.purchases");
            ResultSet rst = pstmt.executeQuery();
            clearArrayLists();
            while (rst.next()) {
                purchase_id = rst.getString("newID");
            }
            pstmt = conn.prepareStatement("INSERT INTO draftDB.purchases (purchase_id, item_id, purchase_date, quantity, expiration_date) VALUE (?, ?, ?, ?, ?)");
            System.out.println("Here");
            pstmt.setString(1, purchase_id);
            pstmt.setString(2, item_id);
            pstmt.setDate(3, purchase_date);
            pstmt.setInt(4, quantity);
            pstmt.setDate(5, expiration_date);

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