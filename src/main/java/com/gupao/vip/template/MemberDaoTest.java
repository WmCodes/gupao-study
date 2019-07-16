package com.gupao.vip.template;

import com.gupao.vip.template.dao.MemberDao;

/**
 * @author wangmeng
 * @date 2019/7/15
 * @desciption
 */
public class MemberDaoTest {

    public static void main(String[] args) {

        MemberDao memberDao = new MemberDao(null);
        memberDao.query();

    }
}
