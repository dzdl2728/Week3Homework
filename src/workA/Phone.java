package workA;

import workA.interfaces.ExDateMerchandise;

import java.util.Date;

//Phone继承Merchandise
public class Phone extends Merchandise implements ExDateMerchandise{

    private Date produceDate;
    private Date expirationDate;


    private String cpuZ;
    private String brand;
    private static int MAX_BUY_ONE_ORDER = 5;
//如果父类存在有参的构造器，子类需要实现(super)
    public Phone(String name, String id, int count, double soldPrice, double purchasePrice, String cpuZ, String brand,Date produceDate, Date expirationDate) {
        super(name, id, count, soldPrice, purchasePrice);//super的使用！
        this.cpuZ = cpuZ;
        this.brand = brand;
        this.produceDate=produceDate;
        this.expirationDate=expirationDate;
    }

    public double buy(int count) {
        if (count > MAX_BUY_ONE_ORDER) {
            System.out.println("购买失败，手机一次最多只能买" + MAX_BUY_ONE_ORDER + "个");
            return -2;
        }
        return super.buy(count);
    }

    public String getName() {
        return this.brand  + ":" + super.getName();
    }

    public void describe() {
        System.out.println("此手机商品属性如下");
        super.describe();//super会调用父类中的方法
        System.out.println("手机厂商为" + brand + "cpu主频" + cpuZ );
    }
//接口中会强制覆盖@Override
    @Override
    public Date getProducedDate() {
        return produceDate;
    }

    @Override
    public Date getExpireDate() {
        return expirationDate;
    }
}




