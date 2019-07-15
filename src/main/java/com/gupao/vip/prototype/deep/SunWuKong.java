package com.gupao.vip.prototype.deep;

import java.io.*;
import java.util.Date;

/**
 * @author wangmeng
 * @date 2019/7/14
 * @desciption
 */
public class SunWuKong extends Monkey implements Cloneable,Serializable{

    public JinGuBang jinGuBang;

    public SunWuKong(){
        this.birthday = new Date();
        this.jinGuBang = new JinGuBang();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
        //return deepCloe();
    }

    public Object deepCloe(){

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            SunWuKong copy = (SunWuKong)ois.readObject();
            copy.birthday = new Date();
            return copy;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
