package com.gupao.vip.strategy.pay;

import com.gupao.vip.strategy.pay.payport.PayType;

/**
 * @author wangmeng
 * @date 2019/7/15
 * @desciption 策略模式
 */
public class Order {
    private String uid;
    private String orderId;
    private double amount;


    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    // 不需要switch过程， 也不要写 if else if
    public PayState pay(PayType payType){
       // return payMent.pay(this.uid, this.amount);
        return payType.get().pay(this.uid, this.amount);
    }
}
