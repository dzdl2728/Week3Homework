package workB.impls;

import workB.interfaces.Category;
import workB.interfaces.Merchandise;
import workB.interfaces.ShoppingCart;

import static workB.utils.ShoppingUtils.getRandomCategory;

public class Customer implements workB.interfaces.Customer {
    private Category shouldBuy;
    private String custId;
    private double moneySpent;
    private int guangLeft = 0;
    private int guangCount = 1;

    public static final int DEFAULT_GUANG_COUNT = 5;

    public Customer(Category shouldBuy, String custId) {
        this.shouldBuy = shouldBuy;
        this.custId = custId;
        //this.guangCount = guangCount;
    }

    @Override
    public String getCustId() {
        return custId;
    }

    @Override
    public void startShopping() {
        guangLeft = guangCount;
    }

    @Override
    public Category chooseCategory() {
//        if (guangLeft + 1 >= guangCount) {
//            return shouldBuy;
//        } else {
//            return getRandomCategory();
//        }
        return shouldBuy;
    }

   @Override
   public int buyMerchandise(Merchandise merchandise) {
       Category category = merchandise.getCategory();

       double soldPrice = merchandise.getSoldPrice();

       double avgPrice = (category.getHigherPrice() + category.getLowerPrice()) / 2;
       if (soldPrice < avgPrice) {
           return 1;
       } else {
           return 0;
       }
   }

    @Override
    public boolean wantToCheckout() {
       return  true;
    }

    @Override
    public double payFor(ShoppingCart shoppingCart, double totalCost) {
        moneySpent += totalCost;
        return totalCost;
    }

    @Override
    public double getMoneySpent() {
        return moneySpent;
    }
}
