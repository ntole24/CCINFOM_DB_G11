// packages 
import java.util.*;
import java.sql.*;


public class suppliers {
    public String supplier_id;
    public String assigned_staff_id;
    public String name;
    public String contact_number;
    public String email;
    public String city;
    public ArrayList <String> supplier_idList = new ArrayList<String>();
    public ArrayList <String> assigned_staff_idList = new ArrayList<String>();
    public ArrayList <String> nameList = new ArrayList<String>();
    public ArrayList <String> contact_numberList = new ArrayList<String>();
    public ArrayList <String> emailList = new ArrayList<String>();
    public ArrayList <String> cityList = new ArrayList<String>();


    public suppliers() {}

    public void clearArrayLists() {
        supplier_idList.clear();
        assigned_staff_idList.clear();
        nameList.clear();
        contact_numberList.clear();
        emailList.clear();
        cityList.clear();
    }

    public void setValExceptSupID(String assigned_staff_id, String name, String contact_number, String email, String city) {
        this.assigned_staff_id = assigned_staff_id;
        this.name = name;
        this.contact_number = contact_number;
        this.email = email;
        this.city = city;
    }

    public int addSupplier(){
        try{
            String url = "jdbc:mysql://localhost/sys";
            Class.forName ("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "DataCampSQL24!");
            System.out.println("Connection Successful");

            PreparedStatement pstmt = conn.prepareStatement("SELECT CONCAT('S', LPAD(SUBSTRING(IFNULL(MAX(supplier_id), 'S000'), 2) + 1, 3, '0')) AS newID FROM draftDB.suppliers");
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                supplier_id = rst.getString("newID");
            }

            pstmt = conn.prepareStatement("INSERT INTO draftDB.suppliers (supplier_id, assigned_staff_id, name, contact_number, email, city) VALUE (?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, supplier_id);
            pstmt.setString(2, assigned_staff_id);
            pstmt.setString(3, name);
            pstmt.setString(4, contact_number);
            pstmt.setString(5, email);
            pstmt.setString(6, city);

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