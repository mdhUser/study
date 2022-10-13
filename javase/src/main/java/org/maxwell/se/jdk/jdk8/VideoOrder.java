package org.maxwell.se.jdk.jdk8;

/**
 * @description: 视频订单
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/23 21:03
 */
public class VideoOrder {

    private String tradeNo;
    private int money;
    private String title;

    public VideoOrder() {
    }

    public VideoOrder(String tradeNo, String title, int money) {
        this.tradeNo = tradeNo;
        this.money = money;
        this.title = title;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof VideoOrder){
            VideoOrder vo = (VideoOrder) o;
            return title.equals(vo.getTitle());
        }
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public String toString() {
        return "VideoOrder{" +
                "title='" + title + '\'' +
                '}';
    }

}

