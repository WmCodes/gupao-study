package com.gupao.vip.prototype.deep;

import java.io.Serializable;

/**
 * @author wangmeng
 * @date 2019/7/14
 * @desciption
 */
public class JinGuBang  implements Serializable {

    private float h = 100;
    private float d = 10;
    public void big(){
        this.d *=2;
        this.h *=2;

    }

    public void samll(){
        this.d /= 2;
        this.h /= 2;
    }

}
