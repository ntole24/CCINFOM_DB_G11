import java.util.*;
import java.sql.*;



public class jobs {
    public String job_id;
    public String job_title;
    public double salary;
    public ArrayList <String> job_idList = new ArrayList<String>();
    public ArrayList <String> job_titleList = new ArrayList<String>();
    public ArrayList <Double> salaryList = new ArrayList<Double>();
    public jobs() {}
    public void clearArrayLists() {
        job_idList.clear();
        job_titleList.clear();
        salaryList.clear();
    }
    public void setValExceptJobID(String job_title, double salary) {
        this.job_title = job_title;
        this.salary = salary;
    }
    public int addJob(){
        try{
            String url = "jdbc:mysql://localhost/sys";
            Class.forName ("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "DataCampSQL24!");
            System.out.println("Connection Successful");

            PreparedStatement pstmt = conn.prepareStatement("SELECT CONCAT('J', LPAD(SUBSTRING(IFNULL(MAX(job_id), 'J000'), 2) + 1, 3, '0')) AS newID FROM draftDB.jobs");
            ResultSet rst = pstmt.executeQuery();
            clearArrayLists();

            while (rst.next()) {
                job_id = rst.getString("newID");
            }
            pstmt = conn.prepareStatement("INSERT INTO draftDB.jobs (job_id, job_title, salary) VALUE (?, ?, ?)");
            pstmt.setString(1, job_id);
            pstmt.setString(2, job_title);
            pstmt.setDouble(3, salary);

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