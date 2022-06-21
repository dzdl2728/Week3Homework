package workB;

import workB.impls.Customer;
import workB.impls.SimpleShopman;
import workB.interfaces.*;
import static workB.utils.ShoppingUtils.*;


public class SuperMarketApp {
    public static void main(String[] args) {
        SuperMarket superMarket = createSuperMarket();
        Shopman shopman = new SimpleShopman(superMarket);
        //Customer cus = createCustomer(true);
        boolean open = true;
        while (open) {
            new ShoppingTask(shopman).executeTask();
            output("是否继续营业？(Yes)");
            open = !input().next().trim().equalsIgnoreCase("no");
        }


        superMarket.dailyReport();
    }

}

//
class ShoppingTask {

    private Shopman shopman;

    public ShoppingTask(Shopman shopman) {
        this.shopman = shopman;
    }

    public void executeTask() {
        Customer customer = createCustomer(true);

        shopman.serveCustomer(customer);

    }
}
