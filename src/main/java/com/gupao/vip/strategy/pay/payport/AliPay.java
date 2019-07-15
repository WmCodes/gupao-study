package com.gupao.vip.strategy.pay.payport;

import com.gupao.vip.strategy.pay.PayState;

/**
 * @author wangmeng
 * @date 2019/7/15
 * @desciption
 */
public class AliPay implements PayMent {

    @Override
    public PayState pay(String uid, Double amount) {
        System.out.println("使用支付宝方式支付");
        System.out.println("查询余额，开始扣款");
        return new PayState(200, "支付成功", amount);
    }

}
