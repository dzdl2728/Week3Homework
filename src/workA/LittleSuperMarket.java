package workA;

import workA.Merchandise;

public class LittleSuperMarket   {
    public String superMarketName;
    public String address;
    public double incomingSum;
    public Merchandise[] merchandises;
    public int[] merchandiseSold;

    public LittleSuperMarket(String superMarketName, String address, int parkingCount,
                             int merchandiseCount, int count) {
        this.superMarketName = superMarketName;
        this.address = address;


        merchandises = new Merchandise[merchandiseCount];
        for (int i = 0; i < merchandises.length; i++) {
            double purchasePrice = Math.random() * 200;
            // 创建并给商品的属性赋值
            Merchandise m = new Merchandise(
                    "商品" + i,
                    "ID" + i,
                    count,
                    purchasePrice * (1 + Math.random()),
                    purchasePrice
            );
            // 用创建的商品，给商品数组的第i个引用赋值，all和小超市的商品数组引用指向的是同一个数组对象
            merchandises[i] = m;
        }
        merchandiseSold = new int[merchandises.length];
    }

    public String getSuperMarketName() {
        return superMarketName;
    }

    public void setSuperMarketName(String superMarketName) {
        this.superMarketName = superMarketName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getIncomingSum() {
        return incomingSum;
    }

    public void setIncomingSum(double incomingSum) {
        this.incomingSum = incomingSum;
    }

    public Merchandise[] getMerchandises() {
        return merchandises;
    }

    public void setMerchandises(Merchandise[] merchandises) {
        this.merchandises = merchandises;
    }

    public int[] getMerchandiseSold() {
        return merchandiseSold;
    }

    public void setMerchandiseSold(int[] merchandiseSold) {
        this.merchandiseSold = merchandiseSold;
    }
}
