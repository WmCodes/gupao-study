package com.gupao.vip.prototype.simple;

import java.util.ArrayList;

/**
 * @author wangmeng
 * @date 2019/7/14
 * @desciption
 */
public class Prototype implements Cloneable {

    private String name;

    private ArrayList<CloneTarget> list;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getList() {
        return list;
    }

    public void setList(ArrayList list) {
        this.list = list;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Prototype{" +
                "name='" + name + '\'' +
                ", list=" + list +
                '}';
    }
}
