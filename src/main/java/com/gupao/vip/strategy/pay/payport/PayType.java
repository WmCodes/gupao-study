package com.gupao.vip.strategy.pay.payport;

/**
 * @author wangmeng
 * @date 2019/7/15
 * @desciption
 */
public enum PayType {
    ALI_PAY(new AliPay()),WECHAT_PAY(new WechatPay());


    private PayMent payMent;
    PayType(PayMent payMent) {
        this.payMent = payMent;
    }


    public PayMent get(){
        return  this.payMent;
    }
}
