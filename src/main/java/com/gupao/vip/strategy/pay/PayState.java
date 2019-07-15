package com.gupao.vip.strategy.pay;

/**
 * @author wangmeng
 * @date 2019/7/15
 * @desciption 支付完成以后状态
 */
public class PayState {

    private int code;
    private Object data;
    private String msg;

    public PayState(int code, String msg, Object data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }


    @Override
    public String toString() {
        return "PayState{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
