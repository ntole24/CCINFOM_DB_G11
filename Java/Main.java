
public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello world!");
        suppliers s = new suppliers();
        items i = new items();
        customers c = new customers();
        staff st = new staff();
        purchases pu = new purchases();
        sales sa = new sales();
        jobs j = new jobs();
        payrolls pa = new payrolls();
        returns r = new returns();
        // payment_details pm = new payment_details();
        supplier_item_cost sic = new supplier_item_cost();

        /* .setValExceptSupID("ST104", "OnlyLabs Inc.", "+63-969-420-6869", "sales@OnlyLabs.com", "Muntinlupa City");
        s.addSupplier(); */
        /* c.setValExceptCusID("John Doe", "1234567890", "john.doe@example.com", "New York");
        System.out.println(c.addCustomer()); */

        /* st.setValExceptStaID("Mark Santiago", Date.valueOf("2024-11-21"), null, "J104", "Employed");
        st.addStaff(); */
        /* pu.setValExceptPurID("I100", Date.valueOf("2024-11-21"), 10, Date.valueOf("2026-01-01"));
        pu.addPurchase(); */
        /*sa.setValExceptPurID("C104", "I104", 10, Date.valueOf("2024-11-21"));
        sa.addSale();*/
        /* j.setValExceptJobID("Baker", 15000);
        j.addJob(); */
        /* pa.setValExceptJobID("ST104", "PM101");
        pa.addPayroll(); */
        /* r.setValExceptRetID("ST102", "SA106", "Damaged packaging", Date.valueOf("2024-11-22"));
        r.addReturn(); */
        sic.setVals("I100", "S101", 5);
        sic.addSupplierItemCost();
    }
}