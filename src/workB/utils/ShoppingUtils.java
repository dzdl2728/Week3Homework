package workB.utils;

import workB.impls.Customer;
import workB.impls.SimpleMerchandise;
import workB.impls.SimpleSuperMarket;
import workB.interfaces.Category;

import workB.interfaces.Merchandise;
import workB.interfaces.SuperMarket;

import java.util.Scanner;

public class ShoppingUtils {
    private static final Scanner in = new Scanner(System.in);

    public static Scanner input() {
        return in;
    }

    public static void output(Object obj) {
        System.out.println(String.valueOf(obj));
    }


    public static SuperMarket createSuperMarket() {
        int merchandisePerCategory = 10;
        Merchandise[] all = new Merchandise[Category.values().length * merchandisePerCategory];

        for (Category category : Category.values()) {
            for (int i = 0; i < merchandisePerCategory; i++) {

                double soldPrice = Math.random() * (category.getHigherPrice() - category.getLowerPrice())
                        + category.getLowerPrice();

                double purchasePrice = soldPrice * 0.7;

                all[category.ordinal() * merchandisePerCategory + i] = new SimpleMerchandise(
                        category.name() + i, soldPrice, purchasePrice, 200, category
                );
            }
        }

        SimpleSuperMarket superMarket = new SimpleSuperMarket(all);
        output("请输入超市的名字：");
        String s = input().next();
        if (s.trim().length() > 0) {
            superMarket.setName(s.trim());
        }
        return superMarket;
    }

    public static Customer createCustomer(boolean auto) {
        if (auto) {
            String custId = "CUST" + (int) (Math.random() * 10000);
            Category shouldBuy = getRandomCategory();
            return new Customer(shouldBuy, custId);

        }
        return null;
    }

    public static Category getRandomCategory() {
        return Category.values()[(int) (Math.random() * 1000) % Category.values().length];
    }

}
