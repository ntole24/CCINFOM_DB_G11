public class Model {
    private items i;
    private suppliers s;
    private customers c;
    private purchases pu;
    private supplier_item_cost sic;
    private sales sa;
    private jobs j;
    private staff st;
    private payment_details pm;
    private payrolls pa;
    private returns r;

    public Model() {
        i = new items();
        s = new suppliers();
        c = new customers();
        pu = new purchases();
        sic = new supplier_item_cost();
        sa = new sales();
        j = new jobs();
        st = new staff();
        pm = new payment_details();
        pa = new payrolls();
        r = new returns();
    }

    public void purchaseItems(String itemName, String supplierName, double pricePerItem, int quantity) {
        // Get the item_id from the item name
        String itemID = i.getIDFromName(itemName);
        System.out.println(itemID);
        
        // Get the supplier id from the supplier name
        String supplierID = s.getIDFromName(supplierName);
        System.out.println(supplierID);


        // if they both exist (and the supplier sells the item) check the ff:
        if (!itemID.isEmpty() && !supplierID.isEmpty() && sic.getItemSupplierComboPrice(itemID, supplierID) > 0) {
            System.out.println(sic.getItemSupplierComboPrice(itemID, supplierID));
        }
        else
            System.out.println("Combo does not exist");
            // get the price per item

            // calculate the total price (using price per item and given quantity)

            // update items with quantity

            // update purchases with all the details gathered here
    }

    public boolean validateInputs(String[] inputs, int frame, int chosenOptionIndex) {
        if (frame == 0) {
            
        }
        else if (frame == 1) {
            switch (chosenOptionIndex) {
                case 0:
                    // items, staff, price/item, quantity

                    break;
                case 1:
                    // items, customer, selling price/item, quantity
                    break;
                case 2:
                    // payday date, bonus_deduction, percentage, null
                    break;
                case 3:
                    // sale_id, customer_id, reason for return, null
                    break;
            }
        }
        else if (frame == 2) {

        }

        return true;
    }
}
