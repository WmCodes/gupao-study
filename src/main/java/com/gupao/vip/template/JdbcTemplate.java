package com.gupao.vip.template;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangmeng
 * @date 2019/7/15
 * @desciption
 */
public abstract class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource source){
        this.dataSource = source;
    }

    public  List<Object> executeQuery(String sql,Object [] value){
        try {


            // 1. 获取连接
            Connection connection = dataSource.getConnection();
            // 2.创建语句集
            PreparedStatement pstmt = connection.prepareStatement(sql);
            // 3. 执行语句集，并获得结果集

            ResultSet rs = pstmt.executeQuery();
            // 4 .解析语句集
            List<Object> result = new ArrayList<>();
            int rowNum = 1;
            while (rs.next()){
              result.add(processResult(rs,rowNum++));
            }
            // 5.关闭结果集
            rs.close();
            // 6.关闭语句集
            pstmt.close();;
            // 7. 关闭连接
            connection.close();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public abstract Object processResult(ResultSet rs,int rowNum) throws Exception;
}
