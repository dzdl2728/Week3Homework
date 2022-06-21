package workB.impls;


import workB.interfaces.*;
import static workB.utils.ShoppingUtils.*;
public class SimpleShopman implements Shopman {
    private SuperMarket superMarket;

    public SimpleShopman(SuperMarket superMarket) {
        this.superMarket = superMarket;
    }

    private static final int MAX_BUY_DEFAULT = 9;



    @Override
    public void serveCustomer(workB.interfaces.Customer customer) {
        int maxTypeToBuy = MAX_BUY_DEFAULT;
        ShoppingCart shoppingCart = new ShoppingCart(maxTypeToBuy);
        customer.startShopping();
        while (customer.wantToCheckout()&&shoppingCart.canHold()) {
            Category category = customer.chooseCategory();
            // 简单的导购员，顾客说不想买就算了，不做推荐
            if (category == null) {
                continue;
            }
            Merchandise[] toChoose = superMarket.getRandomMerchandiseOfCategory(category);
            // 简单的导购员，一个个推荐，不说从价格高到低推荐之类的小技巧。
            for (Merchandise m : toChoose) {
                if (m == null) {
                    continue;
                }
                int buyCount = customer.buyMerchandise(m);
                if (buyCount > 0) {
                    // 一个类别只买一个商品
                    shoppingCart.add(m, buyCount);
                    break;
                }
            }
        }
        double originCost = shoppingCart.calculateOriginCost();
        double finalCost = originCost;

        double savedMoney = 0;

        double moneyEarned = customer.payFor(shoppingCart, finalCost);

        superMarket.addEarnedMoney(moneyEarned);

        output("顾客" + customer.getCustId() + "购物清单如下：");
        output(shoppingCart.toString());
        output("实付金额为：" + moneyEarned);


    }
}
