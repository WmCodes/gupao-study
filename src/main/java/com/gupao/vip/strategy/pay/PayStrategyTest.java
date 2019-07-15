package com.gupao.vip.strategy.pay;

import com.gupao.vip.strategy.pay.payport.PayType;

/**
 * @author wangmeng
 * @date 2019/7/15
 * @desciption 策略模式测试
 */
public class PayStrategyTest {


    public static void main(String[] args) {
        Order order = new Order("1", "20190715", 123.45);

        // 开始支付，选择微信，支付宝，
        // 每个渠道的支付的具体算法是不一样的
        // 支付的基本算法是固定的
        //System.out.println(order.pay(new AliPay()));
        //System.out.println(order.pay(PayMent.ALI_PAY));
        System.out.println(order.pay(PayType.ALI_PAY));

    }
}
