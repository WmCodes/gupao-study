package com.gupao.vip.singleton.register;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangmeng
 * @date 2019/7/12
 * @desciption
 */
public class RegisterMap {

    private RegisterMap(){}

    private static Map<String,Object> register = new HashMap<>();

    public static RegisterMap getInstance(String name){
        if (name ==null){
            name = RegisterMap.class.getName();
        }
        if (register.get(name) == null){
            try {
                register.put(name, RegisterMap.class.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (RegisterMap)register.get(name);
    }

}
