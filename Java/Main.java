import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello world!");
        suppliers s = new suppliers();
        items i = new items();
        customers c = new customers();
        staff st = new staff();

        /* .setValExceptSupID("ST104", "OnlyLabs Inc.", "+63-969-420-6869", "sales@OnlyLabs.com", "Muntinlupa City");
        s.addSupplier(); */
        /* c.setValExceptCusID("John Doe", "1234567890", "john.doe@example.com", "New York");
        System.out.println(c.addCustomer()); */

        st.setValExceptStaID("Mark Santiago", Date.valueOf("2024-11-21"), null, "J104", "Employed");
        st.addStaff();
    }
}