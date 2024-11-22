// package
import java.util.*;
import java.sql.*;


public class customers{
    public String customer_id;
    public String name;
    public String contact_number;
    public String email;
    public String city;
    public ArrayList <String> customer_idList = new ArrayList<String>();
    public ArrayList <String> nameList = new ArrayList<String>();
    public ArrayList <String> contact_numberList = new ArrayList<String>();
    public ArrayList <String> emailList = new ArrayList<String>();
    public ArrayList <String> cityList = new ArrayList<String>();
    public customers() {}

    public void clearArrayLists() {
        customer_idList.clear();
        nameList.clear();
        contact_numberList.clear();
        emailList.clear();
        cityList.clear();
    }

    public void setValExceptCusID(String name, String contact_number, String email, String city) {
        this.name = name;
        this.contact_number = contact_number;
        this.email = email;
        this.city = city;
    }
    public int addCustomer(){
        try{
            // connection to database
            String url = "jdbc:mysql://localhost/sys";
            Class.forName ("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "DataCampSQL24!");
            System.out.println("Connection Successful");

            PreparedStatement pstmt = conn.prepareStatement("SELECT CONCAT('C', LPAD(SUBSTRING(IFNULL(MAX(customer_id), 'C000'), 2) + 1, 3, '0')) AS newID FROM draftDB.customers");
            ResultSet rst = pstmt.executeQuery();
            clearArrayLists();
            while (rst.next()) {
                customer_id = rst.getString("newID");
            }
            pstmt = conn.prepareStatement("INSERT INTO draftDB.customers (customer_id, name, contact_number, email, city) VALUE (?, ?, ?, ?, ?)");
            System.out.println("Here");
            pstmt.setString(1, customer_id);
            pstmt.setString(2, name);
            pstmt.setString(3, contact_number);
            pstmt.setString(4, email);
            pstmt.setString(5, city);

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