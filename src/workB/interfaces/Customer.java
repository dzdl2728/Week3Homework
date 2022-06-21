package workB.interfaces;

public interface Customer {
    String getCustId();

    void startShopping();

    Category chooseCategory();

    int buyMerchandise(Merchandise merchandise);

    boolean wantToCheckout();

    double payFor(ShoppingCart shoppingCart, double totalCost);

    double getMoneySpent();
}
