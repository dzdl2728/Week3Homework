package workA;

public class Merchandise {
    protected String name;//访问修饰符改为protected保证了安全性且父子类之间依旧可用
    protected String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;

    public Merchandise(String name, String id, int count, double soldPrice, double purchasePrice) {
        this.name = name;
        this.id = id;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
    }
    public void describe() {
        System.out.println("商品名字叫做" + name + "，id是" + id + "。 商品售价是" + soldPrice
                + "。商品进价是" + purchasePrice + "。商品库存量是" + count +
                "。销售一个的毛利润是" + calculateProfit());
    }
    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
        return profit;
    }
    public double buy(int count) {
        if (this.count < count) {
            System.out.println("购买失败，库存不够");
            return -1;
        }
        this.count -= count;
        double cost = count * soldPrice;
        System.out.println("购买成功，花费为" + cost);
        return cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
