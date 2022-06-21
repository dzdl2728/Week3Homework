package workA;

import java.util.Date;

public class superMarketApp {
    public static void main(String[] args) {
          Merchandise mer1 =new Merchandise("运动鞋","001",50,100.5,63.8);
          Merchandise mer2 =new Merchandise("饮料","002",30,8.3,3.8);

        Date produceDate = new Date();
        Date expirationDate = new Date(produceDate.getTime() + 365L * 24 * 3600 * 1000);
          Phone ph1 = new Phone("手机","003",10,2000,1000,"麒麟980","华为",produceDate,expirationDate);

        System.out.println(ph1.buy(3));
        System.out.println(ph1.buy(8));//子类实现与父类方法不同功能时
        mer1.describe();
        ph1.describe();//当把父类的super方法注释掉时，仅显示覆盖后信息

    }
}
