import java.util.ArrayList;
import java.sql.*;


public class payrolls {
  public String payroll_id;
  public String staff_id;
  public String payment_id;
  public ArrayList <String> payroll_idList = new ArrayList<String>();
  public ArrayList <String> staff_idList = new ArrayList<String>();
  public ArrayList <String> payment_idList = new ArrayList<String>();
  public payrolls() {}

  public void clearArrayLists() {
    payroll_idList.clear();
    staff_idList.clear();
    payment_idList.clear();
    }
    public void setValExceptJobID(String staff_id, String payment_id) {
        this.staff_id = staff_id;
        this.payment_id = payment_id;
    }
  public int addPayroll(){
    try{
      // connection to database
      String url = "jdbc:mysql://localhost/sys";
        Class.forName ("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, "root", "DataCampSQL24!");
        System.out.println("Connection Successful");

        PreparedStatement pstmt = conn.prepareStatement("SELECT CONCAT('PA', LPAD(SUBSTRING(IFNULL(MAX(payroll_id), 'PA000'), 3) + 1, 3, '0')) AS newID FROM draftDB.payrolls");
        ResultSet rst = pstmt.executeQuery();
        clearArrayLists();

        while (rst.next()) {
            payroll_id = rst.getString("newID");
        }
        pstmt = conn.prepareStatement("INSERT INTO draftDB.payrolls (payroll_id, staff_id, payment_id) VALUE (?, ?, ?)");
        pstmt.setString(1, payroll_id);
        pstmt.setString(2, staff_id);
        pstmt.setString(3, payment_id);

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