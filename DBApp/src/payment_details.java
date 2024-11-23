import java.util.ArrayList;
import java.sql.*;



public class payment_details{
    public String payment_id;
    public Date payment_date;
    public String bonus_penalty;
    public double percentage;
    public ArrayList <String> payment_idList = new ArrayList<String>();
    public ArrayList <Date> payment_dateList = new ArrayList<Date>();
    public ArrayList <String> bonus_penaltyList = new ArrayList<String>();
    public ArrayList <Double> percentageList = new ArrayList<Double>();

    public payment_details() {}
    public void clearArrayLists() {
        payment_idList.clear();
        payment_dateList.clear();
        bonus_penaltyList.clear();
        percentageList.clear();
    }
    public void setValExceptPayID(Date payment_date, String bonus_penalty, double percentage)
    {
        this.payment_date = payment_date;
        this.bonus_penalty = bonus_penalty;
        this.percentage = percentage;   
    }
    public int addPaymentDetails() {
        try {
            // connection to database
            String url = "jdbc:mysql://localhost/sys";
            Class.forName ("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "DataCampSQL24!");
            System.out.println("Connection Successful");

            PreparedStatement pstmt = conn.prepareStatement("SELECT CONCAT('PM', LPAD(SUBSTRING(IFNULL(MAX(payment_id), 'PM000'), 3) + 1, 3, '0')) AS newID FROM draftDB.payment_details");
            ResultSet rst = pstmt.executeQuery();
            clearArrayLists();

            while (rst.next()) {
                payment_id = rst.getString("newID");
            }
            pstmt = conn.prepareStatement("INSERT INTO draftDB.payment_details (payment_id, payment_date, bonus_penalty, percentage) VALUE (?, ?, ?, ?)");
            pstmt.setString(1, payment_id);
            pstmt.setDate(2, payment_date);
            pstmt.setString(3, bonus_penalty);
            pstmt.setDouble(4, percentage);

            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
            System.out.println("Successful run!");
        return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    // add other function if needed
}