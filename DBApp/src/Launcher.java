import java.awt.EventQueue;
import java.sql.Date;

public class Launcher {
    public static void main(String[] args) {
        suppliers s = new suppliers();
        items i = new items();
        customers c = new customers();
        staff st = new staff();
        purchases pu = new purchases();
        sales sa = new sales();
        jobs j = new jobs();
        payrolls pa = new payrolls();
        returns r = new returns();
        payment_details pm = new payment_details();
        supplier_item_cost sic = new supplier_item_cost();
        
        EventQueue.invokeLater(new Runnable() {
            @Override // instructs the compiler that you intend to override a method in the superclass
            // Needed since a subclass (public void run()) needs to define a behavior in a diff. way than the superclass
            public void run() {
                mainFrame sf = new mainFrame();
                Model model = new Model();
                Controller controller = new Controller(sf, model);
                sf.show();
            }
        });
    }
}