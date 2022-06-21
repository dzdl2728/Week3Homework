package workA.interfaces;

import java.util.Date;

public interface ExDateMerchandise {
    default boolean notExpireInDays(int days) {
        return daysBeforeExpire() > days;
    }
    Date getProducedDate();


    public abstract Date getExpireDate();

    private long daysBeforeExpire() {
        return daysBetween(System.currentTimeMillis(), getExpireDate().getTime());
    }

    private long daysAfterProduce() {
        return daysBetween(getProducedDate().getTime(), System.currentTimeMillis());
    }

    public static long daysBetween(long from, long to) {
        long gap = to - from;
        if (gap < 0) {
            return -1;
        }
        return gap / (24 * 3600 * 1000);
    }


}
