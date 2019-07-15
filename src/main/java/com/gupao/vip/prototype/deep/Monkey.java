package com.gupao.vip.prototype.deep;

import java.util.Date;

/**
 * @author wangmeng
 * @date 2019/7/14
 * @desciption
 */
public class Monkey {

    protected  int height;
    protected  int weight;
    protected Date birthday;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
