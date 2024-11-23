import java.util.ArrayList;
import java.sql.*;




public class returns{
  public String return_id;
  public String pharmacist_id;
  public String sale_id;
  public String return_reason;
  public Date return_date;
  public ArrayList <String> return_idList = new ArrayList<String>();
  public ArrayList <String> pharmacist_idList = new ArrayList<String>();
  public ArrayList <String> sale_idList = new ArrayList<String>();
  public ArrayList <String> return_reasonList = new ArrayList<String>();
  public ArrayList <String> return_dateList = new ArrayList<String>();
  public returns() {}

  public void clearArrayLists() {
    return_idList.clear();
    pharmacist_idList.clear();
    sale_idList.clear();
    return_reasonList.clear();
    return_dateList.clear();
}

public void setValExceptRetID (String pharmacist_id, String sale_id, String return_reason, Date return_date) {
    this.pharmacist_id = pharmacist_id;
    this.sale_id = sale_id;
    this.return_reason = return_reason;
    this.return_date = return_date;
}

  public int addReturn(){
    try{
      // connection to database
      String url = "jdbc:mysql://localhost/sys";
      Class.forName ("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection(url, "root", "DataCampSQL24!");
      System.out.println("Connection Successful");

      PreparedStatement pstmt = conn.prepareStatement("SELECT CONCAT('R', LPAD(SUBSTRING(IFNULL(MAX(return_id), 'R000'), 2) + 1, 3, '0')) AS newID FROM draftDB.returns");
      ResultSet rst = pstmt.executeQuery();
      clearArrayLists();
      while (rst.next()) {
          return_id = rst.getString("newID");
      }
      pstmt = conn.prepareStatement("INSERT INTO draftDB.returns (return_id, pharmacist_id, sale_id, return_reason, return_date) VALUE (?, ?, ?, ?, ?)");
      pstmt.setString(1, return_id);
      pstmt.setString(2, pharmacist_id);
      pstmt.setString(3, sale_id);
      pstmt.setString(4, return_reason);
      pstmt.setDate(5, return_date);

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