// put packages if needed
import java.util.ArrayList; // removed because Date class will overlap with sql date class
import java.sql.*;
public class staff {
    public String staff_id;
    public String name;
    public Date date_employed;
    public Date date_released;
    public String job_id;
    public String status;

    public ArrayList <String> staff_idList = new ArrayList<String>();
    public ArrayList <String> nameList = new ArrayList<String>();
    public ArrayList <Date> date_employedList = new ArrayList<Date>();
    public ArrayList <Date> date_releasedList = new ArrayList<Date>();
    public ArrayList <String> job_idList = new ArrayList<String>();
    public ArrayList <String> statusList = new ArrayList<String>();
    public staff() {}

    public void clearArrayLists() {
        staff_idList.clear();
        nameList.clear();
        date_employedList.clear();
        date_releasedList.clear();
        job_idList.clear();
        statusList.clear();
    }

    public void setValExceptStaID(String name, Date date_employed, Date date_released, String job_id, String status) {
        this.name = name;
        this.date_employed = date_employed;
        this.date_released = date_released;
        this.job_id = job_id;
        this.status = status;
    }

    public void addStaff(){
        try{
            // connection to database sql and other things
            String url = "jdbc:mysql://localhost/sys";
            Class.forName ("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "DataCampSQL24!");
            System.out.println("Connection Successful");

            PreparedStatement pstmt = conn.prepareStatement("SELECT CONCAT('ST', LPAD(SUBSTRING(IFNULL(MAX(staff_id), 'ST000'), 3) + 1, 3, '0')) AS newID FROM draftDB.staff");
            ResultSet rst = pstmt.executeQuery();
            clearArrayLists();
            while (rst.next()) {
                staff_id = rst.getString("newID");
            }

            pstmt = conn.prepareStatement("INSERT INTO draftDB.staff (staff_id, name, date_employed, date_released, job_id, status) VALUE (?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, staff_id);
            pstmt.setString(2, name);
            pstmt.setDate(3, date_employed);
            pstmt.setDate(4, date_released);
            pstmt.setString(5, job_id);
            pstmt.setString(6, status);

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