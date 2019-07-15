package com.gupao.vip.strategy.pay.payport;

import com.gupao.vip.strategy.pay.PayState;

/**
 * @author wangmeng
 * @date 2019/7/15
 * @desciption 支付渠道
 */
public interface PayMent {

/*    public final  static PayMent ALI_PAY = new AliPay();
    public final  static PayMent WECHAT_PAY = new WechatPay();*/
    public PayState pay(String uid, Double amount);
}
