package com.gupao.vip.template.dao;

import com.gupao.vip.template.JdbcTemplate;
import com.gupao.vip.template.entity.Member;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author wangmeng
 * @date 2019/7/15
 * @desciption
 */
public class MemberDao extends JdbcTemplate {

    public MemberDao(DataSource source) {
        super(source);
    }

    public List<Object> query(){
        String sql = "select * from t_member";
        return super.executeQuery(sql, null);
    }

    @Override
    public Object processResult(ResultSet rs,int rowNum)throws Exception {
        Member member = new Member();
        member.setUsername(rs.getString("username"));
        member.setPassword(rs.getString("password"));
        member.setAge(rs.getInt("age"));
        member.setAddr(rs.getString("addr"));
        return member;
    }

}
