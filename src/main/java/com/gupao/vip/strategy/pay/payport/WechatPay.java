package com.gupao.vip.strategy.pay.payport;

import com.gupao.vip.strategy.pay.PayState;

/**
 * @author wangmeng
 * @date 2019/7/15
 * @desciption
 */
public class WechatPay implements PayMent {
    @Override
    public PayState pay(String uid, Double amount) {
        System.out.println("使用微信方式支付");
        System.out.println("查询余额，开始微信红包扣款");
        return new PayState(200, "支付成功", amount);
    }
}
